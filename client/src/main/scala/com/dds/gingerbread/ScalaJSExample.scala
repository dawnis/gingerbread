package com.dds.gingerbread

import org.scalajs.dom
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

    case class State(username: String,
                     showPersons: Boolean)

    val myhomies = Seq(("Trista", 39), ("Roland", 5), ("Charlotte", 7) )

    override def initialState: State = State("myUsername", false)

    def changeUsername(newName: String) = {
      setState(state.copy(username = newName))
    }

    def togglePersonsHandler() = {
      setState(state.copy(showPersons = !state.showPersons))
    }

    def deletePersonsHandler(): Unit = {
      println("let's delete")
    }

    def render(): ReactElement = {

      val persons = if (state.showPersons) {
        div(className := "peopleList")(
          myhomies.map(peep => aPerson(peep._1, peep._2, deletePersonsHandler)): _*
        )
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
