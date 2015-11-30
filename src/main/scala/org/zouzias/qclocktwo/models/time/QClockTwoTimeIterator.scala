package org.zouzias.qclocktwo.models.time

import org.zouzias.qclocktwo.models.Time
import org.zouzias.qclocktwo.models.time.QclocktwoTime._

/**
 */
class QClockTwoTimeIterator extends Iterator[Time]{

  var time: Time = QclocktwoTime.initTime()
  val END_CONST: String = "__END__"

  override def hasNext: Boolean = {
    time._1.compareTo(END_CONST) != 0 && time._2.compareTo(END_CONST) != 0
  }

  def next(): Time = {
    val minsIndex = minutes.indexOf(time._2)
    val hoursIndex = hours.indexOf(time._1)

    // Increment minutes index
    if ( minsIndex < minsLength - 1)
      time = (time._1, minutes(minsIndex + 1))
    else if (hoursIndex < hoursLength - 1)
      time = (hours(hoursIndex + 1), minutes(0))
    else
      time =(END_CONST, END_CONST)

    time
  }
}
