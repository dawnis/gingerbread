package com.dds.gingerbread.controllers

import models.TaskListInMemoryModel

import javax.inject._
import play.api.mvc._

@Singleton
class TaskList1 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def login = Action {
    Ok(views.html.login1())
  }

  def validateLoginGet(username: String, password: String) = Action {
    Ok(s"$username logged in with $password.")
  }

  //Action is actually a pass by name argument
  def validateLoginPost = Action { request =>
    //arguments are not encoded in the url in POST. They are encoded in the body.
    val postVals: Option[Map[String, Seq[String]]] = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      //reverse routing
      if (TaskListInMemoryModel.validateUser(username, password)) {
        //Ok(s"$username logged in with password $password")
        Redirect(routes.TaskList1.taskList())
      }
      else Redirect(routes.TaskList1.login())
    }.getOrElse(Redirect(routes.TaskList1.login()))
    //if the map ends up being none, then OrElse ges called
  }

  def taskList = Action {
    val username = "dchow"
    val tasks = TaskListInMemoryModel.getTasks(username)
    Ok(views.html.taskList1(tasks))
  }

  def createuser() = ???

}
