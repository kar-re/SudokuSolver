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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bgColor = new Color(251, 252, 253);


        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(true);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground( bgColor);
        mainPanel.setLayout(new BorderLayout());

        JLabel titleFrame = new JLabel("Sudoku solver", SwingConstants.CENTER);
        titleFrame.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        titleFrame.setBackground(bgColor);

        mainPanel.add(titleFrame, BorderLayout.PAGE_START);

        JPanel gridWrapper = new JPanel(new GridBagLayout());
        grid = new SudokuGrid();
        gridWrapper.add(grid);
        gridWrapper.setBackground( bgColor);
        mainPanel.add(gridWrapper,  BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        solve = new JButton("Solve");
        clear = new JButton("Clear");
        buttons.add(solve);
        buttons.add(Box.createHorizontalGlue());
        buttons.add(clear);
        buttons.setBorder(BorderFactory.createEmptyBorder(32,32,32,32));
        buttons.setBackground( bgColor);



        mainPanel.add(buttons, BorderLayout.PAGE_END);
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
