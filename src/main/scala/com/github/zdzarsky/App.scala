package com.github.zdzarsky

import java.io.File

import com.github.zdzarsky.converter.XlsxToNodesListConverter
import com.github.zdzarsky.model.Node._
import play.api.libs.json.Json

import scala.util.{Failure, Success}

object App {

  def main(args: Array[String]): Unit = {
    XlsxToNodesListConverter.read(new File(getClass.getResource("test1.xlsx").toURI)) match {
      case Success(nodesList) =>
        println(Json.prettyPrint(Json.toJson(nodesList)))
      case Failure(error) =>
        println(s"An error occured: $error")
    }
  }
}
