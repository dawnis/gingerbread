package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import mycomponents.{UserInput, UserOutput, aPerson}
import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.ReactDOM
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

object ScalaJSExample {

  @react class App extends Component {

    type Props = Unit
    case class State(username: String, showPersons: Boolean)

    override def initialState: State = State("myUsername", false)

    def changeUsername(newName: String) = {
      setState(state.copy(username = newName))
    }

    def togglePersonsHandler() = {
      setState(state.copy(showPersons = true))
    }

    def render(): ReactElement = {
      div(className := "App")(
        h1("My React App"),
        UserOutput(state.username),
        UserInput(state.username, changeUsername),
        h2("This is cool!"),
        button(onClick := (_ => {
          togglePersonsHandler()
        }),
          "Show Persons"),
        if (state.showPersons)
        div(className := "peopleList")(
        aPerson("Trista", 39),
        aPerson("Charlotte", 7),
        aPerson("Roland", 4)
        ) else div()
      )
    }

  }

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    ReactDOM.render(App(),  rootNode
    )
  }
}
