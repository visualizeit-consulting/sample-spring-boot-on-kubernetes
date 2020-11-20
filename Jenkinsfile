pipeline {
	agent {
		label "default"
	}
	stages {
		stage('Checkout') {
			steps {
				script {
					git url: 'https://github.com/visualizeit-consulting/sample-spring-boot-on-kubernetes.git', credentialsId: 'github_credentials'
					sh 'ls -la'
				}
			}
		}
		stage('Build') {
			agent {
				label "maven"
			}
			steps {
				sh 'ls -la'
				sh 'mvn -version'
				sh 'mvn clean compile -X'
			}
		}
		stage('Test') {
			agent {
				label "maven"
			}
			steps {
				sh 'mvn test'
			}
		}
		stage('Sonar') {
			agent {
				label "maven"
			}
			steps {
				sh 'mvn initialize sonar:sonar -Dsonar.host.url=http://sonarqube-sonarqube.sonarqube.svc.cluster.local:9000'
			}
		}
		stage('Image') {
			agent {
				label "maven"
			}
			steps {
				withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'HUBUSER', passwordVariable: 'HUBPASS')]) {
					sh 'mvn -P jib -Djib.to.auth.username=${HUBUSER} -Djib.to.auth.password=${HUBPASS} compile jib:build'
				}
			}
		}
		stage('Deploy on test') {
		    agent {
		        label "maven"
		    }
			steps {
				script {
					env.PIPELINE_NAMESPACE = "test"
					kubernetesDeploy kubeconfigId: 'k8s', configs: 'k8s/deployment-template.yaml'
				}
			}
		}
		stage('Deploy on prod') {
			steps {
				script {
					env.PIPELINE_NAMESPACE = "prod"
					kubernetesDeploy kubeconfigId: 'k8s', configs: 'k8s/deployment-template.yaml'
				}
			}
		}
	}
}