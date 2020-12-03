package sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuController {
    private SudokuView view;
    private SudokuModel model;
    private SudokuSolver solver;

    public SudokuController(SudokuView view, SudokuModel model) {
        this.view = view;
        this.model = model;

        SwingUtilities.invokeLater(() -> initView());
    }

    private void initView() {


        view.getSolveButton().addActionListener(e -> {
            System.out.println("Pressed solve");
            if(solver == null)
                this.solver = new SolverAlt(parseGrid(), this);

            if (solver.solve())
                System.out.println("Solved!");

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
        JTextField[][] grid = view.getNumberGrid();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j].setText(Integer.toString(sudokuHard[i][j]));
            }
        }
    }

    public void setNumber(int row, int col, int number) {
        view.getNumberGrid()[row][col].setText(Integer.toString(number));
        view.getFrame().repaint();
    }

    private int[][] parseGrid() {
        JTextField[][] grid = view.getNumberGrid();
        int[][] sudokuGrid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                try {
                    if (grid[i][k].getText() != null) {
                        sudokuGrid[i][k] = Integer.parseInt(grid[i][k].getText());
                    } else {
                        sudokuGrid[i][k] = 0;
                    }
                } catch (Exception e) {
                    view.showErrorMessage("Inputs must be numbers only!");
                    break;
                }
            }

        }
        return sudokuGrid;
    }
}

