pipeline { 
    agent any 
    stages {
        stage('Compile Stage') { 
            steps { 
                withMaven(maven : 'maven_3.5.3') {
                   sh 'mvn clean compile'
                }
            }
        }
        stage('Testing stage'){
            steps {
                 withMaven(maven : 'maven_3.5.3') {
                   sh 'mvn test'
                }
            }
        }
        stage('Deployment stage') {
            steps {
                 withMaven(maven : 'maven_3.5.3') {
                   sh 'mvn deploy'
                }
            }
        }
    }
}