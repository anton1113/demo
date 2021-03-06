node('master') {

    sh 'rm -r *'
    sh 'pwd'
    sh 'ls -1'

    stage('Git checkout') {
        checkout([$class: 'GitSCM', branches: [[name: 'c04697c']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId: 'e404b1e5-89f9-4f62-ade7-aa5bcd182b55', url: 'https://anton1113@github.com/anton1113/demo.git']],
                  sparseCheckoutPaths: [['jenkins_pipelines/']]])
    }

    sh 'pwd'
    sh 'ls -1'
    stage('error') {
        error('This is an error')
    }
    def core = load "jenkins_pipelines/JenkinsCore.groovy"
    core.foo()
}