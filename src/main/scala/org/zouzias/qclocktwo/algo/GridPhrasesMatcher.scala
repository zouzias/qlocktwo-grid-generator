package org.zouzias.qclocktwo.algo

import org.zouzias.qclocktwo.grid.LetterGrid
import org.zouzias.qclocktwo.phrases.TimePhrases

import scala.collection.mutable.ArrayBuffer

/**
 * Given a letter grid and a list of word phrases, checks if the grid can display all word phrases
 *
 * In initialization, it computes a Map from words to its corresponding (x,y) location on the grid
 */
class GridPhrasesMatcher(val grid: LetterGrid, val wordPhrases: TimePhrases) {

  /** Pre-computes words to locations (x,y) map*/
  val wordToGrid: Map[String, Array[(Int, Int)]] = wordPhrases.phrases().flatMap{ phrase =>
      phrase.map{ word =>
        word -> grid.findIndices(word)
      }
    }.toMap

  /**
   * Return the first location of a word starting from a position (x, y)
   * @param word Search word
   * @param from Location to initiate the search
   * @return A location (x, y) where the word appears
   */
  def wordToLocation(word: String, from: (Int, Int)): Option[(Int, Int)] = {
    val pos = wordToGrid.getOrElse(word, Array((Int.MaxValue, Int.MaxValue)))
    pos.dropWhile{ case (x, y) => x <= from._1 && y + word.length < from._2}.headOption
  }

  /**
   * Return a list of (x, y) location for displaying the phrase on a grid letter
   *
   * If a word cannot be displayed, it is skipped. The next word is consider
   *
   * @param phrase A word phrase to display on letter grid
   * @return Location of each word on the grid (words must be consequtive)
   */
  def phraseToLocations(phrase: Array[String]): Array[(Int, Int)] = {
    var loc = (0, 0)
    val arrayBuffer = new ArrayBuffer[(Int, Int)]()

    // For each word, search it and update location "loc"
    phrase.foreach{ word =>
      val nextWordLocation = wordToLocation(word, loc)

      // If word found, then
      nextWordLocation.foreach{ wordLoc =>
        // Store word's location
        arrayBuffer.append(wordLoc)
        // Update current location
        loc = (wordLoc._1, wordLoc._2 + word.length)
      }
    }

    arrayBuffer.toArray
  }

  /**
   * Check if all phrases are valid on the letter grid
   *
   * @return <code>true</code> iff all phrases can be displayed on grid
   */
  def validPhrases(): Boolean = {
    val phraseLengthToLocations = wordPhrases.phrases().map{ phrase =>
      (phrase.mkString("-"), phrase.length,  phraseToLocations(phrase))
    }

    phraseLengthToLocations.forall{ case (phrase, length, locations) =>
      val locString = locations.mkString(",")
      println(s"Phrase is ${phrase} with length ${length} and locations are ${locString}")
      length == locations.length}
  }
}
