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
