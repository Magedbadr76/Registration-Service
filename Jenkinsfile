pipeline {
    agent any
 
    stages {
        stage('Build') {
            steps {
                // Build your Spring Boot application using Maven
                echo 'Runing Build Automation'
                sh 'mvn clean package'
            }
        }
        stage('Deploy') {
             when {
                branch 'main'
            }
            steps {
               input 'Does the staging environment look OK?'
                milestone(1)
                // Use the Publish Over SSH plugin to transfer the JAR file to the deployment server
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'staging', transfers: [
                        sshTransfer(execCommand: '' ,
                                    execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/app/Genesys/apache-tomcat-8.5.70/webapps', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'target/*.war')
                    ])
                ])
            }
        }

          stage('Clean') {
        steps {
            // Use SSH to remove the existing WAR file
            sshCommand(
                remote: 'staging',
                command: "rm /app/Genesys/apache-tomcat-8.5.70/webapps/Registeration-service-0.0.1-SNAPSHOT.war"
            )
        }
    }
    }
}
