package com.github.zdzarsky.converter

import java.io.File
import java.net.URI

import org.scalatest.GivenWhenThen
import org.scalatest.wordspec.AnyWordSpec

import scala.util.{Failure, Success, Try}
import XlsxToNodesListConverterTest._
import com.github.zdzarsky.TestUtils._

class XlsxToNodesListConverterTest extends AnyWordSpec with GivenWhenThen {
  "XlsxDataReader" should {
    "Find file in resources" in {
      Given("File from resources")
      When("Reading file from resources")
      val file = getFileFromResources
      Then("Should not obtain exception")
      assert(file.isDefined)
    }
  }

  "XlsxDataReader" should {
    "Read proper data" in {
      Given("File from resources")
      val file = new File(getFileFromResources.getOrElse(fail()))
      val converter = new XlsxToNodesListConverter()
      When("Reading")
      val maybeData = converter.convert(file)
      Then("Should have 4 elements")
      maybeData match {
        case Failure(_) => fail()
        case Success(nodes) =>
          assert(nodes == structure)
      }
    }
  }
}

private object XlsxToNodesListConverterTest {
  val fileName = "test1.xlsx"

  def getFileFromResources: Option[URI] = Try(getClass.getResource(fileName).toURI).toOption

}
