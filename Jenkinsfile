pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'My first pipeline'
                git 'https://github.com/mukhou/MyFirstSpring.git'
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}