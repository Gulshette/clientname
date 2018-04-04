package com.clientname.components.content.sample

/**
 * Created by icf2025840 on 04/04/18.
 */
class GroovyApp {

       def noOfPages = 0
       def path='/content/geometrixx/en/'
  def findAllPages(){
        getPage(path).recurse
                { page ->
                    println 'Title:'+page.title
                    println 'Path:'+page.path
                    noOfPages ++
                }
    }
}
