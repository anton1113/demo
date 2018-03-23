node('master') {

     stage('Package jars') {
                sh 'echo package jars'
                sh 'mvn clean install -DskipTests=true -am -pl ' + mavenModules
                archiveArtifacts artifacts: 'target/*.jar'
            }
}