package org.zouzias.qclocktwo.algo

import org.zouzias.qclocktwo.models._
import org.zouzias.qclocktwo.models.phrases.TimePhrases

/**
 * Given a letter grid and a list of word phrases, checks if the grid can display all word phrases
 */
class GridPhrasesMatcher(val grid: LetterGrid, val wordPhrases: TimePhrases) {

  implicit val ord = Ordering.by[(Int, Int)]()


  def orderLocations(a: (Int, Int), b: (Int, Int)): Int = {
    val rowOrdered = a._1 < b._1

    if (rowOrdered) -1 else b._2 - a._2
  }

  def orderPhrases(a: Array[(Int, Int)], b: Array[(Int, Int)]): Int = {
    val aMinX = a.map()

  }

  // Computes word -> set of occurences on the grid
  val wordToGrid: Map[String, Array[(Int, Int)]] = wordPhrases.phrases().flatMap{ phrase =>
      phrase.map{ word =>
        word -> grid.findIndices(word)
      }
    }.toMap


    def validTimePhrases(): Boolean = {
      wordPhrases.phrases().foreach{ phrase =>

      }
    }

  def isValidTime(word: String): Boolean = {
    val hourMinuteIndices = grid.findIndices(time)
    val hourIndex = hourMinuteIndices._1._1
    val minuteIndex = hourMinuteIndices._2._1

    // Valid iff not on the same row OR same row and at least one space
    hourIndex < minuteIndex || hourMinuteIndices._1._2 < hourMinuteIndices._2._2 - 1
  }


}
