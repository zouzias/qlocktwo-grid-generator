package org.zouzias.qclocktwo.models.phrases

import scala.collection.mutable.ArrayBuffer

/**
 * Word phrases as an array of words
 */
class TimePhrases {

  type WordPhrase = Array[String]

  private val phrases_ : ArrayBuffer[WordPhrase] = new ArrayBuffer()

  /**
   * Add a new phrase
   *
   * @param phrase Phrase as an array of words
   */
  def addPhrase(phrase: WordPhrase): Unit = {
    phrases_.append(phrase)
  }


  /**
   * Return all phrases
   *
   * @return Array of phrases
   */
  def phrases(): Array[WordPhrase] = {
    phrases_.toArray
  }
}


