class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                String rowKey = value + " in row " + row;
                String colKey = value + " in col " + col;
                String boxKey = value + " in box " + (row / 3) + "-" + (col / 3);

                if (set.contains(rowKey) ||
                    set.contains(colKey) ||
                    set.contains(boxKey)) {

                    return false;
                }

                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }

        return true;
    }
}