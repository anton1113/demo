node('master') {

    stage('Package jars') {
        sh 'echo package jars'
        sh 'mvn clean install'
        archiveArtifacts artifacts: 'target/*.jar'
    }
}