package sudoku;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SudokuGrid extends JPanel {
    private final Color innerBorder = new Color(0,0,0,40);
    private final Color bigBorder = new Color(0, 0, 0, 80);
    private final Color bgColor = new Color(251, 252, 253);
    private int[][] grid;
    SudokuGrid() {
        this.setLayout(new GridLayout(3,3));
        JPanel[] panelsTop = new JPanel[9];
        JTextField[][] inputFields = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            panelsTop[i] = new JPanel();
            panelsTop[i].setLayout(new GridLayout(3, 3));
            panelsTop[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
            panelsTop[i].setAlignmentY(JPanel.CENTER_ALIGNMENT);
            for (int k = 0; k < 9; k++) {
                inputFields[i][k] = new JTextField();
                inputFields[i][k].setHorizontalAlignment(JTextField.CENTER);
                inputFields[i][k].setBackground(Color.WHITE);
                inputFields[i][k].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(innerBorder, 1),BorderFactory.createMatteBorder(3, 3, 3, 3, bgColor)));
                inputFields[i][k].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
                inputFields[i][k].setText(" ");
                inputFields[i][k].setEditable(true);
                int finalI = i;
                int finalK = k;
                inputFields[i][k].addActionListener((ActionEvent e) -> {
                    grid[finalI][finalK] = Integer.getInteger(inputFields[finalI][finalK].getText());
                });
                panelsTop[i].add(inputFields[i][k]);
            }
            this.add(panelsTop[i]);
        }
        panelsTop[0].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
        panelsTop[1].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
        panelsTop[2].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
        panelsTop[3].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
        panelsTop[4].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
        panelsTop[5].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
        panelsTop[6].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, bigBorder));
        panelsTop[8].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, bigBorder));

        this.setBorder(BorderFactory.createEmptyBorder( 0,  20,  0,  20));
    }

    public int[][] getGrid() {
        return grid;
    }

}
