
package sudoku_jf;

public class Sudoku implements SudokuSolver {
	private int[][] sudoku = new int[9][9];
	private final static int zero = 0;
	private int size = 9;

	/**
	 * Creates a sudoku containing an empty 9 x 9 matrix
	 */
	public Sudoku() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				sudoku[row][col] = zero; // brädet fylls med tomma rutor
			}
		}
	}

	/**
	 * Solves the sudoku starting at row, col.
	 * 
	 * @param row The row
	 * @param col The column
	 * @return true if the sudoku can be solved.
	 */
	private boolean solve(int row, int col) {

		long startTime = System.currentTimeMillis(); // för att undvika utdragen backtracking
		long elapsedTime = startTime;
		long elapsedSeconds = startTime;

		if (row == size) { // vi har tagit oss till slutet av matrisen är och därmed klara
			return true;
		}
		if (sudoku[row][col] == 0) {
			for (int i = 1; i < size + 1; i++) {
				sudoku[row][col] = i;
				if (verifyRules(row, col)) { // om checkRules = false - testar i+1
					if (col != 8) {
						elapsedTime = System.currentTimeMillis() - startTime;
						elapsedSeconds = elapsedTime / 1000;
						if (elapsedSeconds > 0.1) {
							return false;
						}
						if (solve(row, col + 1)) {
							return true;
						}
					} else {
						if (solve(row + 1, 0)) {
							return true;
						}
					}
				}
			}
			sudoku[row][col] = 0; // testat siffror 1 till 9 checkRules= false för alla, olösligt
			return false;
		} else {
			if (verifyRules(row, col)) { // vid backtracking, rutan ej tom
				if (col == 8) {
					if (solve(row + 1, 0)) {
						return true;
					}
				} else {
					elapsedTime = System.currentTimeMillis() - startTime;
					elapsedSeconds = elapsedTime / 1000;
					if (elapsedSeconds > 0.1) {
						return false;
					}
					if (solve(row, col + 1)) {
						return true;
					}
				}
			}
		}
		return false;

	}

	/**
	 * Checks if the rules for the sudoku is ok for the square at row, col
	 * 
	 * @param row The row
	 * @param col The column
	 * @return true if the number at row, col is ok
	 */
	private boolean verifyRules(int row, int col) {

		int currentNbr = sudoku[row][col];
		sudoku[row][col] = 0; // för att inte krocka under kontroll

		if (!existsInRow(row, currentNbr) && !existsInCol(col, currentNbr) && !existsInBox(row, col, currentNbr)) {
			sudoku[row][col] = currentNbr;
			return true;
		} else {
			sudoku[row][col] = currentNbr;
			return false;
		}

	}

	/**
	 * Checks if the number nbr already exists in the row
	 * 
	 * @param row The row
	 * @param nbr The number tested
	 * @return true if the number already exists in row
	 */
	private boolean existsInRow(int row, int nbr) {
		for (int i = 0; i < size; i++) {
			if (sudoku[row][i] == nbr) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the number nbr already exists in the column
	 * 
	 * @param col The column
	 * @param nbr The number tested
	 * @return true if the number already exists in column
	 */
	private boolean existsInCol(int col, int number) {
		for (int i = 0; i < size; i++) {
			if (sudoku[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the number number already exists in the 3x3 box
	 * 
	 * @param row The row
	 * @param col The column
	 * @param nbr The number tested
	 * @return true if the number already exists in 3x3 box
	 */
	private boolean existsInBox(int row, int col, int number) {
		int firstRow = (row / 3) * 3;
		int firstCol = (col / 3) * 3;

		for (int i = firstRow; i < firstRow + 3; i++) {
			for (int j = firstCol; j < firstCol + 3; j++)
				if (sudoku[i][j] == number) {
					return true;
				}
		}

		return false;
	}

	/**
	 * Empties the sudoku.
	 */
	@Override
	public void clear() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < 9; col++) {
				sudoku[col][row] = zero;
			}
		}

	}

	/**
	 * Sets the digit number in the box row, col.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert in row, col
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	@Override
	public void setNumber(int row, int col, int number) {
		sudoku[row][col] = number;
	}

	/**
	 * Checks if the number can be placed in the row and the column considering the
	 * rules.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert in row, col
	 * @return true if the number can be placed
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	@Override
	public boolean trySetNumber(int row, int col, int number) {

		if (!existsInRow(row, number) && !existsInCol(col, number) && !existsInBox(row, col, number)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number on row, col.
	 * 
	 * @param row The row
	 * @param col The column
	 * @return the number in row, col
	 * @throws IllegalArgumentException if row or col is outside [0..8]
	 */
	@Override
	public int getNumber(int row, int col) {
		return sudoku[row][col];
	}

	/**
	 * Removes the number on row, col.
	 * 
	 * @param row The row
	 * @param col The column
	 * @throws IllegalArgumentException if row or col is outside [0..8]
	 */
	@Override
	public void removeNumber(int row, int col) {
		sudoku[row][col] = zero;

	}

	/**
	 * Reads the sudoku and returns true if the sudoku is solvable.
	 * 
	 * @return true if the sudoku is solvable
	 */
	@Override
	public boolean solve() {
		return solve(0, 0);
	}

	/**
	 * Returns a matrix with the numbers in the sudoku.
	 * 
	 * @return the numbers in the sudoku
	 */
	@Override
	public int[][] getNumbers() {
		return sudoku;
	}

	/**
	 * Fills in the numbers in numbers in the sudoku.
	 * 
	 * @param numbers The matrix with the numbers that should fill the sudoku
	 * @throws IllegalArgumentException if not all numbers in [0..9]
	 **/
	@Override
	public void setNumbers(int[][] sud) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				sudoku[row][col] = sud[row][col];
			}
		}

	}

	/**
	 * Prints the sudoku.
	 */
	public void printSudoku() {
		System.out.println("  ___  ___  ___  ___  ___  ___  ___  ___  ___");
		System.out.println();
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (c == 0) {
					System.out.print(" | " + sudoku[r][c] + " | ");
				} else if (c == 8) {

					System.out.println(" " + sudoku[r][c] + " | ");
					System.out.println("  ___  ___  ___  ___  ___  ___  ___  ___  ___");
				} else {
					System.out.print(" " + sudoku[r][c] + " | ");
				}
			}
			System.out.println();
		}

	}

	/**
	 * Fills in the sample numbers in the sudoku.
	 **/
	public void setSamplePuzzle() {
		int[][] sud = { { 0, 0, 8, 0, 0, 9, 0, 6, 2 }, { 0, 0, 0, 0, 0, 0, 0, 0, 5 }, { 1, 0, 2, 5, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 1, 0, 0, 9, 0 }, { 0, 5, 0, 0, 0, 0, 6, 0, 0 }, { 6, 0, 0, 0, 0, 0, 0, 2, 8 },
				{ 4, 1, 0, 6, 0, 8, 0, 0, 0 }, { 8, 6, 0, 0, 3, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0, 0 } };
		this.setNumbers(sud);

	}

}