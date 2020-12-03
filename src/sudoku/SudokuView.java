package sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SudokuView {

    public SudokuView() {
        SwingUtilities.invokeLater(() -> createWindow( "sudoku.Sudoku sudoku.Solver", 540, 960));
    }
    private void createWindow(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        //Ny JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        Color bgColor = new Color(251, 252, 253);
        Color innerBorder = new Color(0,0,0,40);
        Color bigBorder = new Color(0, 0, 0, 80);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(true);
        JPanel mainPanel = new JPanel();
        JLabel titleFrame = new JLabel();
        titleFrame.setBorder(BorderFactory.createEmptyBorder( 0,  20,  0,  0));
        titleFrame.setText("sudoku.Sudoku solver");
        titleFrame.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        titleFrame.setPreferredSize(new Dimension(width, 50));

        mainPanel.add(titleFrame, BorderLayout.PAGE_START);
        mainPanel.setBackground( bgColor);
        JPanel sudokuPanel = new JPanel();

        sudokuPanel.setLayout(new GridLayout(3,3));
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
                panelsTop[i].add(inputFields[i][k]);
            }
            sudokuPanel.add(panelsTop[i]);
        }
        panelsTop[0].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
        panelsTop[1].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
        panelsTop[2].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
        panelsTop[3].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 3, bigBorder));
        panelsTop[4].setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bigBorder));
        panelsTop[5].setBorder(BorderFactory.createMatteBorder(0, 3, 3, 0, bigBorder));
        panelsTop[6].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, bigBorder));
        panelsTop[8].setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, bigBorder));


        sudokuPanel.setBackground(bgColor);
        sudokuPanel.setPreferredSize(new Dimension(width, width));
        sudokuPanel.setBorder(BorderFactory.createEmptyBorder( 0,  20,  0,  20));
        mainPanel.add(sudokuPanel,  BorderLayout.CENTER);


        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JButton solve = new JButton();
        JButton clear = new JButton();
        buttons.add(solve);
        buttons.add(clear);
        solve.setText("Solve");
        clear.setText("Clear");
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(buttons, BorderLayout.SOUTH);

        frame.add(mainPanel);

        //Lite extra, valde att sätta en preferred size och resizable false


        frame.pack();
        frame.setVisible(true);
    }
/*
    void oldstuff() {
        //Gör en sortedlistmodel med listan från GWC
        SortedListModel<Map.Entry<String, Integer>> list = new SortedListModel(counter.getWordList());

        JList<Map.Entry<String, Integer>> listcomponent = new JList<>(list);
        JScrollPane scrollpanel = new JScrollPane(listcomponent);
        pane.add(scrollpanel);
        //Gör en JList och en scroll panel till ovannämda lista.



        JPanel controlpanel = new JPanel();
        JButton alph = new JButton("Alphabetic");
        alph.addActionListener(event -> {
            //Lambda whaddup
            //Fråga till handledare - hur fungerar detta? Fortfarande novis på lambda-uttryck
            list.sort((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)->
                    o1.getKey().compareTo(o2.getKey()));
        });
        //Ny panel plus knapp för alphabetic
        JButton freq = new JButton("Frequency");
        freq.addActionListener(event -> {
            WordCountComparator comp = new WordCountComparator();
            list.sort((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)->
                    o2.getValue() - o1.getValue());
        });
        //Ny knapp för frequency, sorteras default med WordCountComparator

        JTextField textfield = new JTextField("Här kan du söka efter saker");
        textfield.setForeground(new Color(0.5f,0.5f,0.5f));
        textfield.addFocusListener(new FocusListener() {
            //Focuslistener för att nulla texten när användaren skriver något i textfältet, och ändrar färg
            public void focusGained(FocusEvent e) {
                textfield.setText("");
                textfield.setForeground(new Color(0.0f,0.0f,0.0f));
            }

            public void focusLost(FocusEvent e) {
                // Gör inget
            }
        });

        //Sökknapp, replacear space med "" för att lösa valbar uppgift
        JButton search = new JButton("Search");
        search.addActionListener(event -> {
            String searchTxt = textfield.getText().toLowerCase();
            //tolowercase för att det skall bli konsistent
            searchTxt = searchTxt.replaceAll("\\s+","");
            int index = -1;
            for (int i = 0; i < list.getSize(); i++) {
                if (list.getElementAt(i).getKey().contains(searchTxt)) {
                    //Letar om en viss nyckel innehåller vald text, breakar loopen isf.
                    //Skulle kunna implementeras bättre med ett antal kandidater, nu väljer den det första
                    //ordet som innehåller t.ex 'pojke'
                    index = i;
                    break;
                }
            }
            if (index == -1 ) {
                //Om index är fortsatt -1, returnera metoden
                JOptionPane.showMessageDialog(null, "Hittade ej!", "Ordet du letar efter finns inte i listan", JOptionPane.ERROR_MESSAGE);
                return;
            }
            listcomponent.setSelectedIndex(index);
            listcomponent.ensureIndexIsVisible(index);

        });

        //Lägg till alla knappar i controlpanel
        controlpanel.add(alph);
        controlpanel.add(freq);
        controlpanel.add(textfield);
        controlpanel.add(search);
        //Lägg till control panel till borderlayout south
        pane.add(controlpanel, BorderLayout.SOUTH);
        //Sätt search till default button, dvs kommer klickas på när man trycker på enter
        controlpanel.getRootPane().setDefaultButton(search);
    }*/


}
