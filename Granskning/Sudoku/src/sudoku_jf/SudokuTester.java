package sudoku_jf;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SudokuTester {
	private Sudoku sud;

	@Before
	public void setUp() throws Exception {
		sud = new Sudoku();

	}

	@After
	public void tearDown() throws Exception {
		sud = null;
	}

	@Test
	public void testGetNumbers() {
		sud.getNumbers()[6][5] = 1;
		sud.printSudoku();
		int[][] testSud = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				testSud[r][c] = 0;
			}
		}
		testSud[6][5] = 1;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertTrue(sud.getNumbers()[r][c] == testSud[r][c]);
			}
		}

	}

	@Test
	public void testGetNumber() {
		sud.getNumbers()[6][5] = 1;
		assertTrue(sud.getNumber(6, 5) == 1);
	}

	@Test
	public void testTrySetNumber() {
		assertTrue(sud.trySetNumber(1, 1, 2));
	}

	@Test
	public void testSetNumber() {
		sud.setNumber(0, 0, 1);
		assertTrue(sud.getNumbers()[0][0] == 1);
	}

	@Test
	public void testSetNumbers() {
		Random rand = new Random(); // instance of random class
		int[][] testSudoku = new int[9][9];
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				testSudoku[r][c] = rand.nextInt(8) + 1;
			}
		}
		sud.setNumbers(testSudoku);
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertTrue(sud.getNumbers()[r][c] == testSudoku[r][c]);
			}
		}

	}

	@Test
	public void testRemoveNumber() {
		sud.getNumbers()[6][5] = 1;
		sud.removeNumber(6, 5);
		assertTrue(sud.getNumbers()[5][6] == 0);
	}

	@Test
	public void testClear() {
		sud.setNumber(0, 2, 8);
		sud.setNumber(0, 5, 9);
		sud.setNumber(0, 7, 6);
		sud.solve();

		sud.clear();
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				assertTrue(sud.getNumbers()[r][c] == 0);
			}
		}
	}

	@Test
	public void testSolvableSudoku() {
		// test sudoku example in description
		sud.setSamplePuzzle();
		sud.solve();
		assertTrue(sud.solve());
	}

	@Test
	public void testUnsolvableSudoku() {
		// note: can't use setNumber() when setting a number that makes the sudoku
		// unsolvable

		// test same column
		sud.setNumber(0, 1, 8);
		sud.getNumbers()[6][1] = 8;
		sud.solve();
		assertTrue(!sud.solve());
		sud.clear();
		// test same row
		sud.setNumber(5, 2, 8);
		sud.getNumbers()[5][7] = 8;
		assertTrue(!sud.solve());
		sud.clear();
		// test same 3x3 box
		sud.setNumber(8, 8, 1);
		sud.getNumbers()[7][8] = 1;
		assertTrue(!sud.solve());
	}

	@Test
	public void testSolveEmptySudoku() {
		sud.solve();
		assertTrue(sud.solve());

	}

}
