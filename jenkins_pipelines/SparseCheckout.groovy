node('master') {

    sh 'pwd'
    def core = load "jenkins_pipelines/JenkinsCore.groovy"
    core.foo()
}