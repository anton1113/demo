
def build() {

    stage('Package jars') {
        sh 'mvn clean install'
        archiveArtifacts artifacts: 'target/*.jar'
    }

    stage('Transfer jars') {
        sh 'scp target/*.jar root@80.211.135.72:/var/lib/demo'
    }
}

def restart() {

    stage('Restart service') {
        sh 'ssh root@80.211.135.72 \'systemctl restart demo\''
    }
}

return this