package sudoku_jf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SamplePuzzle extends JButton implements ActionListener{
	Panel panel;
	
	
	public SamplePuzzle(Panel panel) {
		super("Set Sample");
		
		this.panel = panel;
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.setSample();
		
	} 

}


