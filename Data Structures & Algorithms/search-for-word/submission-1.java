class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)
                    && (word.length() == 1 || wordCheck(board, word, 0, i, j, new HashSet<>()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordCheck(
        char[][] board, String word, int k, int nexti, int nextj, Set<String> visited) {
        if (board[nexti][nextj] != word.charAt(k)) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }

        k = k + 1;
        visited.add(nexti + ":" + nextj);

        // go down
        if (nexti + 1 < board.length && !visited.contains((nexti + 1) + ":" + nextj)) {
            if (wordCheck(board, word, k, nexti + 1, nextj, visited)) {
                return true;
            }
        }

        // go up
        if (nexti - 1 >= 0 && !visited.contains((nexti - 1) + ":" + nextj)) {
            if (wordCheck(board, word, k, nexti - 1, nextj, visited)) {
                return true;
            }
        }

        // go left
        if (nextj - 1 >= 0 && !visited.contains(nexti + ":" + (nextj - 1))) {
            if (wordCheck(board, word, k, nexti, nextj - 1, visited)) {
                return true;
            }
        }

        // go right
        if (nextj + 1 < board[nexti].length && !visited.contains(nexti + ":" + (nextj + 1))) {
            if (wordCheck(board, word, k, nexti, nextj + 1, visited)) {
                return true;
            }
        }
        visited.remove(nexti + ":" + nextj);
        return false;
    }
}
