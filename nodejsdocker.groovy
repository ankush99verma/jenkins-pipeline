job('Nodejs automated pipeline') {
  scm {
    git('https://github.com/ankush99verma/jenkinsdemo.git') {
      node / gitConfigName('DSL User')
      node / gitConfigEmail('vankush@gmail.com')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
    nodejs('nodejs')
  }
  steps {
    dockerBuildAndPublish {
      repositoryName('verma99ankush/jenkins-build-repo')
      tag('${GIT_REVISION, length=9}')
      registryCredentials('dockerhub')
      forcePull(false)
      forceTag(false)
      createFingerprints(false)
      skipDecorate()
    }
    
  }
}
