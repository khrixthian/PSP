pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'this is a minimal pipeline'
        sh 'mvn package'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

  }
}