package com.dds.gingerbread.controllers

import javax.inject._
import play.api.mvc._

import com.dds.gingerbread.shared.SharedMessages

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

}
