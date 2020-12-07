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
		//ska bara returna false ifall alla lösningar är testade
		return solve(0,0);
	}
	private boolean solve(int row, int col) {
		
		if (row == 8 && col == 9) {
			return true;			
		}
		 if (col == 9) {
	            row++;
	            col = 0;
		}
		 if (getNumber(row,col) != 0) {
			 return solve(row, col + 1);			 
		 }
		 for (int num = 1; num <= 9; num++) {
			 
	            if (isLegal(row,col,num)) {
	            	
	                setNumber(row,col,num); 
	 
	                if (solve( row, col + 1))
	                    return true;
	            }
	            
	            setNumber(row,col,0);
	        }
	        return false;
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
