pipeline {
    agent any

    parameters {
        string(name: 'TAGS', defaultValue: '@smoke', description: 'Cucumber tags')
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -Dcucumber.filter.tags=${params.TAGS}"
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}