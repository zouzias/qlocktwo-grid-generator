package org.zouzias.qclocktwo.examples

import org.zouzias.qclocktwo.examples.ExamplePhrases._

/**
 * Phrases iterator
 */
class ExamplePhrasesIterator extends Iterator[Array[String]]{

  var currentTime = ExamplePhrases.initTime()
  val END_CONST: String = "__END__"

  override def hasNext: Boolean = {
    currentTime.head.compareTo(END_CONST) != 0 && currentTime.last.compareTo(END_CONST) != 0
  }

  def next(): Array[String] = {

    // TODO: check if head / last exist
    val minsIndex = minutes.indexOf(currentTime.last)
    val hoursIndex = hours.indexOf(currentTime.head)

    // Increment minutes index
    if (minsIndex < minsLength - 1)
      currentTime = Array(currentTime.head, minutes(minsIndex + 1))
    else if (hoursIndex < hoursLength - 1)
      currentTime = Array(hours(hoursIndex + 1), minutes(0))
    else currentTime = Array(END_CONST, END_CONST)


    println(s"Current time is : ${currentTime}")
    currentTime
  }
}
