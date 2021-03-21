package com.dds.gingerbread.mycomponents

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.web.html._

import scala.scalajs.js

//:= produces an attribute pair in the Slinky library
@react class UserInput extends StatelessComponent {

  case class Props(username: String, changeUsername: String => Unit)


  val inputStyling = js.Dynamic.literal(
    backgroundColor = "green",
    font = "inherit",
    border = "2px solid blue",
    cursor = "pointer"
  )

  def render() = {
    input(`type` := "text",
      style := inputStyling,
      onChange := (event => props.changeUsername(event.target.value)),
      value := props.username
    )
  }

}

@react class UserOutput extends StatelessComponent {

  case class Props(username: String)

  def render() = {
    div(className := "userName")(
      p(s"The current username is ${props.username}"),
    )
  }
}
