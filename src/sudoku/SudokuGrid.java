package sudoku;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class SudokuGrid extends JPanel {
    private final Color innerBorder = new Color(0,0,0,40);
    private final Color bigBorder = new Color(0, 0, 0, 80);
    private final Color bgColor = new Color(251, 252, 253);
    private JTextField[][] inputFields;

    /**
     *
     */
    SudokuGrid() {

        this.setLayout(new GridLayout(9,1));
        JPanel[] panelsTop = new JPanel[9];
        inputFields = new JTextField[9][9];


        for (int i = 0; i < 9; i++) {
            panelsTop[i] = new JPanel();
            panelsTop[i].setLayout(new GridLayout(1, 9));
            panelsTop[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
            panelsTop[i].setAlignmentY(JPanel.CENTER_ALIGNMENT);
            for (int k = 0; k < 9; k++) {
                inputFields[i][k] = new JTextField();
                inputFields[i][k].setHorizontalAlignment(JTextField.CENTER);
                inputFields[i][k].setBackground(Color.WHITE);
                //inputFields[i][k].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(innerBorder, 1),BorderFactory.createMatteBorder(3, 3, 3, 3, bgColor)));
                inputFields[i][k].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
                //inputFields[i][k].setValue(0);
                inputFields[i][k].setEditable(true);
                panelsTop[i].add(inputFields[i][k]);
            }
            this.add(panelsTop[i]);
        }
//        panelsTop[0].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
//        panelsTop[1].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
//        panelsTop[2].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
//        panelsTop[3].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
//        panelsTop[4].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
//        panelsTop[5].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
//        panelsTop[6].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, bigBorder));
//        panelsTop[8].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, bigBorder));
        System.out.println(inputFields);
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
        // Relies on being the only component
        // in a layout that will center it without
        // expanding it to fill all the space.
        Dimension d = this.getParent().getSize();
        int newSize = d.width > d.height ? d.height : d.width;
        newSize = newSize == 0 ? 100 : newSize;
        return new Dimension(newSize, newSize);
    }


}
