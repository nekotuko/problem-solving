package solution;

public class SolutionDFS {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // right, down, left, up

        return dfs(image, directions, visited, sr, sc, image[sr][sc], color);
    }

    private int[][] dfs(int[][] image, int[][] directions, boolean[][] visited, int row, int col, int originalColor,
            int targetColor) {
        visited[row][col] = true;
        image[row][col] = targetColor;

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (pixelIsValid(image, nextRow, nextCol, visited, originalColor)) {
                dfs(image, directions, visited, nextRow, nextCol, originalColor, targetColor);
            }
        }

        return image;

    }

    // check if pixel in question is within bounds and matches the original color:
    private boolean pixelIsValid(int[][] image, int row, int col, boolean[][] visited, int originalColor) {
        // Check bounds:
        if (!(row >= 0 && row < image.length && col >= 0 && col < image[0].length))
            return false;

        // Check visited:
        if (visited[row][col])
            return false;

        // Check color:
        if (image[row][col] != originalColor)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println("lc-0733-flood-fill");
    }
}
