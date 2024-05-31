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
                    '''
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Testing..."'
                // 테스트 스크립트 추가합니다
            }
        }
        stage('Deploy') {
            steps {
                // 빌드된 JAR 파일을 배포 디렉토리로 복사합니다.
                sh 'cp /path/to/your/application/build/libs/*.jar /home/ec2-user/deploy/'

                // 현재 구동 중인 애플리케이션을 종료합니다.
                script {
                    def currentPid = sh(script: 'ps -ef | grep java | grep dokotlin | awk \'{print $2}\'', returnStdout: true).trim()
                    if (currentPid) {
                        sh "kill -9 $currentPid"
                        sleep 10
                    }
                }

                // 새로운 애플리케이션을 실행합니다.
                sh 'nohup java -jar /home/ec2-user/deploy/*.jar >> /home/ec2-user/deploy/application.log 2>&1 &'
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
