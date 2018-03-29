node('master') {

    def userInput
    def folderName

    stage('input') {
        userInput = input(
                id: 'userInput', message: 'Please enter the parameters', parameters: [
                [$class: 'TextParameterDefinition', description: 'Hash of the desired commit', name: 'commit hash'],
                [$class: 'TextParameterDefinition', description: 'Date of the desired build (dd-MM-yyyy)', name: 'build date']
        ])
        echo ("Commit hash: "+userInput['commit hash'])
        echo ("Commit date: "+userInput['build date'])
    }

    stage('getFolderName') {
        def commitHash = userInput['commit hash']
        def buildDate = userInput['build date']
        def grepParam = commitHash != null && !commitHash.isEmpty() == 7 ? commitHash : buildDate
        echo ("Grep param: " + grepParam)
        folderName = sh(script: 'ssh root@80.211.135.72 \'ls /var/lib/demo | grep ' + grepParam + ' | tail -1\'', returnStdout: true)
        echo folderName
    }

    stage('deploy') {
        String folder = folderName
        folder = folder.trim()
        def copyJar = 'cp /var/lib/demo/' + folder + '/demo-0.jar /var/lib/demo'
        def restart = 'systemctl restart demo'

        ssh(copyJar)
        ssh(restart)
    }
}

def ssh(command) {

    sh(script: 'ssh root@80.211.135.72 \'' + command + '\'')
}