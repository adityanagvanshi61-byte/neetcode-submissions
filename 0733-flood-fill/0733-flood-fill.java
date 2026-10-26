class Solution {

    // dfs algorithm
    public void dfs(int[][] image, int i, int j, int newcolor, int oldcolor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length ||
                image[i][j] == newcolor || image[i][j] != oldcolor) {
            return;
        }

        image[i][j] = newcolor;

        dfs(image, i - 1, j, newcolor, oldcolor);
        dfs(image, i, j + 1, newcolor, oldcolor);
        dfs(image, i + 1, j, newcolor, oldcolor);
        dfs(image, i, j - 1, newcolor, oldcolor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc]; // Fixed: get original color
        dfs(image, sr, sc, color, oldcolor); // Fixed: pass all 5 arguments
        return image;
    }

}
