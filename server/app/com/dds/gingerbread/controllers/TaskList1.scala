package com.dds.gingerbread.controllers

import models.TaskListInMemoryModel

import javax.inject._
import play.api.mvc._

@Singleton
class TaskList1 @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //using implicit requests here allows info to be passed into Twirl templates
  def login = Action { implicit request =>
    Ok(views.html.login1())
  }

  def validateLoginGet(username: String, password: String) = Action {
    Ok(s"$username logged in with $password.")
  }

  //Action is actually a pass by name argument
  def validateLoginPost = Action { implicit request =>
    //arguments are not encoded in the url in POST. They are encoded in the body.
    val postVals: Option[Map[String, Seq[String]]] = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      //reverse routing
      if (TaskListInMemoryModel.validateUser(username, password)) {
        //Ok(s"$username logged in with password $password")
        //session is a map
        Redirect(routes.TaskList1.taskList()).withSession("username" -> username)
      }
      else Redirect(routes.TaskList1.login()).flashing("error" -> "Invalid username/pass combination")
    }.getOrElse(Redirect(routes.TaskList1.login()))
    //if the map ends up being none, then OrElse ges called
  }

  def taskList = Action { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val tasks = TaskListInMemoryModel.getTasks(username)
      Ok(views.html.taskList1(tasks))
    }.getOrElse(Redirect((routes.TaskList1.login())))
  }

  def createUser() = Action { implicit request =>
    //very similar to validateUser
    val postVals: Option[Map[String, Seq[String]]] = request.body.asFormUrlEncoded
    postVals.map { args =>
      val username = args("username").head
      val password = args("password").head
      if (TaskListInMemoryModel.createUser(username, password)) {
        Redirect(routes.TaskList1.taskList()).withSession("username" -> username)
      }
      else Redirect(routes.TaskList1.login()).flashing("error" -> "User creation failed.")
    }.getOrElse(Redirect(routes.TaskList1.login()))
  }

  def logout = Action {
    Redirect(routes.TaskList1.login()).withNewSession
  }
}
