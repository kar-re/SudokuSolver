public class Sudoku {
    private int[][] grid = new int[9][9];
    public Sudoku() {

    }

    public int getVal(int x, int y) {
        return grid[x][y];
    }

}
