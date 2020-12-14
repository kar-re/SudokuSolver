package sudoku_jf;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class CommandPanel extends JPanel {
	private SolveButton solveButton;
	private ClearButton clearButton;
	private SamplePuzzle sampleButton;

	public CommandPanel(Panel panel) {
		solveButton = new SolveButton(panel);
		clearButton = new ClearButton(panel);
		sampleButton = new SamplePuzzle(panel);
		
		add(solveButton);
		add(clearButton);
		add(sampleButton);
	}
}