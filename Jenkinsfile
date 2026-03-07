pipeline {
    agent any

  
    stages {

       parameters {
               string(name: 'TAGS', defaultValue: '@smoke', description: 'Cucumber tags')
           }

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