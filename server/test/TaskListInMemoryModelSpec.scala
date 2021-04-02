import play.api.test._
import models._

class TaskListInMemoryModelSpec extends PlaySpecification {

  "TaskListInMemoryModel" should {

    "do valid login for default user" in {
      TaskListInMemoryModel.validateUser("dchow", "mypassword")  should === (true)
    }

    "reject login with wrong password" in {
      TaskListInMemoryModel.validateUser("Mark", "wrongpass") should === (false)
    }

    "reject login with wrong password" in {
      TaskListInMemoryModel.validateUser("wrongname", "pass")  must === (false)
    }

    "get correct default tasks" in {
      TaskListInMemoryModel.getTasks("dchow")  should === (List("Wake", "Be Awesome", "Sleep"))
    }

    "create new user with no tasks" in {
      TaskListInMemoryModel.createUser("Mike", "Mike_Password") must === (true)
      TaskListInMemoryModel.getTasks("Mike") should === (Nil)
    }


    "create new user with existing name" in {
      TaskListInMemoryModel.createUser("dchow", "different_password") should === (false)
    }


    "add new task for default user" in {
      TaskListInMemoryModel.addTask("dchow", "testinput")
      TaskListInMemoryModel.getTasks("dchow") must contain  ("testinput")
    }

    "add new task for another user" in {
      TaskListInMemoryModel.addTask("anotheruser", "testinput")
      TaskListInMemoryModel.getTasks("anotheruser") must contain  ("testinput")
    }

    "remove task from default user" in {
      TaskListInMemoryModel.removeTask("dchow", TaskListInMemoryModel.getTasks("dchow").indexOf("Wake"))
      TaskListInMemoryModel.getTasks("dchow") must not contain ("Wake")
    }
  }
}
