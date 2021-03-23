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

  def addTask(username: String, tasks: String): Unit = ???

  def removeTask(username: String, index: Int): Boolean = ???

}
