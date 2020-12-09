package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class SudokuGrid extends JPanel {
    private final Color innerBorder = new Color(0,0,0,40);
    private final Color bigBorder = new Color(0, 0, 0, 80);
    private final Color bgColor = new Color(251, 252, 253);
    private JTextField[][] inputFields;
    private JPanel[][] biggerBoxes;

    /**
     *
     */
    SudokuGrid() {

        this.setLayout(new GridLayout(3,3));

        inputFields = new JTextField[9][9];
        biggerBoxes = new JPanel[3][3];

        Border fieldBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                inputFields[i][k] = new JTextField();
                inputFields[i][k].setHorizontalAlignment(JTextField.CENTER);
                inputFields[i][k].setBackground(Color.WHITE);
                inputFields[i][k].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
                inputFields[i][k].setEditable(true);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                biggerBoxes[i][k] = new JPanel();
                biggerBoxes[i][k].setBorder(BorderFactory.createLineBorder(innerBorder, 1));
                biggerBoxes[i][k].setLayout(new GridLayout(3,3));
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
               int x = i/3;
               int y = k/3;
               if ((x+y)%2==0)
                   inputFields[i][k].setBackground(new Color(255, 185, 211,255));
                biggerBoxes[x][y].add(inputFields[i][k]);

            }

        }
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                this.add(biggerBoxes[i][k]);
            }
        }


        this.setBorder(BorderFactory.createEmptyBorder( 0,  20,  0,  20));
        this.setBackground(bgColor);
    }

    public JTextField[][] getGrid() {
        return inputFields;
    }

    public void clearGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                inputFields[i][j].setText("");
            }
        }
    }

    public void setNumber(int row, int col, int number) {
        inputFields[row][col].setText(Integer.toString(number));
    }

    private static final long serialVersionUID = 1L;
    @Override
    public Dimension getPreferredSize() {
        Dimension d = this.getParent().getSize();
        int newSize = d.width > d.height ? d.height : d.width;
        newSize = newSize == 0 ? 100 : newSize;
        return new Dimension(newSize, newSize);
    }


}
