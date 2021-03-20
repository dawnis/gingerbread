package com.dds.gingerbread.Person

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object person {
  case class props(name: String, age: String)
  val aPerson = ScalaComponent.builder[props].render($ => <.div("Hello, my name is ", $.props.name, " and I am ", $.props.age, " years old.")).build
}
