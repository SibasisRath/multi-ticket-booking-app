pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git "https://github.com/SibasisRath/multi-ticket-booking-app.git"
            }
        }
        
         stage("package"){
            steps{
            sh "mvn clean package"
            }
        }
    }
 }
