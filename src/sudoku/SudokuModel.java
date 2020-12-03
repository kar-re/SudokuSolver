package sudoku;

public class SudokuModel {
    private int[][] grid;
    public SudokuModel() {
        grid = new int[9][9];
    }

    public int getVal(int x, int y) {
        return grid[x][y];
    }

    public int[][] getGrid() {
        return grid;
    }

}
