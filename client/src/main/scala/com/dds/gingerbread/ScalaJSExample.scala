package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import Person.aPerson
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.ReactDOM
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

object ScalaJSExample {

  @react class App extends StatelessComponent {

    type Props = Unit

    def render(): ReactElement = {
      div(className := "App")(
        h1("My React App"),
        h2("This is cool!"),
        button(onClick := (_ => {
          println("hello")
        }),
          style := js.Dynamic.literal(
            backgroundColor = "white",
            font = "inherit",
            border = "1px solid blue",
            cursor = "pointer"
          ),
          "Switch Name"),
        aPerson("Trista", 39),
        aPerson("Charlotte", 7),
        aPerson("Roland", 4))
    }

  }

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    def switchNameHandler: Unit = {
      ???
    }

    ReactDOM.render(App(),  rootNode
    )
  }
}
