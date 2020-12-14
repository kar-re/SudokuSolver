package sudoku_jf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener  {
	
	Panel panel;

	
	public ClearButton(Panel panel) {
		super("Clear");
		
		this.panel = panel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.clear();
		
	}

}