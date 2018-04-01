
public class _079_Word_Search {
	public boolean exist(char[][] board, String word) {
        if (maxtrix == null || matrix.length == 0) {
        return false;
    }
    
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
           if (dfs(s, matrix, visited, i, j, 0)) {
               return true;
           }
        }
    }
    
    return false;
}

private boolean dfs(String s, char[][] matrix, boolean[][] visited, int i, int j, int index) {
    if (index == s.length() - 1 && matrix[i][j] == s.charAt(index)) {
        return true;
    }
    
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || s.charAt(index) != matrix[i][j] || visited[i][j]) {
        visited[i][j] = true;
        return false;
    }
    
    visited[i][j] = true;
    
    return dfs(s, matrix, visited, i + 1; j, index + 1) || dfs(s, matrix, visited, i - 1, j, index + 1) || dfs(s, matrix, visited, i, j + 1, index + 1) || dfs (s, matrix, visited, i, j - 1, index + 1);
    }
}
