package org.zouzias.qclocktwo.models


/**
 * QClockTwo letter grid
 *
 * Stores letters on numRows x numCols grid
 */
class LetterGrid(val numRows: Int, val numCols: Int) {

  var rows: Array[String] = _

  def this(grid: Array[String]){
    this(grid.length, grid(0).length)
    rows = grid
  }

  /**
   * Check if word exists in grid
   *
   * @param word
   * @param rowIndex
   * @return
   */
  def checkWord(word: String, rowIndex: Int) : Boolean = {
    assert(rowIndex < rows.length)

    return rows(rowIndex).contains(word)
  }

  /**
   * Returns an array of locations where the word appears horizontally.
   *
   *
   * @param word Word to search in grid
   * @return Array of (rowIndex, colIndex)
   */
  def findIndices(word: String): Array[(Int, Int)] = {

    // Compute rows to (rowIndex, columnIndex)
    val colIndices = rows.zipWithIndex.map{ row =>
      (row._2, row._1.indexOf(word))
    }

    // Keep only matches on each row
    colIndices.filter(p => p._2 != -1)
  }

  override def toString = s"LetterGrid($rows, $numRows, $numCols)"
}
