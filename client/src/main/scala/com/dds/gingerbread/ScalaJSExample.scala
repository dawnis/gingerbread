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

import scala.collection.mutable
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}

object ScalaJSExample {

  @react class App extends Component {

    type Props = Unit

    sealed trait Data

    case class myperson(name: String, age: Int) extends Data

    case class State(username: String,
                     showPersons: Boolean)

    override def initialState: State = State("myUsername", false)

    def changeUsername(newName: String) = {
      setState(state.copy(username = newName))
    }

    def togglePersonsHandler() = {
      setState(state.copy(showPersons = !state.showPersons))
    }

    def render(): ReactElement = {

      val persons = if (state.showPersons) {
        div(className := "homies")(
          aPerson("Trista", 39),
          aPerson("Charlotte", 7),
          aPerson("Roland", 5))
      } else null

      div(className := "App")(
        h1("My React App"),
        UserOutput(state.username),
        UserInput(state.username, changeUsername),
        h2("This is cool!"),
        button(onClick := (_ => {
          togglePersonsHandler()
        }),
          "Show Persons"),
        persons
      )
    }

  }

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    val rootNode = dom.document.getElementById("root")

    ReactDOM.render(App(), rootNode
    )
  }
}
