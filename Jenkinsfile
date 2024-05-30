pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh 'echo "Building..."'
                // 빌드 스크립트 추가
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Testing..."'
                // 테스트 스크립트 추가
            }
        }
        stage('Deploy') {
            steps {
                sshagent(['your-credentials-id']) {
                    sh '''
                    ssh -o StrictHostKeyChecking=no ec2-user@your-ec2-instance-public-dns <<EOF
                    # 배포 디렉토리로 이동
                    cd /path/to/deployment/directory
                    # 기존 아티팩트 백업
                    mv artifact.jar artifact.jar.bak
                    # 빌드된 아티팩트 복사.
                    cp /path/to/build/artifact.jar ./
                    # 기존 프로세스 종료
                    pkill -f 'java -jar artifact.jar'
                    # 새 프로세스 시작
                    nohup java -jar artifact.jar > output.log 2>&1 &
                    EOF
                    '''
                }
            }
        }
    }
    
    post {
        success {
            echo 'Build and test succeeded!'
        }
        failure {
            echo 'Build or test failed!'
        }
        always {
            echo 'End of pipeline'
        }
    }
}
