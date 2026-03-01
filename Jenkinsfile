pipeline {
    agent any

  
    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dexecution=remote'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}