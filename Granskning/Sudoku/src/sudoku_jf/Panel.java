package sudoku_jf;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
	JTextField[][] textField;
	boolean color;
	Sudoku sud; 

	public Panel() { 
		super();
		textField = new JTextField[9][9];
		sud = new Sudoku();
		this.setLayout(new GridLayout(9, 9));
		color = true;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				textField[row][col] = new JTextField(2);
				paintSudoku(row, col);
				if ((col + 1) % 3 == 0) {
					color = !color; 
				}
				Font font = new Font("Dialog", Font.BOLD, 20); 
				textField[row][col].setFont(font);
				textField[row][col].setHorizontalAlignment(JTextField.CENTER);
				this.add(textField[row][col]);
			}
			if ((row + 1) / 3 == 1) {
				color = false;
			} else {
				color = true;
			}
		}
	}
	public void setSample() {
		sud.clear();
		sud.setSamplePuzzle();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				textField[row][col].setText("" + sud.getNumbers()[row][col]); 
				if(sud.getNumbers()[row][col] == 0) {
					textField[row][col].setText("");
				}
			}
		}
		
	}
	
	public void solve() {
		int[][] numbers = new int[9][9];
		String validChars = "123456789";
		boolean invalidInput = false;
	
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				String currentNbr = textField[row][col].getText(); 
				int num = 0;
				try {
					if (!currentNbr.equals("") ) { 
						num = Integer.parseInt(currentNbr); 
						if (!isValidDigit(currentNbr) || !validChars.contains(currentNbr) || currentNbr.length() !=1 ) {
							invalidInput = true;	
						}
					}
					sud.setNumber(row, col, num);
				} catch (NumberFormatException e) {
					invalidInput = true;
				}
			}
		}
		if (invalidInput) {
			JOptionPane.showMessageDialog(this, "Invalid input, enter a number between 1-9");
		}
		else {
			boolean sudSolved = sud.solve();
			if (sudSolved) {
				numbers = sud.getNumbers();
				for (int row = 0; row < 9; row++) {
					for (int col = 0; col < 9; col++) {
						textField[row][col].setText("" + numbers[row][col]);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "The entered sudoku has no solution, try again");
			}
		}
	}

	public void paintSudoku(int row, int col) {
		if (color) {
			textField[row][col].setBackground(new Color(255, 153, 0));
		}
	}

	public void clear() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				textField[row][col].setText("");
			}
		}
		sud.clear();
	}

	public boolean isValidDigit(String value) {
		if (!Character.isDigit(value.charAt(0))) {
			return false;
		}
		return true;
	}
}