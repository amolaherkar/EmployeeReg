pipeline {
    agent any
    environment {
        PROJECT_ID = 'my-sample-project-270014'
        CLUSTER_NAME = 'my-cluster-1'
        LOCATION = 'us-central1-c'
        CREDENTIALS_ID = 'GKE'
    }
    stages {
        stage("Checkout code") {
            steps {
                checkout scm
            }
        }
        stage("Build image") {
            steps {
                script {
                    myapp = docker.build("amolaherkar/my-springboot-example:${env.BUILD_ID}")
                }
            }
        }
       
        stage('Deploy to GKE') {
            steps{
                sh "sed -i 'gcr.io/my-sample-project-270014/spring-boot-example:v15' deployment.yaml"
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, zone: env.LOCATION, manifestPattern: 'deployment.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
            }
        }
    }    
}
