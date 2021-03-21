package com.dds.gingerbread.mycomponents
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.web.html._

//notice the backticks required for inut since type is a scaa
@react class aPerson extends StatelessComponent {
  case class Props(name: String, age: Integer)

  def render() = {
    div(className := "Person")(
    p(s"Hello, my name is ${props.name} and I am ${props.age} years old"),
      input(`type` := "text", onChange := (event => {println("a change")}), value := props.name)
    )
  }
}

