package com.github.zdzarsky.utils

import org.apache.poi.ss.usermodel.Cell

import scala.annotation.tailrec

object GroupingUtils {
  def countRanges(xs: List[(List[Cell], Int)], previousMax: Int): List[(List[Cell], (Int, Int))] = {
    countRanges(List.empty, xs, previousMax)
  }

  @tailrec
  private def countRanges(res: List[(List[Cell], (Int, Int))],
                          xs: List[(List[Cell], Int)], previousMax: Int
                         ): List[(List[Cell], (Int, Int))] = {
    xs match {
      case Nil => List.empty
      case head :: Nil => res :+ (head._1, (head._2, previousMax))
      case head :: tail => countRanges(res :+ (head._1, (head._2, tail.head._2 - 1)), tail, previousMax)
    }
  }
}
