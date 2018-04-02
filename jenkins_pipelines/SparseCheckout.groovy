node('master') {

    sh 'pwd'
    input message: 'Approve build?', submitter: 'admin_group'
    def core = load "jenkins_pipelines/JenkinsCore.groovy"
    core.foo()
}