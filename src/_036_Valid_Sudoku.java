import java.util.HashSet;
import java.util.Set;

/**
 * 
 * etermine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author Shengyi
 *
 */

public class _036_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
        	return false;
        }
        
        Set<Character> set = new HashSet<Character>();
        
        for (int i = 0; i < board.length; i++) {
            set = new HashSet<Character>();
        	for (int j = 0; j < board[0].length; j++) {
        		char val = board[i][j];
        		
        		if (val != '.' && set.contains(val)) {
        			return false;
        		} else {
        			set.add(val);
        		}
        	}
        }
        
        for (int i = 0; i < board.length; i++) {
            set = new HashSet<Character>();
        	for (int j = 0; j < board[0].length; j++) {
        		char val = board[j][i];
        		
        		if (val != '.' && set.contains(val)) {
        			return false;
        		} else {
        			set.add(val);
        		}
        	}
        }
        
        for (int i = 0; i < board.length; i = i + 3) {
        	for (int j = 0; j < board[0].length; j = j + 3) {
        	    set = new HashSet<Character>();
        		for (int k = 0; k < board[0].length; k++) {
        			char val = board[i + k / 3][j + k % 3];
            		
            		if (val != '.' && set.contains(val)) {
            			return false;
            		} else {
            			set.add(val);
            		}
        		}
        	}
        }
        
        return true;
    }
}
