node('master') {

    stage('Git checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId: 'e404b1e5-89f9-4f62-ade7-aa5bcd182b55', url: 'https://anton1113@github.com/anton1113/demo.git']]])
    }

    stage('Package jars') {
        sh 'echo package jars'
        sh 'mvn clean install'
        archiveArtifacts artifacts: 'target/*.jar'
    }

    stage('Transfer jars') {
        sh 'scp target/*.jar root@80.211.135.72:/var/lib/demo/'
    }

    stage('Restart service') {
        sh 'ssh root@80.211.135.72 \'systemctl restart demo\''
    }
}