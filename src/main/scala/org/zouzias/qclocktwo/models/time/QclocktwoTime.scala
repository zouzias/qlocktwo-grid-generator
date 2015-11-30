package org.zouzias.qclocktwo.models.time

import org.zouzias.qclocktwo.models.Time

object QclocktwoTime {

  val random = scala.util.Random

  val hours = Array("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve")

  val minutes: Array[String] = Array(	"clock", "five", "ten", "fifteen", "twenty", "thirty", "forty", "fifty")

  val minsLength = minutes.length
  val hoursLength = hours.length


  def randomTime(): Time = {
    (hours(random.nextInt(hoursLength)), minutes(random.nextInt(minsLength)))
  }

  def initTime(): Time = {
    (hours(0), minutes(0))
  }


  def main(args: Array[String]) = {
    val iter = new QClockTwoTimeIterator()
    while(iter.hasNext) {
      println(iter.next())
    }
  }

}
