
pipeline {
	agent {
		label "maven"
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
			steps {

				sh 'ls -la'
				sh 'mvn -version'
				sh 'mvn clean compile -X'
			}
		}
		stage('Test') {
			steps {
				sh 'mvn test'
			}
		}
// 		stage('Sonar') {
// 			agent {
// 				label "maven"
// 			}
// 			steps {
// 				sh 'mvn initialize sonar:sonar -Dsonar.host.url=http://sonarqube-sonarqube.sonarqube.svc.cluster.local:9000'
// 			}
// 		}
// 		stage('Image') {
// 			steps {
// 				withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'HUBUSER', passwordVariable: 'HUBPASS')]) {
// 					sh 'mvn -P jib -Djib.to.auth.username=${HUBUSER} -Djib.to.auth.password=${HUBPASS} compile jib:build'
// 				}
// 			}
// 		}
// 		stage('Deploy on test') {
// 		    steps {
// 		        withKubeConfig([credentialsId: 'k8s-username-password']) {
//                   sh '/home/jenkins/kubectl -n test set image deploy sample-spring-boot-on-kubernetes-deployment sample-spring-boot-on-kubernetes=visualizeitc2/sample-spring-boot-on-kubernetes:latest '
//                  }
//             }
// // 			steps {
// // 				script {
// // 					env.PIPELINE_NAMESPACE = "test"
// // 					kubernetesDeploy kubeconfigId: 'k8s', configs: 'k8s/deployment-template.yaml'
// // 				}
// // 			}
// 		}
// 		stage('Deploy on prod') {
// 		    steps {
// 		        withKubeConfig([credentialsId: 'k8s-username-password']) {
//                   sh '/home/jenkins/kubectl -n test set image deploy sample-spring-boot-on-kubernetes-deployment sample-spring-boot-on-kubernetes=visualizeitc2/sample-spring-boot-on-kubernetes:latest '
//                  }
//             }
// //
// // 			steps {
// // 				script {
// // 					env.PIPELINE_NAMESPACE = "prod"
// // 					kubernetesDeploy kubeconfigId: 'k8s', configs: 'k8s/deployment-template.yaml'
// // 				}
// // 			}
// 		}
	}
}
