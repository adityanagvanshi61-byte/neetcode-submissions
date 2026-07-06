
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num == '.') continue;
                if (!set.add("R" + i + num))
                    return false;
                if (!set.add("C" + j + num))
                    return false;
                if (!set.add("B" + (i / 3) + (j / 3) + num))
                    return false;
            }
        }

        return true;
    }
}