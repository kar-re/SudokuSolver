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
		grid[row][col] = number;

	}

	@Override
	public boolean trySetNumber(int row, int col, int number) {
		return isLegal(row, col, number);
	}

	@Override
	public int getNumber(int row, int col) {
		return grid[row][col];
	}

	@Override
	public void removeNumber(int row, int col) {
		grid[row][col] = 0;

	}

	@Override
	public void clear() {
		grid = new int[9][9];
	}

	@Override
	public boolean solve() {
		return solve(0, 0);
	}

	private boolean solve(int i, int j) {
		// System.out.println("currNumber and place: " +currNumber + " " + i + " " + j);
		int nexti = i + 1;
		int nextj = j;
		if (nexti > 8) {
			nexti = 0;
			nextj++;
		}
		if (getNumber(i, j) == 0) {
			for (int number = 1; number <= 9; number++) {
				if (isLegal(i, j, number)) {
					System.out.println("number placed at: " + i + " " + j + " " + number);
					setNumber(i, j, number);
					if (solve(nexti, nextj)) {
						return true;
					} else {
						setNumber(i, j, 0);
					}
				}
			}
			return false;
		}
		return true;
	}

	private boolean checkRow(int row, int number) {
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean checkCol(int col, int number) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean checkRegion(int row, int col, int number) {
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++) {
			for (int n = c; n < c + 3; n++) {
				if (grid[i][n] == number)
					return true;
			}
		}
		return false;
	}

	private boolean isLegal(int row, int col, int number) {
		return !(checkRow(row, number) || checkCol(col, number) || checkRegion(row, col, number));
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