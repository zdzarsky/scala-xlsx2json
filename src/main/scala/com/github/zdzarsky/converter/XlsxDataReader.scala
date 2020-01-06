package com.github.zdzarsky.converter

import java.io.File

import com.github.zdzarsky._
import com.github.zdzarsky.model.Node
import com.github.zdzarsky.utils.GridUtils._
import org.apache.poi.ss.usermodel.WorkbookFactory

import scala.jdk.CollectionConverters._
import scala.util.{Try, Using}


object XlsxDataReader {
  def read(file: File, sheetNo: Int = 0, levels: Int = 3): Try[List[Node]] = {
    Using(WorkbookFactory.create(file))(
      _.getSheetAt(sheetNo).rowIterator().asScala.drop(1).toList
        .pipeForward(rows => for {
          row <- rows
        } yield row.cellIterator().asScala.toList))
      .map(_.toNodesList(levels))
  }
}
