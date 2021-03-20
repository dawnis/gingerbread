package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import Person.person
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._


object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    val buttonName = "Old Button name"
    val switchNameHandler: Callback = ???

    <.div(
      <.h1("My React Learning App"),
        <.p("So Cool!"),
      <.button(buttonName, ^.onClick.-->(switchNameHandler)),
      person("Trista", 39),
      person("Charlotte", 7)
    ).renderIntoDOM(rootNode)
  }
}
