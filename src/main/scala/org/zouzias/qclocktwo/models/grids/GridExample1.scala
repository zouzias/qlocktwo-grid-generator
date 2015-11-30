package org.zouzias.qclocktwo.models.grids

import org.zouzias.qclocktwo.models.LetterGrid
import org.zouzias.qclocktwo.models.time.QClockTwoTimeIterator

/**
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

  val letterGrid = new LetterGrid(grid)

  def main(args: Array[String]): Unit = {
    val iter = new QClockTwoTimeIterator()
    while(iter.hasNext) {
      val time = iter.next()
      if ( !letterGrid.isValidTime(time))
        println(time + " is invalid!!!")
      else
        println(time + " is valid: Plotted on " + letterGrid.findIndices(time))
    }
  }

}
