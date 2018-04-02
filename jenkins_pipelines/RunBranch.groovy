node('master') {
    String branchName = promptBranchName()
    def core = load "jenkins_pipelines/JenkinsCore.groovy"
    core.restart()
}

static String promptBranchName() {

    String branchName = 'master'
    stage('input') {
        branchName = input(
                id: 'userInput', message: 'Please enter the branch name', parameters: [
                [$class: 'TextParameterDefinition', description: 'Name of the branch to build', name: 'branch name']
        ])
        echo ("Branch name: ${userInput} ")
    }
    return branchName
}