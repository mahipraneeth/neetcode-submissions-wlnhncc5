class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Boolean[][] canReachPacific = new Boolean[heights.length][heights[0].length];
        Boolean[][] canReachAtlantic = new Boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                isPacificReached(heights, i, j, visited, canReachPacific);
            }
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = heights[i].length - 1; j >= 0; j--) {
                boolean[][] visited1 = new boolean[heights.length][heights[i].length];
                isAtlanticReached(heights, i, j, visited1, canReachAtlantic);
            }
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private boolean isPacificReached(
        int[][] heights, int i, int j, boolean[][] visited, Boolean[][] canReach) {
        visited[i][j] = true;

        if (i == 0 || j == 0) {
            canReach[i][j] = true;
            return canReach[i][j];
        }

        if (canReach[i][j] != null) {
            return canReach[i][j];
        }

        // check going up
        if (!visited[i - 1][j] && heights[i - 1][j] <= heights[i][j]) {
            if (isPacificReached(heights, i - 1, j, visited, canReach)) {
                canReach[i][j] = true;
                return true;
            }
        }

        // check going left
        if (!visited[i][j - 1] && heights[i][j - 1] <= heights[i][j]) {
            if (isPacificReached(heights, i, j - 1, visited, canReach)) {
                canReach[i][j] = true;
                return true;
            }
        }

        // check going right
        if (j < heights[i].length - 1 && !visited[i][j + 1] && heights[i][j + 1] <= heights[i][j]) {
            if (isPacificReached(heights, i, j + 1, visited, canReach)) {
                canReach[i][j] = true;
                return true;
            }
        }

        // check going down
        if (i < heights.length - 1 && !visited[i + 1][j] && heights[i + 1][j] <= heights[i][j]) {
            if (isPacificReached(heights, i + 1, j, visited, canReach)) {
                canReach[i][j] = true;
                return true;
            }
        }

        visited[i][j] = false;
        canReach[i][j] = false;
        return canReach[i][j];
    }

    private boolean isAtlanticReached(
        int[][] heights, int i, int j, boolean[][] visited, Boolean[][] canReach) {
        visited[i][j] = true;

        if (i == heights.length - 1 || j == heights[i].length - 1) {
            canReach[i][j] = true;
            return canReach[i][j];
        }

        if (canReach[i][j] != null) {
            return canReach[i][j];
        }

        // check going right
        if (j < heights[i].length - 1 && !visited[i][j + 1] && heights[i][j + 1] <= heights[i][j]) {
            if (isAtlanticReached(heights, i, j + 1, visited, canReach)) {
                canReach[i][j] = true;
                return canReach[i][j];
            }
        }

        // check going down
        if (i < heights.length - 1 && !visited[i + 1][j] && heights[i + 1][j] <= heights[i][j]) {
            if (isAtlanticReached(heights, i + 1, j, visited, canReach)) {
                canReach[i][j] = true;
                return canReach[i][j];
            }
        }

        // check going up
        if (i > 0 && !visited[i - 1][j] && heights[i - 1][j] <= heights[i][j]) {
            if (isAtlanticReached(heights, i - 1, j, visited, canReach)) {
                canReach[i][j] = true;
                return canReach[i][j];
            }
        }

        // check going left
        if (j > 0 && !visited[i][j - 1] && heights[i][j - 1] <= heights[i][j]) {
            if (isAtlanticReached(heights, i, j - 1, visited, canReach)) {
                canReach[i][j] = true;
                return canReach[i][j];
            }
        }

        visited[i][j] = false;

        canReach[i][j] = false;
        return canReach[i][j];
    }
}
