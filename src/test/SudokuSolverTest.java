package test;

import static org.junit.jupiter.api.Assertions.*;
import sudoku.*;

import java.util.Arrays;

class SudokuSolverTest {
    private int[][] sudokuBasic = {
            {8,6,0,0,2,0,0,0,0},
            {0,0,0,7,0,0,0,5,9},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,6,0,8,0,0},
            {0,4,0,0,0,0,0,0,0},
            {0,0,5,3,0,0,0,0,7},
            {0,0,0,0,0,0,0,0,0},
            {0,2,0,0,0,0,6,0,0},
            {0,0,7,5,0,9,0,0,0}
    };
    private int[][] sudokuImpossible = {
            {8,6,8,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };
    private int[][] sudokuImpossible2 = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };
    /**
     * SudokuHard taken from
     * http://www.mathsphere.co.uk/downloads/sudoku/10203-hard.pdf
     */
    private int[][] sudokuHard = {
            {0,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,0,9,4,0},
            {0,0,3,0,0,0,0,0,5},
            {0,9,2,3,0,5,0,7,4},
            {8,4,0,0,0,0,0,0,0},
            {0,6,7,0,9,8,0,0,0},
            {0,0,0,7,0,6,0,0,0},
            {0,0,0,9,0,0,0,2,0},
            {4,0,8,5,0,0,3,6,0}
    };
    private int[][] sudokuSolved = {
            {6,8,4,1,5,9,7,3,2},
            {7,5,1,8,3,2,9,4,6},
            {9,2,3,6,7,4,1,8,5},
            {1,9,2,3,6,5,8,7,4},
            {8,4,5,2,1,7,6,9,3},
            {3,6,7,4,9,8,2,5,1},
            {2,3,9,7,4,6,5,1,8},
            {5,1,6,9,8,3,4,2,7},
            {4,7,8,5,2,1,3,6,9},
    };
    private SudokuSolver solver;
    private SudokuSolver solverHard;
    private SudokuSolver solverImpossible;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        solver = new Solver(sudokuBasic);
        solverHard = new Solver(sudokuHard);
        solverImpossible = new Solver(sudokuImpossible2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        solver = null;
    }

    @org.junit.jupiter.api.Test
    void setNumber() {
        solver.setNumber(0,0,1);
        assertEquals(Integer.valueOf(1),solver.getNumber(0,0));
    }

    @org.junit.jupiter.api.Test
    void trySetNumber() {
    }

    @org.junit.jupiter.api.Test
    void getNumber() {
        solver.setNumber(4,0,2);
        assertEquals(Integer.valueOf(2), solver.getNumber(4,0));
    }

    @org.junit.jupiter.api.Test
    void removeNumber() {
        solver.removeNumber(1,3);
        assertEquals(Integer.valueOf(0), solver.getNumber(1,3));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        solver.clear();
        assertTrue(Arrays.deepEquals(solver.getNumbers(),new int[9][9]), "Didn't clear properly!");
    }

    @org.junit.jupiter.api.Test
    void solve() {
        solverHard.solve();
        for (int i = 0; i < 9; i++ ) {
            System.out.print(i + " : ");
            for(int n =0 ; n < 9; n ++) {
             System.out.print(solverHard.getNumber(i,n));
            }
            System.out.println("");
        }
        for (int i = 0; i < 9; i++ ) {
            System.out.print(i + " : ");
            for(int n =0 ; n < 9; n ++) {
                System.out.print(sudokuSolved[i][n]);
            }
            System.out.println("");
        }
        System.out.println(sudokuSolved);
        System.out.println(solverHard.getNumbers());
        assertTrue(Arrays.deepEquals(solverHard.getNumbers(),sudokuSolved), "Didn't solve correctly!");
        assertEquals(false, solverImpossible.solve(), "Did not return false on impossible sudoku");

    }

    @org.junit.jupiter.api.Test
    void getNumbers() {
        assertEquals(solver.getNumbers(), sudokuBasic);
    }

    @org.junit.jupiter.api.Test
    void setNumbers() {
        solver.setNumbers(sudokuHard);
        assertEquals(solver.getNumbers(), sudokuHard);
    }
}