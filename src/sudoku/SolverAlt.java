package sudoku;

public class SolverAlt implements SudokuSolver {
	private int[][] grid;
	private SudokuController controller;
	public SolverAlt(int[][] grid) {
		this.grid = grid;
	}
	public SolverAlt(int[][] grid, SudokuController controller) {
		this.grid = grid;
		this.controller = controller;
	}
	@Override
	public void setNumber(int row, int col, int number) {
		if(controller != null)
			controller.setNumber(row,col,number);
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
		this.grid = new int[9][9];
	}

	@Override
	public boolean solve() {
		for(int row=0;row<9;row++)
		{
			for(int col=0;col<9;col++)
			{
				if(grid[row][col]==0)
				{
					for(int number=1;number<=9;number++)
					{
						if(isLegal(row, col, number))
						{
							setNumber(row, col, number);

							if(solve())
							{
								return true;
							}
							else
							{
								setNumber(row, col, 0);
							}
						}
					}
					return false;
				}
			}
		}
		return true;
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
