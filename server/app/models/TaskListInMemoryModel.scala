package models

import scala.collection.mutable

object TaskListInMemoryModel {

  private val users: mutable.Map[String, String] =  mutable.Map("dchow" -> "mypassword")

  def validateUser(username: String, password: String): Boolean  = {
    //returns an option for a username, else false
    users.get(username).map(_ == password).getOrElse(false)
  }

  def createUser(username: String, password: String): Boolean = ???

  def getTasks(username: String): Seq[String] = ???

  def addTask(username: String, tasks: String): Unit = ???

  def removeTask(username: String, index: Int): Boolean = ???

}
