pipeline {
  agent any
  stages {
    stage('testing trigger') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
  }
}