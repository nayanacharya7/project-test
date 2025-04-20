pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'myapp'
        DOCKER_REGISTRY = 'docker.io/nayan1103'
        K8S_NAMESPACE = 'default'
        DOCKER_USERNAME = credentials('nayan1103')  // Jenkins credentials ID for Docker username
        DOCKER_PASSWORD = credentials('Gopala@1980')  // Jenkins credentials ID for Docker password
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/nayanacharya7/project-test.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    // Use Maven to build the project
                    sh 'mvn clean install'
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    // Build Docker image
                    sh 'docker build -t ${DOCKER_IMAGE_NAME}:${BUILD_ID} .'
                }
            }
        }

        stage('Push to Docker Registry') {
            steps {
                script {
                    // Log in to Docker registry
                    sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'

                    // Push the Docker image to the registry
                    sh 'docker push ${DOCKER_IMAGE_NAME}:${BUILD_ID}'
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Update the Kubernetes Deployment
                    sh """
                    kubectl set image deployment/your-deployment ${DOCKER_IMAGE_NAME}=${DOCKER_REGISTRY}/${DOCKER_IMAGE_NAME}:${BUILD_ID} -n ${K8S_NAMESPACE}
                    kubectl rollout status deployment/your-deployment -n ${K8S_NAMESPACE}
                    """
                }
            }
        }
    }
}
