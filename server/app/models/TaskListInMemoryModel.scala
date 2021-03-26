package models

import scala.collection.mutable

object TaskListInMemoryModel {

  private val users: mutable.Map[String, String] =  mutable.Map("dchow" -> "mypassword")
  private val tasks = mutable.Map[String, List[String]]("dchow" -> List("Wake", "Be Awesome", "Sleep"))

  def validateUser(username: String, password: String): Boolean  = {
    //returns an option for a username, else false
    users.get(username).map(_ == password).getOrElse(false)
  }

  def createUser(username: String, password: String): Boolean = {
    if (users.contains(username)) false
    else {
      users(username) = password
      true
    }
  }

  def getTasks(username: String): Seq[String] = {
    tasks.get(username).getOrElse(Nil)
  }

  def addTask(username: String, task: String): Unit = {
    tasks(username) = task :: tasks.get(username).getOrElse(Nil)
  }

  def removeTask(username: String, index: Int): Boolean = {
    if (index < 0 || tasks.get(username).isEmpty || index >= tasks(username).length) false
    else{
      //patch allows insertion, deletion etc.
      tasks(username) = tasks(username).patch(index, Nil, 1)
      true
    }
  }

}
