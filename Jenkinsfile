pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/ballachakri/CucumberHybridFramework.git'

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

           post {
                always {
                    cucumber buildStatus: 'UNSTABLE', 
                    reportTitle: 'My Report',
                    fileIncludePattern: '**/*.json', 
                    sortingMethod: 'ALPHABETICAL', 
                    trendsLimit: 100
               }

        }
    }
}
}
