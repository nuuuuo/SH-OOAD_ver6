// pipeline {
//     agent any

    
    
//     stages {

//         stage('github clone') {
//                 steps {
//                    git branch: 'main', credentialsId: 'tintin010',
//                        url: 'https://github.com/KU-OOAD/DVM.git'
//             }
//         }
        
//         stage('Build') {
//             steps {
//                  sh '''
//                         echo build start
//                     '''
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh 'echo "Testing..."'
//                 // 테스트 스크립트 추가합니다!
//             }
//         }
//         stage('Deploy') {
//             steps {
//                 // 빌드된 JAR 파일을 배포 디렉토리로 복사합니다.
//                 // sh 'cp /path/to/your/application/build/libs/*.jar /home/ec2-user/deploy/'
        
//                 // 배포 디렉토리의 권한을 확인합니다.
//                 // sh 'ls -l /home/ec2-user/deploy/'
        
//                 // 현재 구동 중인 애플리케이션을 종료합니다.
//                 script {
//                     def currentPid = sh(script: 'ps -ef | grep java | grep dokotlin | awk \'{print $2}\'', returnStdout: true).trim()
//                     if (currentPid) {
//                         sh "kill -9 $currentPid"
//                         sleep 10
//                     }
//                 }
        
//                 // 새로운 애플리케이션을 실행합니다.
//                 // sh 'nohup java -jar /home/ec2-user/deploy/*.jar >> /home/ec2-user/deploy/application.log 2>&1 &'
//             }
//         }
//     }
    
//     post {
//         success {
//             echo 'Build and test succeeded!'
//         }
//         failure {
//             echo 'Build or test failed!'
//         }
//         always {
//             echo 'End of pipeline'
//         }
//     }
// }



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
                sh 'chmod +x ./gradlew'  // gradlew 파일에 실행 권한 추가
                sh './gradlew build'     // 빌드 실행
            }
        }
        
        stage('Test') {
            steps {
                sh 'echo Testing...'
                sh './gradlew test'  // 실제 테스트 명령어를 여기에 추가
            }
        }
        
        stage('Deploy') {
            steps {
                sshagent(['tintin010']) {
                    sh '''
                    ssh -o StrictHostKeyChecking=no ec2-user@ec2-43-202-61-53.ap-northeast-2.compute.amazonaws.com << EOF
                    cd /path/to/deployment/directory  # 실제 배포 디렉토리 경로
                    cp /var/lib/jenkins/workspace/jenkins0531/build/libs/*.jar .  # 실제 빌드 파일 경로
                    currentPid=$(ps -ef | grep java | grep dokotlin | awk '{print $2}')
                    if [ -n "$currentPid" ]; then
                        kill -9 $currentPid
                        sleep 10
                    fi
                    nohup java -jar *.jar >> application.log 2>&1 &
                    EOF
                    '''
                }
            }
        }
    }
    
    post {
        success {
            echo 'Build, test, and deploy succeeded!'
        }
        failure {
            echo 'Build, test, or deploy failed!'
        }
        always {
            echo 'End of pipeline'
        }
    }
}





