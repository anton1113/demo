var foo = "Some static text"

def build() {

    println foo

    stage('Package jars') {
        sh 'mvn clean install'
        archiveArtifacts artifacts: 'target/*.jar'
    }

    stage('Transfer jars') {

        def currDate = new Date().format("yyyy-MM-dd")
        def lastCommitName = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        def currBuildFolderName = currDate + lastCommitName

        sh 'scp target/*.jar root@80.211.135.72:/var/lib/demo'
        ssh('mkdir /var/lib/demo/' + currBuildFolderName)
        ssh('cp /var/lib/demo/demo-0.jar /var/lib/demo/' + currBuildFolderName)
    }
}

def restart() {

    stage('Restart service') {
        sh 'ssh root@80.211.135.72 \'systemctl restart demo\''
    }
}

def getCommitHashAndDate() {

    stage('Commit hash/date input') {
        def userInput = input(
                id: 'userInput', message: 'Please enter the parameters', parameters: [
                [$class: 'TextParameterDefinition', description: 'Hash of the desired commit', name: 'commit hash'],
                [$class: 'TextParameterDefinition', description: 'Date of the desired build (dd-MM-yyyy)', name: 'build date']
        ])
    }
    return userInput
}

def ssh(command) {
    sh 'ssh root@80.211.135.72 \'' + command + '\''
}

return this