pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t srinithyareddy1/apiratelimiter .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([string(credentialsId: 'docker-pass', variable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u srinithyareddy1 --password-stdin'
                    sh 'docker push srinithyareddy1/apiratelimiter'
                }
            }
        }
    }
}