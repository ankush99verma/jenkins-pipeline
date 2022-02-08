job('Nodejs example'){
  scm{
    git('https://github.com/ankush99verma/jenkinsdemo.git'){
      node / gitconfigname('DSL User')
      node / gitconfigEmail('v99ankush@gmail.com')
    }
  }
  triggers{
    scm('H/5 * * * *')
  }
  wrappers{
    nodejs('nodejs')
  }
  steps{
    jsLint {
      includePattern('**/*.js')
      logFile('jslint.xml')
      arguments('-Dadsafe=true, -Dcontinue=true')
    }
    
  }
}
