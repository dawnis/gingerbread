package com.dds.gingerbread.controllers

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
      Ok(s"$username logged in with password $password")
    }.getOrElse(Ok("oops"))
  }

  def taskList = Action {
    val tasks = List("wake", "breakfast", "plan", "work", "play", "repeat")
    Ok(views.html.taskList1(tasks))
  }

}
