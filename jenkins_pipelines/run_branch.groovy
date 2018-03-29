node('master') {

    def userInput

    stage('input') {
        userInput = input(
                id: 'userInput', message: 'Please enter the branch name', parameters: [
                [$class: 'TextParameterDefinition', description: 'Name of the branch to build', name: 'branch name'],
        ])
    }

    def branchName = userInput['branch name']

    stage('Git checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/' + branchName]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId: 'e404b1e5-89f9-4f62-ade7-aa5bcd182b55', url: 'https://anton1113@github.com/anton1113/demo.git']]])
    }

    def core = load "jenkins_pipelines/core.groovy"
    core.build()
    core.restart()
}