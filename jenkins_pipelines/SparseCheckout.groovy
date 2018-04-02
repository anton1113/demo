node('master') {

    sh 'pwd'
    sh 'ls -1'
    def core = load "jenkins_pipelines/JenkinsCore.groovy"
    core.foo()
}