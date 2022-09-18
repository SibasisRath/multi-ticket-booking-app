pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git "https://tools.publicis.sapient.com/bitbucket/scm/psimay/shubh-banking-system.git"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn clean package"
            }
        }
    }
 }