package sudoku_jf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener {
	Panel panel;
	
	
	public SolveButton(Panel panel) {
		super("Solve");
		
		this.panel = panel;
		addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.solve();
		
	} 

}