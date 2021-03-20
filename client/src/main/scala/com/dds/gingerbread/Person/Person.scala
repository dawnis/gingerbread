package com.dds.gingerbread.Person

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object person {
  case class Props(name: String, age: String)
  val aPerson = ScalaComponent.builder[Props]("person")
    .render($ => <.div("Hello, my name is ", $.props.name, " and I am ", $.props.age, " years old.")).build

  def apply(name: String, age: Integer, children: VdomNode*) = {
    val person_properties = Props(name, age.toString)
    aPerson(person_properties)
  }
}
