package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._


object ScalaJSExample {

  case class person(name: String)
  val Trista = person("Trista")
  val Charlotte = person("Charlotte")
  val aPerson =  ScalaComponent.builder[person].render_P(person => <.div(f"My name is $person")).build

  def main(args: Array[String]): Unit = {
    //dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    createHeader(document.body, "My React Learning App")
    appendPar(document.body, "This is cool!")

    <.div(
      aPerson(Trista),
      aPerson(Charlotte)
    )

  }

  def createHeader(targetNode: dom.Node, text: String): Unit = {
    val h1Node = document.createElement("h1")
    targetNode.appendChild(h1Node)
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }
}
