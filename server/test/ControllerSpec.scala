import play.api.test.{FakeRequest, Helpers, PlaySpecification, WithApplication}
import com.dds.gingerbread.controllers.Application

class ControllerSpec extends PlaySpecification {

  "Application#index" should {
    "give back expected page" in new WithApplication{
      val index = route(app, FakeRequest(GET, "/")).get

      val bodyText = contentAsString(index)

      bodyText must contain ("root")
    }
  }

}
