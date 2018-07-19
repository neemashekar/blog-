pipeline {
  agent any
  stages {
    stage('mvn Clean') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('deploy') {
      steps {
        sh 'mvn tomcat7: deploy'
      }
    }
  }
}