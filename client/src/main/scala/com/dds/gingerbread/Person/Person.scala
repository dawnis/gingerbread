package com.dds.gingerbread.Person

import japgolly.scalajs.react.{CtorType, _}
import japgolly.scalajs.react.component.Scala.{Component, Unmounted}
import japgolly.scalajs.react.vdom.html_<^._
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.scalajsreact.Converters._

@react class person extends StatelessComponent {
  case class Props(name: String, age: String)
  val aPerson: Component[Props, Unit, Unit, CtorType.Props] = ScalaComponent.builder[Props]("person")
    .render($ => <.div("Hello, my name is ", $.props.name, " and I am ", $.props.age, " years old.")).build

  def apply(name: String, age: Integer, children: VdomNode*): Unmounted[Props, Unit, Unit] = {
    val person_properties = Props(name, age.toString)
    aPerson(person_properties).toSlinky
  }

  def render(): ReactElement = {
    ???
  }
}
