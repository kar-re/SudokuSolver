package sudoku;

import javax.swing.*;


public class SudokuApplication {
    private static SudokuController controller;
    private static SudokuView view;

    public static void main(String[] args) {

        //Use an appropriate Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        //Instantiate SudokuView and SudokuController
        view = new SudokuView();
        controller = new SudokuController(view);

    }
}

