pipeline {
    agent {
        docker {
            image 'maven'
            args '-v "C:/Users/WagnerPires/.m2":/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}