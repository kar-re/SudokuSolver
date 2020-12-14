package sudoku_jf;

public interface SudokuSolver {
	
	void setNumber(int row, int col, int number); 

	
	boolean trySetNumber(int row, int col, int number);

	
	int getNumber(int row, int col);

	
	void removeNumber(int row, int col);

	
	void clear();

	
	boolean solve();

	
	int[][] getNumbers();

	
	void setNumbers(int[][] numbers);
}

/*
 * TBD: Skriva javadoc-kommentarer (PÃ¥bÃ¶rjat, kommentaren till setNumber Ã¤r klar.)
 *  Kommentarerna ska vara pÃ¥ ett sprÃ¥k (gÃ¤rna engelska, annars svenska) och fÃ¶lja 
 *  konventionen fÃ¶r javadoc-kommentarer.
  */