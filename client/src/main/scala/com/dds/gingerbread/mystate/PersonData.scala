package com.dds.gingerbread.mystate
import com.dds.gingerbread.mycomponents.aPerson
import slinky.core.KeyAndRefAddingStage

class PersonData(val name: String, val age: Int) extends Data {
  def toComponent(): KeyAndRefAddingStage[aPerson] = aPerson(name, age)
}

object PersonData {
  def apply(name: String, age: Int) = new PersonData(name, age)
}
