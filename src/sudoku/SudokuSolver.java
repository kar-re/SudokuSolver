package sudoku;

public interface SudokuSolver {
	/**
	 * Sets the digit number in the box row, col.
	 *
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert in row, col
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	void setNumber(int row, int col, int number);

	/**
	 * Checks so that the move about to be made is legal returns false if not.
	 *
	 * 	@param row    		The row
	 * 	@param col    		The column
	 * 	@param number 	The digit to insert in row, col
	 *	@return returns true if the move is legal, false if not
	 * 	@throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	boolean trySetNumber(int row, int col, int number);

	/**
	 *Gets number at position row, col
	 *
	 * @param row	The row
	 * @param col		The column
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	int getNumber(int row, int col);

	/**
	 *Removes number at position row, col
	 *
	 * @param row	The row
	 * @param col		The column
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	void removeNumber(int row, int col);

	/**
	 * Clears the entire sudoku grid
	 *
	 */
	void clear();

	/**
	 * Solves the sudoku
	 * @return returns true if sudoku is solvable false if not
	 *
	 */
	boolean solve();

	/**
	 *	@return returns the current sudoku grid
	 */
	int[][] getNumbers();

	/**
	 *	Sets the sudoku grid to the input
	 *	@param numbers	the int matrix to change to
	 */
	void setNumbers(int[][] numbers);
}

