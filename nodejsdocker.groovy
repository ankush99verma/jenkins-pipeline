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
    node.js('nodejs')
  }
  steps {
    dockerBuildAndPublish {
      repositoryName('ankush99verma/jenkins-pipeline')
      tag('${GIT_REVISION, length=9}')
      registryCredentials('dockerhub')
      forcePull(false)
      forceTag(false)
      createFingerprints(false)
      skipDecorate()
    }
    
  }
}
