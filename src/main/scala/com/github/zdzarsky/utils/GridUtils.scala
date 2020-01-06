package com.github.zdzarsky.utils

import com.github.zdzarsky.model.Node
import com.github.zdzarsky.utils.GroupingUtils.countRanges
import org.apache.poi.ss.usermodel.{Cell, CellType}
import com.github.zdzarsky._

object GridUtils {

  implicit class GridToNodesConverter(extended: List[List[Cell]]) {
    def toNodesList(maxLevel: Int): List[Node] = {
      makeNodes(extended, 0, maxLevel, (0, extended.length - 1))
    }
  }

  private def makeNodes(rows: List[List[Cell]], currentLevel: Int, maxLevel: Int, rowRange: (Int, Int)): List[Node] = {
    if (currentLevel == maxLevel) {
      List.empty
    } else {
      rows.zipWithIndex
        .filter(indexedRow => (rowRange._1 to rowRange._2).contains(indexedRow._2))
        .filter(_._1(currentLevel).getCellType != CellType.BLANK)
        .pipeForward(p => countRanges(p, rowRange._2))
        .map(rangedRow => new Node(rangedRow._1(maxLevel).getNumericCellValue.toInt,
          rangedRow._1(currentLevel).getStringCellValue,
          makeNodes(rows, currentLevel + 1, maxLevel, rangedRow._2))
        )
    }
  }
}
