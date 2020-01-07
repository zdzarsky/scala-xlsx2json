package com.github.zdzarsky.utils

import org.apache.poi.ss.usermodel.Cell

import scala.annotation.tailrec

object GroupingUtils {
  type Row = List[Cell]
  type IndexedRow = (Row, Int)
  type RangedRow = (Row, (Int, Int))

  def countRanges(xs: List[IndexedRow], previousMax: Int): List[RangedRow] = {
    countRanges(List.empty, xs, previousMax)
  }

  @tailrec
  private def countRanges(res: List[RangedRow], xs: List[IndexedRow], previousMax: Int): List[RangedRow] = xs match {
    case Nil => List.empty
    case head :: Nil => res :+ (head._1, (head._2, previousMax))
    case head :: tail => countRanges(res :+ (head._1, (head._2, tail.head._2 - 1)), tail, previousMax)
  }
}
