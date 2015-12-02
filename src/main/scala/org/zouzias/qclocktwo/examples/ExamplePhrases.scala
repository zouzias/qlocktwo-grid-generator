package org.zouzias.qclocktwo.examples

import org.zouzias.qclocktwo.examples.ExamplePhrasesIterator

/**
 * Examples time phrases
 */
object ExamplePhrases {

  val random = scala.util.Random

  val hours = Array("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")

  val minutes: Array[String] = Array(	"clock", "five", "ten", "fifteen", "twenty", "thirty", "forty", "fifty")

  val minsLength = minutes.length
  val hoursLength = hours.length

  def randomTime(): Array[String] = {
    Array(hours(random.nextInt(hoursLength)), minutes(random.nextInt(minsLength)))
  }

  def initTime(): Array[String] = {
    Array(hours(0), minutes(0))
  }

  def main(args: Array[String]) = {
    val iter = new ExamplePhrasesIterator()
    while(iter.hasNext) {
      println(iter.next())
    }
  }

}
