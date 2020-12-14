package sudoku_jf;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Board {
	SolveButton solveButton;
	ClearButton clearButton;
	JFrame frame;
	Panel panel;
	CommandPanel cPanel;       
	
	public static void main(String[] args) {
		new Board();
	}
	
	public Board() {   
		panel = new Panel();
		frame = new JFrame("Sudoku");
		cPanel = new CommandPanel(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.NORTH);
		frame.add(cPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.setResizable(false);
		frame.pack();
	}
	
	

}