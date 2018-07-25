pipeline {
  agent any
  stages {
    stage('MVN Build') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }
    stage('Tomcat') {
      steps {
        sh 'sudo service tomcat start'
      }
    }
    stage('deploy') {
      steps {
        sh 'mvn tomcat7:deploy'
      }
    }
  }
}