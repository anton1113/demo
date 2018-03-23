node('master') {

    stage('Package jars') {
        sh 'echo package jars'
        sh 'mvn clean install -am -pl demo'
        archiveArtifacts artifacts: 'target/*.jar'
    }
}