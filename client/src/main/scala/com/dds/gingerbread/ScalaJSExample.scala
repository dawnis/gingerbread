package com.dds.gingerbread

import com.dds.gingerbread.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks

    appendPar(document.body, "Not Hello!")
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }
}
