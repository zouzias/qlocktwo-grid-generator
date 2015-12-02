package org.zouzias.qclocktwo.examples

import org.zouzias.qclocktwo.algo.GridPhrasesMatcher
import org.zouzias.qclocktwo.grid.LetterGrid
import org.zouzias.qclocktwo.phrases.TimePhrases

/**
 * An example grid that time phrases are realizable
 */
object GridExample1 {

  val grid = Array[String](
    "NSEVENFOURC",
    "FELEVENOTWO",
    "TWELVEFIVEV",
    "TEIGHTENONE",
    "TNINETHREEL",
    "SIXHALFIFTY",
    "EFORTYYPAST",
    "OFTHIRTYTEN",
    "TOTWENTYSIX",
    "TWCLOCKFIVE",
    "FIFTEENTONE"
    ).map(_.toLowerCase())

  // Letter grid
  val letterGrid = new LetterGrid(grid)

  // Set of phrases
  val phrases = new TimePhrases()

  def main(args: Array[String]): Unit = {
    println(s"Executing ${getClass.getName}")

    val iter = new ExamplePhrasesIterator()
    while(iter.hasNext) {
      val phrase = iter.next()
      println(s"Added phrase ${phrase.mkString}")
      phrases.addPhrase(phrase)
    }

    val gridPhraseMatcher = new GridPhrasesMatcher(letterGrid, phrases)

    println("Phrases are valid? : " + gridPhraseMatcher.validPhrases())
    print(letterGrid.toString)
  }
}
