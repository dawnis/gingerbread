import org.scalatestplus.play.{HtmlUnitFactory, OneBrowserPerSuite, PlaySpec}
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

//port is provided on import
class TaskList1Spec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
  "Task list 1" must {
    "login and access functions" in {
      go to s"http://localhost:$port/login1"

      pageTitle mustBe "Login"

      find(cssSelector("h2")).foreach(e => e.text mustBe "Login")
      find(cssSelector("h2")).isEmpty mustBe false
      click on "username-login"
      textField("username").value = "dchow"
      click on "password-login"
      pwdField("password").value = "mypassword"

      eventually {
      submit()
      }
    }
  }

}