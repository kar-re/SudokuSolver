package sudoku;

public class Solver implements SudokuSolver {
	private int[][] grid;
	public Solver(int[][] grid) {
		this.grid = grid;
	}
	@Override
	public void setNumber(int row, int col, int number) {
		grid[row][col] = number;
		
	}

	@Override
	public boolean trySetNumber(int row, int col, int number) {
        return isLegal(row,col,number);
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
        //for (int i = 0; i < 9; i++) {
        //    for (int j = 0; j < 9; j++) {
        if (grid[0][0] == 0)
            	    return solve(0,0);
         //   	}
        //}
        return true;
	}

    private boolean solve(int i, int j) {
    	int currNumber = grid[i][j] +1;
    	for (int number = currNumber; number <= 9; number++) {
    		int nexti = i+1;
    		int nextj = j+1;
    		if(isLegal(i,j, number)) {
    			grid[i][j] = number;
    			if(nexti > 8 && nextj > 8) {
    				return true;
    			}
    			if(nexti > 8 && nextj < 8) {
    				solve(0,nextj);
    			}
    			else if(nexti < 8){
    				solve(nexti, j);
    			}
    			return false;
    		}
    	}
    	if(grid[0][0] != 0) {
    		return false;    		
    	}
    	else {
    		if(i > 0) {
    			solve(i-1,j);
    		}
    		else {
    			solve(9,j-1);
    		}
    	}
    	return false;
    }

    private boolean checkRow(int row, int number) {
        for (int i = 0; i < 9; i++ ) {
            if (grid[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int col, int number) {
        for (int i = 0; i < 9; i++ ) {
            if (grid[i][col] == number) {
                return true;
            }
        }
        return false;
    }
    private boolean checkRegion(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

    	for (int i = r; i < r+3; i++ ) {
    		for(int n =c ; n < c+3; n ++) {
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
