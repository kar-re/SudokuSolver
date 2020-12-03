package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

class SudokuSolverTest {
    private int[][] sudoku = {
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

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        SudokuSolver solver = new Solver();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setNumber() {
    }

    @org.junit.jupiter.api.Test
    void trySetNumber() {
    }

    @org.junit.jupiter.api.Test
    void getNumber() {
    }

    @org.junit.jupiter.api.Test
    void removeNumber() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void solve() {
    }

    @org.junit.jupiter.api.Test
    void getNumbers() {
    }

    @org.junit.jupiter.api.Test
    void setNumbers() {
    }
}