package com.dds.gingerbread.Person
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.web.html._

@react class aPerson extends StatelessComponent {
  case class Props(name: String, age: Integer)

  def render() = {
    p(s"Hello, my name is ${props.name} and I am ${props.age} years old")
  }
}

