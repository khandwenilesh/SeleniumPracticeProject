pipeline {
    agent any

    parameters {
                 string(name: 'TAGS', defaultValue: '@smoke', description: 'Cucumber tags')
             }
    stages {



           stages {
               stage('Run Tests') {
                   steps {
                       sh 'mvn clean test -Dcucumber.filter.tags=${TAGS}'
                   }


             stage('Publish Test Results') {
                steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}