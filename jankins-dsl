job('Nodejs automated pipeline') {
  scm {
    git('https://github.com/ankush99verma/jenkinsdemo.git') {
      node / gitConfigName('DSL User')
      node / gitConfigEmail('v99ankush@gmail.com')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
    node.js('nodejs')
  }
  steps {
    shell('npm install')
  }
} 
