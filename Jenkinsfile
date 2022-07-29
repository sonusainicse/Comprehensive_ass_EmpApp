pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage('Build jar file') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/sonusainicse/Comprehensive_ass_EmpApp.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage("Build docker image"){
            steps{
                sh "docker build -t sonusainicse0798/myemployee:${BUILD_NUMBER} ."
            }
        }
         stage("Docker hub login"){
            steps{
                withCredentials([usernamePassword(credentialsId: 'DockerhubeCredintial', passwordVariable: 'pswd', usernameVariable: 'user')]) {
                    sh "docker login -u ${user} -p ${pswd}"
                     }
                
            }
        }
        
         stage("push docker image to docker hub"){
            steps{
                sh "docker push sonusainicse0798/myemployee:${BUILD_NUMBER}"
            }
        }
    
          
    }
    
    
}
