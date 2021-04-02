import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc._
import play.api.test.{PlaySpecification, WebDriverFactory, WithBrowser}
import com.dds.gingerbread.controllers.{Application, TaskList1, routes}
import com.dds.gingerbread.shared.SharedMessages
import play.api.mvc.Results.Ok


class TaskList1Spec() extends PlaySpecification {

  def applicationWithBrowser = {
    new GuiceApplicationBuilder()
      .appRoutes { app =>
        val Action = app.injector.instanceOf[DefaultActionBuilder]
        ({
          case ("GET", "/") => routes.Application.index()
          case ("GET", "/login1") =>  Ok(views.html.login1())
        })
      }
      .build()
  }

  //Create a Selenium Web Browser instance for testing
  "run in a browser" in new WithBrowser(webDriver = WebDriverFactory(HTMLUNIT), applicationWithBrowser) {
    browser.goTo("/")
  }

}
