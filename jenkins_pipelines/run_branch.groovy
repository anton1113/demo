
node('master') {

    def userInput
    serviceDeployer.method()

    stage('input') {
        userInput = input(
                id: 'userInput', message: 'Please enter the branch name', parameters: [
                [$class: 'TextParameterDefinition', description: 'Name of the branch to build', name: 'branch name']
        ])
        echo ("Branch name: " + userInput)
    }

    def branchName = userInput


    def core = load "jenkins_pipelines/core.groovy"
    //core.build()
    core.restart()
}