pipeline {
    agent {
        docker {
            image 'maven'
            args '-v "/home/wagnerpires/.m2":/root/.m2'
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
