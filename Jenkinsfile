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

       
        stage('Deploy to GKE') {
            steps{
                sh "sed -i 's#gcr.io/my-sample-project-270014/spring-boot-example:v1#g' deployment.yaml"
                step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, zone: env.LOCATION, manifestPattern: 'deployment.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
            }
        }
    }    
}
