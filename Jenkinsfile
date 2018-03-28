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

        def currDate = new Date().format("dd-MM-yyy:")
        def lastCommitName = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        def currBuildFolderName = currDate + lastCommitName

        return {
            sh 'scp target/*.jar root@80.211.135.72:/var/lib/demo'
            ssh('mkdir /var/lib/demo/' + currBuildFolderName)
            ssh('cd /var/lib/demo /var/lib/demo/' + currBuildFolderName)
        }
    }

    stage('Restart service') {
        sh 'ssh root@80.211.135.72 \'systemctl restart demo\''
    }
}

def ssh(command) {
    sh 'ssh root@80.211.135.72 \'' + command + '\''
}