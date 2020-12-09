package sudoku;

public class Solver implements SudokuSolver {
	private int[][] grid;
	private int[][] unsolvedGrid;
	public Solver(int[][] grid) {
		this.grid = grid;
		this.unsolvedGrid = grid;
	}

	@Override
	public void setNumber(int row, int col, int number) {
		if (number > 9 || number < 1 || row > 8 || row < 0 || col > 8 || col < 0) {
			throw new IllegalArgumentException();
		} else {
			grid[row][col] = number;
		}

	}

	@Override
	public boolean trySetNumber(int row, int col, int number) {
		if (number > 9 || number < 1 || row > 8 || row < 0 || col > 8 || col < 0) {
			throw new IllegalArgumentException();
		} else {
			return isLegal(row, col, number);
		}
	}

/**
 *Removes number at position row, col
 * 
 * @param row	The row
 * @param col		The column
 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
 *                                  outside [0..8]
 */
	@Override
	public int getNumber(int row, int col) {
		if (row > 8 || row < 0 || col > 8 || col < 0) {
			throw new IllegalArgumentException();
		} else {
			return grid[row][col];
		}
	}
	/**
	 *Removes number at position row, col
	 * 
	 * @param row	The row
	 * @param col		The column
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	@Override
	public void removeNumber(int row, int col) {
		if (row > 8 || row < 0 || col > 8 || col < 0) {
			throw new IllegalArgumentException();
		} else {
			grid[row][col] = 0;
		}

	}

	@Override
	public void clear() {
		grid = new int[9][9];
	}

	@Override
	public boolean solve() {
		return solve(0, 0);
	}

	/**
	 *Solves the sudoku
	 * 
	 * @param row	The row
	 * @param col		The column
	 * @return returns true if sudoku is solvable returns false if not
	 */
	private boolean solve(int row, int col) {

		if (row == 8 && col == 9) {
			return true;
		}
		if (col == 9) {
			row++;
			col = 0;
		}
		if (getNumber(row, col) != 0) {
			if(!trySetNumber(row,col, getNumber(row,col))) {
				System.out.println("row is: " + row + " col is: " + col + " number is: " + getNumber(row,col));
				return false;
			}
			return solve(row, col + 1);
		}
		for (int num = 1; num <= 9; num++) {

			if (trySetNumber(row, col, num)) {

				setNumber(row, col, num);

				if (solve(row, col + 1)) {
					return true;					
				}else {
					removeNumber(row, col);					
				}
				
			}

		}
		return false;
	}

	/**
	 * Checks all digits in one row to not be the same as number
	 * 
	 * @param row    The row
	 * @param number The digit that is checked for
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	private boolean checkRow(int row, int col, int number) {
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == number && i != col) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks all digits in one column to not be the same as number
	 * 
	 * @param col    The column
	 * @param number The digit that is checked for
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	private boolean checkCol(int row, int col, int number) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == number && i != row) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks that number is not in the 3x3 region row and col are placed in,
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to check for
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	private boolean checkRegion(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (grid[i][j] == number && i != row && j != col)
					return true;
			}
		}
		return false;
	}

	/**
	 * Checks so that the move about to be made is legal returns false if not.
	 * 
	 * @param row    The row
	 * @param col    The column
	 * @param number The digit to insert in row, col
	 * @throws IllegalArgumentException if number is outside [1..9] or row or col is
	 *                                  outside [0..8]
	 */
	private boolean isLegal(int row, int col, int number) {
		return !(checkRow(row, col, number) || checkCol(row, col, number) || checkRegion(row, col, number));
	}

	@Override
	public int[][] getNumbers() {
		return grid;
	}

	@Override
	public void setNumbers(int[][] numbers) {
		grid = numbers;
	}

}
