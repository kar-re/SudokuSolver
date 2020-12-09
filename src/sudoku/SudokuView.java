package sudoku;

import javax.swing.*;

import java.awt.*;


public class SudokuView {

    private JButton solve, clear;
    private SudokuGrid grid;
    private JFrame frame;

    public SudokuView() {
        SwingUtilities.invokeLater(() -> createWindow( "Sudoku Solver", 540, 680));
    }
    private void createWindow(String title, int width, int height) {
        frame = new JFrame(title);
        //Ny JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        Color bgColor = new Color(251, 252, 253);


        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(true);
        JPanel mainPanel = new JPanel();

        JLabel titleFrame = new JLabel();
        titleFrame.setBorder(BorderFactory.createEmptyBorder( 0,  20,  0,  0));
        titleFrame.setText("Sudoku solver");
        titleFrame.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        //titleFrame.setPreferredSize(new Dimension(frame.getWidth(), 50));
        System.out.println(frame.getWidth());

        mainPanel.add(titleFrame, BorderLayout.PAGE_START);
        mainPanel.setBackground( bgColor);
        grid = new SudokuGrid();
        //sudokuPanel.setPreferredSize(frame.getPreferredSize());


        mainPanel.add(grid,  BorderLayout.CENTER);


        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        solve = new JButton();
        clear = new JButton();
        buttons.add(solve);
        buttons.add(clear);
        solve.setText("Solve");
        clear.setText("Clear");
        //buttons.setPreferredSize(new Dimension(frame.getWidth() - 30, 30));
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(buttons, BorderLayout.SOUTH);




        //Lite extra, valde att sätta en preferred size och resizable false


        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public JButton getSolveButton() {
        return solve;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getClearButton() {
        return clear;
    }

    public void setNumberGrid(int row, int col, int number) {
        grid.setNumber(row, col, number);
    }

    public JTextField[][] getNumberGrid() {
        return grid.getGrid();
    }

    public void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(null, error);
    }

}
