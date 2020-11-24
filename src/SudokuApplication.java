import java.awt.BorderLayout;
import javax.swing.*;


public class SudokuApplication {
    public static void main(String[] args) {
        try {
            /* Use an appropriate Look and Feel */
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        SudokuView view = new SudokuView();

    }
}

