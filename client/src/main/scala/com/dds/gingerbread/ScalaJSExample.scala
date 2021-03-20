package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import Person.person
import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    val rootDiv = div(Seq(h1("My react app!"), p("So Cool!"), person(name="Trista", age=39).toSlinky))
    ReactDOM.render(
      h1("My React app"), rootNode
    )
  }
}
