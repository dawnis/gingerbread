package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import Person.aPerson
import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    ReactDOM.render(
      div(className := "App")(
        h1("My React App"),
        h2("This is cool!"),
        aPerson("Trista", 39),
        aPerson("Charlotte", 7),
        aPerson("Roland", 4)
      ), rootNode
    )
  }
}
