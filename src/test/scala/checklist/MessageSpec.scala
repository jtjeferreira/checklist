package checklist

import org.scalatest._

import scalaz.NonEmptyList

class MessageSpec extends WordSpec with Matchers {
  "errors helper" should {
    "create a single error" in {
      val actual   = Message.errors("message")
      val expected = NonEmptyList.nels(ErrorMessage("message"))
      actual should be(expected)
    }

    "create multiple errors" in {
      val actual   = Message.errors("message1", "message2")
      val expected = NonEmptyList.nels(ErrorMessage("message1"), ErrorMessage("message2"))
      actual should be(expected)
    }
  }

  "warnings helper" should {
    "create a single warning" in {
      val actual   = Message.warnings("message")
      val expected = NonEmptyList.nels(WarningMessage("message"))
      actual should be(expected)
    }

    "create multiple warnings" in {
      val actual   = Message.warnings("message1", "message2")
      val expected = NonEmptyList.nels(WarningMessage("message1"), WarningMessage("message2"))
      actual should be(expected)
    }
  }
}
