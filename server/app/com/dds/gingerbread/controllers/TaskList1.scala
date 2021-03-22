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

  def taskList = Action {
    val tasks = List("wake", "breakfast", "plan", "work", "play", "repeat")
    Ok(views.html.taskList1(tasks))
  }

}
