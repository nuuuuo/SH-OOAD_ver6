pipeline {
    agent any

    
    
    stages {

        stage('github clone') {
                steps {
                   git branch: 'main', credentialsId: 'tintin010',
                       url: 'https://github.com/KU-OOAD/DVM.git'
            }
        }
        
        stage('Build') {
            steps {
                 sh '''
                        echo build start
                        ./gradlew clean bootJar
                    '''
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
