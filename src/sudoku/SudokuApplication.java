package sudoku;

import javax.swing.*;


public class SudokuApplication {
    private static SudokuController controller;
    private static SudokuModel model;
    private static SudokuView view;
    public static void main(String[] args) {
        try {
            /* Use an appropriate Look and Feel */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        model = new SudokuModel();
        view = new SudokuView();
        controller = new SudokuController(view, model);

    }
}

