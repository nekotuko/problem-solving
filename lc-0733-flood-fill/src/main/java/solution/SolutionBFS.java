package solution;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionBFS {

    // check if pixel in question is within bounds and matches the original color:
    private boolean pixelIsValid(int[][] image, int[] pixel, boolean[][] visited, int originalColor) {
        // Check bounds:
        if (!(pixel[0] >= 0 && pixel[0] < image.length && pixel[1] >= 0 && pixel[1] < image[0].length))
            return false;

        // Check visited:
        if (visited[pixel[0]][pixel[1]])
            return false;

        // Check color:
        if (image[pixel[0]][pixel[1]] != originalColor)
            return false;

        return true;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // right, down, left, up
        boolean[][] visited = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { sr, sc });

        while (!q.isEmpty()) {

            int[] currPixel = q.poll();
            visited[currPixel[0]][currPixel[1]] = true;
            image[currPixel[0]][currPixel[1]] = color;

            for (int[] direction : directions) {
                int[] nextPixel = new int[] { currPixel[0] + direction[0], currPixel[1] + direction[1] };
                if (pixelIsValid(image, nextPixel, visited, originalColor)) {
                    q.offer(nextPixel);
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        System.out.println("lc-0733-flood-fill");
    }
}
