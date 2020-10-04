pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'My first pipeline'
                git 'https://github.com/mukhou/MyFirstSpring.git'
                sh './mvnw package'
            }
        }
    }
}