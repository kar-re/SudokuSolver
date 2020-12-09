package sudoku;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SudokuController {
    private SudokuView view;
    private SudokuSolver solver;

    public SudokuController(SudokuView view) {
        this.view = view;


        SwingUtilities.invokeLater(() -> initView());
    }

    private void initView() {
        //Set up buttons
        view.getSolveButton().addActionListener(e -> {
            System.out.println("Pressed solve");
            try {

                if(solver == null)
                    this.solver = new Solver(parseGrid());
                solver.setNumbers(parseGrid());
                solver.solve();
                setGrid(solver.getNumbers());

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        view.getClearButton().addActionListener(e -> {
            System.out.println("Pressed clear");
            JTextField[][] grid = view.getNumberGrid();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j].setText("");
                }
            }
        });
        //Set default numbers
    setDefault();

    }

    private void setDefault() {
         int[][] sudokuBasic = {
                {8,6,0,0,2,0,0,0,0},
                {0,0,0,7,0,0,0,5,9},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,6,0,8,0,0},
                {0,4,0,0,0,0,0,0,0},
                {0,0,5,3,0,0,0,0,7},
                {0,0,0,0,0,0,0,0,0},
                {0,2,0,0,0,0,6,0,0},
                {0,0,7,5,0,9,0,0,0}
        };
        int[][] sudokuHard = {
                {0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,9,4,0},
                {0,0,3,0,0,0,0,0,5},
                {0,9,2,3,0,5,0,7,4},
                {8,4,0,0,0,0,0,0,0},
                {0,6,7,0,9,8,0,0,0},
                {0,0,0,7,0,6,0,0,0},
                {0,0,0,9,0,0,0,2,0},
                {4,0,8,5,0,0,3,6,0}
        };
        setGrid(sudokuBasic);
    }


    public void setGrid(int[][] grid) {
        JTextField[][] viewGrid = view.getNumberGrid();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                viewGrid[i][j].setText(Integer.toString(grid[i][j]));
            }
        }
    }


    private int[][] parseGrid() throws Exception {
        JTextField[][] grid = view.getNumberGrid();
        int[][] sudokuGrid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                    if (!grid[i][k].getText().equals("")) {
                        try {
                        sudokuGrid[i][k] = Integer.parseInt(grid[i][k].getText());
                        } catch (Exception e) {
                            e.printStackTrace();
                            view.showErrorMessage("Inputs must be numbers only!");
                        }
                    } else {
                        sudokuGrid[i][k] = 0;
                    }

            }

        }
        if(Arrays.deepEquals(sudokuGrid, new int[9][9])){
            throw new Exception("You cannot solve a empty grid!");
        }
        return sudokuGrid;
    }
}

