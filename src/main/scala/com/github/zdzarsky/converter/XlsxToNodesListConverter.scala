package com.github.zdzarsky.converter

import java.io.File

import com.github.zdzarsky._
import com.github.zdzarsky.model.Node
import com.github.zdzarsky.utils.GridUtils._
import org.apache.poi.ss.usermodel.{Workbook, WorkbookFactory}

import scala.jdk.CollectionConverters._
import scala.util.{Try, Using}

class XlsxToNodesListConverter {

  def convert(file: File, sheetNo: Int = 0, levels: Int = 3): Try[List[Node]] =
    readGridFromFile(file, sheetNo).map(_.toNodesList(levels))


  private def readGridFromFile(file: File, sheetNo: Int): Try[ExcelGrid] = {
    Using(WorkbookFactory.create(file))(
      _.getSheetAt(sheetNo).rowIterator().asScala.drop(1).toList
        .pipeForward(rows => for {row <- rows} yield row.cellIterator().asScala.toList))
  }
}
