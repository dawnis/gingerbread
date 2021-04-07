import org.scalatestplus.play.{HtmlUnitFactory, OneBrowserPerSuite, PlaySpec}
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

//port is provided on import
//this does not play nice with JavaScript
class TaskList1Spec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
  "Task list 1" must {
    "login and access functions" in {
      go to s"http://localhost:$port/login1"

      pageTitle mustBe "Login"

      find(cssSelector("h2")).foreach(e => e.text mustBe "Login")
      find(cssSelector("h2")).isEmpty mustBe false
      click on "username-login"
      textField(id("username-login")).value = "dchow"
      click on "password-login"
      pwdField(id("password-login")).value = "mypassword"
      submit()
      eventually {
        println("In Eventually")
        pageTitle mustBe "Task List"
        println("Title Passded")
        find(cssSelector("h2")).isEmpty mustBe false
        find(cssSelector("h2")).foreach( e => e.text mustBe "Task list")
        println("h2 found")
        findAll(cssSelector("li")).toList.map(_.text) mustBe List("Wake", "Sleep", "Be Awesome")
      }
    }
  }

}