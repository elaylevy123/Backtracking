public class test_Racursion {
    public static int maxSumKnight(int[][] mat) {
        return maxSumKnight(mat, 0, 0, -1);
    }

    private static int maxSumKnight(int[][] mat, int i, int j, int prev) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || Math.abs(mat[i][j] - prev) > 1) {// Bad conditions
            return Integer.MIN_VALUE;
        }
        if (i == mat.length - 1 && j == mat[0].length - 1) {//Good conditions - reached the end of the route
            return mat[i][j];
        }
        int temp = mat[i][j];
        mat[i][j] = -1;
        int r1 = maxSumKnight(mat, i - 2, j + 1, temp);
        int r2 = maxSumKnight(mat, i - 1, j + 2, temp);
        int r3 = maxSumKnight(mat, i + 1, j + 2, temp);
        int r4 = maxSumKnight(mat, i + 2, j + 1, temp);
        int r5 = maxSumKnight(mat, i + 2, j - 1, temp);
        int r6 = maxSumKnight(mat, i + 1, j - 2, temp);
        int r7 = maxSumKnight(mat, i - 1, j - 2, temp);
        int r8 = maxSumKnight(mat, i - 2, j - 1, temp);
        mat[i][j] = temp;

        return Math.max(Math.max(Math.max(r1, r2), Math.max(r3, r4)), Math.max(Math.max(r5, r6), Math.max(r7, r8)));
    }


    public static int prince(int[][] mat, int i, int j) {
        return prince(mat, 0, 0, 0, 0, 0);
    }
    private static int prince(int mat[][], int i, int j, int prev, int count, int val) {

        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1)
            return 0;

        if (prev == val || prev - val == 2 || prev - val == 1 || val - prev == 1)
            return Integer.MIN_VALUE;

        prev = mat[i][j];

        int up = prince(mat, i - 1, j, prev, count + 1, val);
        int down = prince(mat, i + 1, j, prev, count + 1, val);
        int left = prince(mat, i, j - 1, prev, count + 1, val);
        int right = prince(mat, i, j + 1, prev, count + 1, val);

        return Math.min(up, Math.min(down, Math.min(left, right)));
    }

    public static int longestFlatsequence(int[] arr) {
        return longestFlatsequence(arr, 0, 0, 0, 0, 0);
    }

    public static int longestFlatsequence(int[] arr, int i, int max, int min, int currntMax, int length) {
        if (arr.length == 0 || arr.length == 1) {
            return 1;
        }
        if (i == arr.length - 1) {
            return 0;
        }
        if (Math.abs(arr[i] - max) <= 1 && Math.abs(arr[i] - min) <= 1) {
            return 1 + longestFlatsequence(arr, i + 1, Math.max(arr[i], max), Math.min(arr[i], min), currntMax, length + 1);
        } else if (Math.abs(arr[i] - arr[i - 1]) != 1) {
            min = arr[i];
            max = arr[i + 1];
            currntMax = Math.max(currntMax, length);
        }
        return longestFlatsequence(arr, i + 1, max, min, currntMax, 0);

    }

    public static boolean subsetsum(int[] a, int sum) {
        return subsetsum(a, sum, 0);
    }

    private static boolean subsetsum(int[] a, int sum, int i) {
        if (i == a.length) {
            if (sum == 0)
                return true;
            else
                return false;
        }
        return subsetsum(a, sum - a[i], i + 1) || subsetsum(a, sum, i + 1);
    }

    public static int printExpr(int[] a, int n) {
        return printExpr(a, n, 0, 0, "");
    }

    private static int printExpr(int[] a, int n, int sum, int i, String s) {
        if (i == a.length) {
            if (n == sum) {
                s += "+" + n;
                System.out.println(s);
                return 1;
            } else
                return 0;
        }
        int takePlus = printExpr(a, n, sum + a[i], i + 1, s + "+" + a[i]);
        int takeMinus = printExpr(a, n, sum - a[i], i + 1, s + "-" + a[i]);
        int noTake = printExpr(a, n, sum, i + 1, s);

        return takePlus + takeMinus + noTake;
    }

    public static int countSidraOla(int sum) {
        return countSidraOla(sum, 0);
    }

    private static int countSidraOla(int sum, int i) {
        if (sum == 0) {
            return 1;
        }
        if (i > sum) {
            return 0;
        }
        return countSidraOla(sum - 1, i + 1) + countSidraOla(sum, i + 1);
    }

    public static boolean samePattern(String s1, String s2) {
        if (s1.length() == 0) {
            if (s2.length() == 0 || s2.equals("*"))
                return true;
            else
                return false;
        } else if (s2.length() == 0)
            return false;
        if (s1.charAt(0) == s2.charAt(0))
            return samePattern(s1.substring(1), s2.substring(1));
        if ('*' == s2.charAt(0))
            return samePattern(s1.substring(1), s2) || samePattern(s1, s2.substring(1));
        else
            return false;
    }

    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0);
    }

    public static boolean isSum(int[] a, int num, int i) {
        if (i == a.length || num == 0) {
            return true;
        }
        if (i >= a.length) {
            return false;
        }
        return isSum(a, num - a[i], i + 1) || isSum(a, num, i + 1);
    }

    public static boolean cover(int[] values, int amount) {
        return cover(values, 0, amount, " ");
    }

    private static boolean cover(int[] values, int i, int amount, String s) {
        if (i == values.length)
            return false;
        if (values[i] == amount)
            System.out.println(s + " " + values[i]);
        return true;

//        boolean take = cover(values, i+1, amount -values[i],s+" "+values[i]);
//        boolean notake = cover(values,i+1, amount,s);
//        return take || notake;
    }

    public static boolean split(int[] a, int diff) {
        return split(a, 0, diff, 0, 0, "", "");
    }

    private static boolean split(int[] a, int i, int diff, int sum1, int sum2, String s1, String s2) {
        if (i == a.length)
            if (diff == sum1 - sum2) {
                System.out.println(s1 + " \t " + s2);
                return true;
            } else {
                return false;
            }
        return split(a, i + 1, diff, sum1 + a[i], sum2, s1 + "" + a[i], s2) ||
                split(a, i + 1, diff, sum1, sum2 + a[i], s1, s2 + "" + a[i]);
    }

    public static boolean split2(int[] arr) {
        return split2(arr, 0, 0, 0, 0);
    }

    private static boolean split2(int[] arr, int i, int sum1, int sum2, int sum3) {
        if (i == arr.length) {
            if (sum1 == sum2 && sum2 == sum3 && sum3 == sum1) {
                return true;
            }
        } else {
            return false;
        }
        boolean one = split2(arr, i + 1, sum1 + arr[i], sum2, sum3);
        boolean two = split2(arr, i + 1, sum1, sum2 + arr[i], sum3);
        boolean free = split2(arr, i + 1, sum1, sum2, sum3 + arr[i]);
        return one || two || free;
    }

    public static boolean isIdantity(int[][] mat, int x, int size) {
        return isIdantity(mat, x, size, x, x);
    }

    private static boolean isIdantity(int[][] mat, int x, int size, int i, int j) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1) {
            return false;
        }
        if (j == size + x) {
            i += 1;
            j = x;
            if (i == size + x) {
                return true;
            }
            if ((mat[i][j] != 1 && j == i) || mat[i][j] != 0 && i != j)
                return false;
        }
        return isIdantity(mat, x, size, i, j + 1);
    }

    public static int longestPath(int[][] mat, int x, int y) {
        return longestPath(mat, x, y, 0, 0);
    }

    private static int longestPath(int[][] mat, int x, int y, int i, int j) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || mat[i][j] == 0) {
            return Integer.MIN_VALUE;
        }
        if (i == x && j == y) {
            return 0;
        }
        mat[i][j] = 0;
        int up = 1 + longestPath(mat, x, y, i - 1, j);
        int down = 1 + longestPath(mat, x, y, i + 1, j);
        int right = 1 + longestPath(mat, x, y, i, j + 1);
        int left = 1 + longestPath(mat, x, y, i, j - 1);
        mat[i][j] = 1;

        return Math.max(Math.max(up, right), Math.max(down, left));
    }

    public static int minPoints(int[][] m) {
        return minPoints(m, 0, 0, 0);
    }

    private static int minPoints(int[][] m, int i, int j, int number) {
        if (i < 0 || i > m.length - 1 || j < 0 || j > m[0].length - 1 || number < 0) {
            return -1;
        }
        if (i == m.length - 1 && j == m[0].length - 1) {
            if (number > 0)
                System.out.println("the number is:" + number);
        }
        int num1 = minPoints(m, i + 1, j, number + m[i][j]);
        int num2 = minPoints(m, i, j + 1, number + m[i][j]);
        return num1 + num2;
    }

    public static int cheapestRoute(int[] sations) {
        return cheapestRoute(sations, 0);
    }

    private static int cheapestRoute(int[] sations, int i) {
        if (i > sations.length - 1) {
            return 0;
        }
        int take1 = cheapestRoute(sations, i + 1);
        int take2 = cheapestRoute(sations, i + 2);

        return Math.min(take1, take2);
    }

    public static boolean graphColoring(boolean[][] graph, int i, int j, int[] color, int v) {
        if (graph[i][j] && color[j] == color[i]) {
            return false;
        }
        if (i == v) { //v is the Number of vertices in the graph
            return true;
        }
        graph[i][j] = true;
        boolean op = graphColoring(graph, i + 1, j, color, v);
        graph[i][j] = false;

        return op;
    }

    public static boolean graphColoring(int[] color) {
        return graphColoring(new boolean[color.length][], 0, 0, color, 0);
    }

    //    public static boolean solveSudoku(int[][] grid, int row, int col, int num, int x) {
//        if (x <= 8) { //check if we find the same num in the similar rom or col - return false
//            if (grid[row][x] == num || grid[x][col] == num) {
//                return false;
//            }
//        }
//        int startRow = row - row % 3, startCol = col - col % 3;
//        if (grid[row + startRow][col + startCol] == num)
//            return false; //check if we find the same num in the particular 3*3
//        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1)
//            return false;
//        int N = 9;
//        if (row == N - 1 && col == N)
//            return true;//if we have reached the 8th row and 9th column (0indexed matrix) ,we are returning true to avoid further backtracking
//        if (col == N)
//            row++;
//        col = 0;
//    }
    public static int longestWorm(int[][] mat) {
        return longestWorm(mat, 0, 0, 0);
    }

    private static int longestWorm(int[][] mat, int i, int j, int prav) {
        if (!isValid(mat, i, j) || mat[i][j] - prav != 1) {
            return Integer.MIN_VALUE;
        }
        if (i == mat.length && j == mat[0].length) {
            return 1;
        }
        int temp = mat[i][j];
        mat[i][j] = -1;

        int op1 = longestWorm(mat, i + 1, j, prav);
        int op2 = longestWorm(mat, i - 1, j, prav);
        int op3 = longestWorm(mat, i, j - 1, prav);
        int op4 = longestWorm(mat, i, j + 1, prav);

        mat[i][j] = temp;
        return Math.max(op1, Math.max(op2, Math.max(op3, op4)));
    }

    private static boolean isValid(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1) {
            return false;
        }
        return true;
    }

    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x, size, 0, 0);
    }

    private static boolean isIdentity(int[][] mat, int x, int size, int i, int j) {
        if (i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1) {
            return false;
        }
        if (mat[i][j] != 1 && i == j || mat[i][j] != 0 && i != j) {
            return false;
        }
        if (j == size + x) {
            i += 1;
            j = x;
            if (i == size + x)
                return true;
        }
        return isIdentity(mat, x, size, i, j + 1);
    }

    public static boolean isJump(String str1, String str2, int step) {
        return isJump(str1, str2, step, 0, 0);
    }

    private static boolean isJump(String str1, String str2, int step, int i, int j) {
        if (j > str2.length() || i > str1.length()) {
            return false;
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            if (str1.charAt(i) - str2.charAt(j) == step)
                return true;
        }
        return isJump(str1, str2, step, i + step, j + 1);
    }

    public static int strStep(String str1, String str2) {
        return strStep(str1, str2, 1);
    }

    private static int strStep(String str1, String str2, int i) {
        if (i >= str1.length())
            return -1;
        if (isJump(str1, str2, i)) {
            return i;
        }
        return strStep(str1, str2, i + 1);
    }

    public static int ways(int k, int n) {
        return ways(k, n, 0);
    }

    private static int ways(int k, int n, int i) {
        if (k == 0 && i != n) {
            return 0;
        }
        if (k == 0 && i == n) {
            return 1;
        }
        int step1 = ways(k - 1, n, i + 1);
        int step2 = ways(k - 1, n, i - 1);
        return step1 + step2;
    }

    public static boolean split3(int[] a) {
        return split3(a, 0, 0, 0, 0);
    }

    private static boolean split3(int[] a, int i, int sum1, int sum2, int sum3) {
        if (i > a.length - 1) {
            return false;
        }
        if (sum1 == sum2 && sum2 == sum3 && sum1 == sum3) {
            return true;
        }
        boolean op1 = split3(a, i + 1, sum1 + a[i], sum2, sum3);
        boolean op2 = split3(a, i + 1, sum1, sum2 + a[i], sum3);
        boolean op3 = split3(a, i + 1, sum1, sum2, sum3 + a[i]);
        return op1 || op2 || op3;
    }

    public static int shortestPath(int[][] mat) {
        return shortestPath(mat, 0, 0, 0);
    }

    private static int shortestPath(int[][] mat, int i, int j, int prev) {
        if (!isValid(mat, i, j) && mat[i][j] < prev) {
            return Integer.MAX_VALUE;
        }
        if (i == mat.length && j == mat.length) {
            return 1;
        }
        int temp = mat[i][j];
        mat[i][j] = -1;

        int op1 = shortestPath(mat, i + 1, j, prev);
        int op2 = shortestPath(mat, i - 1, j, prev);
        int op3 = shortestPath(mat, i, j + 1, prev);
        int op4 = shortestPath(mat, i, j - 1, prev);

        mat[i][j] = temp;
        return Math.min(op1, Math.min(op2, Math.min(op3, op4)));
    }

    public static boolean isSubstring(String s1, String s2) {
        return isSubstring(s1, s2, 0);
    }

    private static boolean isSubstring(String s1, String s2, int i) {
        if (i > s1.length() || s1.length() > s2.length()) {
            return false;
        }
        if (s2.charAt(i) == s1.charAt(i)) {
            return isSubstring(s1, s2.substring(i, s1.length()));
        }
        return isSubstring(s1, s2, i + 1);
    }

    public static int minDiff(int[] arr) {
        return minDiff(arr, 0, 0, 0);
    }

    private static int minDiff(int[] arr, int sum1, int sum2, int i) {
        if (i > arr.length) {
            return 0;
        }
        if (i == arr.length) {
            return Math.abs(sum1-sum2);
        }
        int op1 = minDiff(arr, sum1 + arr[i], sum2, i + 1);
        int op2 = minDiff(arr, sum1, sum2 + arr[i], i + 1);
        return Math.min(op1, op2);
    }

    public static int specialPrint(String s) {
        return specialPrint(s, 0);
    }

    private static int specialPrint(String s, int i) {
        if (i > s.length() - 1) {
            return 0;
        }
        if (s.charAt(i) == 'a') {
            return specialPrint(s.substring(i, s.length()), i + 1);
        }
        return specialPrint(s, i + 1);
    }

    public static boolean splitEqualMult(int[] a) {
        return splitEqualMult(a, 0, 0, 0);
    }

    private static boolean splitEqualMult(int[] a, int sum1, int sum2, int i) {
        if (i >= a.length) {
            return false;
        }
        if (sum1 == sum2) {
            return true;
        }
        boolean op1 = splitEqualMult(a, sum1 * a[i], sum2, i + 1);
        boolean op2 = splitEqualMult(a, sum1, sum2 * a[i], i + 1);
        return op1 || op2;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 2, 3, 4};
        System.out.println(splitEqualMult(a));
    }

    public static int HowManyPahts(int[][] a) {
        return HowManyPahts(a, 0, 0);
    }

    private static int HowManyPahts(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i == a.length || j == a[0].length) {
            return 0;
        }
        if (i == a.length - 1 && j == a[0].length - 1) {
            return 1;
        }
        int k = a[i][j];
        a[i][j] = -1;
        int count = HowManyPahts(a, i + k, j) + HowManyPahts(a, i, j + k) + HowManyPahts(a, i - k, j) + HowManyPahts(a, i, j - k);
        return count;
    }

    public static int countTrue(boolean[][] a) {
        return countTrue(a, 0, 0, 0);
    }

    private static int countTrue(boolean[][] a, int i, int j, int count) {
        if (i < 0 || j < 0 || i == a.length || j == a[0].length || a[i][j] == false) {
            return 0;
        }
        if (i == a.length - 1) {
            return count;
        }
        if (j == a[0].length - 1) {
            return countTrue(a, i + 1, 0, count);
        }
        if (a[i][j] == true)
            count++;
        disable(a, i, j);
        return count;
    }

    private static void disable(boolean[][] a, int i, int j) {
//        if (!isValid(a,i,j)|| a[i][j] == false) {
//            return;
//        }
        a[i][j] = false;
        disable(a, i, j - 1);
        disable(a, i, j + 1);
        disable(a, i + 1, j);
        disable(a, i - 1, j);
    }

    public static void fiiHadamard(int[][] mat) {
        fillHadamard(mat, 0, 0, mat.length, 1);
    }

    private static void fillHadamard(int[][] mat, int i, int j, int size, int sign) {
        if (size == 1)
            mat[i][j] = sign;
        else
            fillHadamard(mat, i, j, size / 2, sign);
        fillHadamard(mat, i + size / 2, j, size / 2, sign);
        fillHadamard(mat, i, j + size / 2, size / 2, sign);
        fillHadamard(mat, i + size / 2, j + size / 2, size / 2, (-1) * sign);
    }

    public static int longestSlop(int[][] mat, int num) {
        return longestSlop(mat, num, 0, 0, 0);
    }

    private static int longestSlop(int[][] mat, int num, int i, int j, int prev) {
        if (i < 0 || j < 0 || i == mat.length || j == mat[0].length || mat[i][j] - prev != num) {
            return 0;
        }
        if (prev - mat[i][j] == num ) {
            return 1;
        }
        int one = longestSlop(mat, num, i + 1, j, mat[i][j] + 1);
        int two = longestSlop(mat, num, i - 1, j, mat[i][j] + 1);
        int free = longestSlop(mat, num, i, j - 1, mat[i][j] + 1);
        int op = longestSlop(mat, num, i, j + 1, mat[i][j] + 1);

        return Math.max(one, Math.max(two, Math.max(free, op)));
    }

    public static int findMaximum(int[][] mat) {
        return findMaximum(mat, 0, 0, 0);
    }

    private static int findMaximum(int[][] mat, int i, int j, int sum) {
        if (i < 0 || j < 0 || i == mat.length || j == mat[0].length || mat[i][j] == -1) {
            return Integer.MIN_VALUE;
        }
        if (i % 2 == 0) {
            int temp = mat[i][j];
            mat[i][j] = -1;
            int right = findMaximum(mat, i + 1, j, sum + temp);
            int down = findMaximum(mat, i, j + 1, sum + temp);
            mat[i][j] = temp;
            return Math.max(right, down);
        } else {
            int temp = mat[i][j];
            mat[i][j] = -1;
            int left = findMaximum(mat, i - 1, j, sum + temp);
            int down = findMaximum(mat, i, j + 1, sum + temp);
            mat[i][j] = temp;
            return Math.max(left, down);
        }
    }

    public static int maxPath(int[][] mat) {
        return maxPath(mat, 0, 0, 0);
    }

    private static int maxPath(int[][] mat, int i, int j, int sum) {
        if (i < 0 || j < 0 || i == mat.length || j < mat[0].length) {
            return Integer.MIN_VALUE;
        }
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return sum + mat[i][j];
        }
        int temp = mat[i][j];
        int a = temp % 10;
        int b = temp / 10;
        int op1 = maxPath(mat, i + a, j + b, sum + temp);
        int op2 = maxPath(mat, i + b, j + a, sum + temp);
        return Math.max(op1, op2);
    }

    public static int midDiff(int[] arr) {
        return midDiff(arr, 0, 0, 0);
    }

    private static int midDiff(int[] arr, int i, int sum1, int sum2) {
        if (i == arr.length) {
            return Math.abs(sum1 - sum2);
        }
        if (sum1 == sum2) {
            return 1;
        }
        int one = midDiff(arr, i + 1, sum1 + arr[i], sum2);
        int two = midDiff(arr, i + 1, sum1, sum2 + arr[i]);
        return Math.min(one, two);
    }

    public static int edit(String s1, String s2) {
        return edit(s1, s2, 0, 0, 0);
    }

    private static int edit(String s1, String s2, int i, int j, int sum) {
        if (i == s1.length() && !(j == s2.length())) {
            return sum + s2.length() - j;
        }
        if (!(i == s1.length()) && j == s2.length()) {
            return sum + s1.length() - i;
        }
        if (s1.charAt(i) == s2.charAt(j))
            return edit(s1, s2, i + 1, j + 1, sum);
        int one = edit(s1, s2, i + 1, j, sum + 1);
        int two = edit(s1, s2, i, j + 1, sum + 1);
        return Math.min(one, two);
    }

    public static int howmanypaths(int[][] mat) {
        return howmanypaths(mat, 0, 0);
    }

    private static int howmanypaths(int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i == mat.length || j == mat[0].length) {
            return 0;
        }
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return 1;
        }
        int k = mat[i][j];
        mat[i][j] = -1;
        int count = HowManyPahts(mat, i + k, j) + HowManyPahts(mat, i, j + k) + HowManyPahts(mat, i - k, j) + HowManyPahts(mat, i, j - k);
        return count;
    }
    public static int where(int []vec){
        return where(vec,0,0,0);
    }
    private static int where(int []vec, int sum1, int sum2, int i){
        if (i > vec.length-1){
            return 0;
        }
        if (sum1 == sum2){
            return vec[i];
        }
        int one = where(vec,sum1+vec[i],sum2,i+1);
        int two = where(vec, sum1, sum2+vec[i], i+1);
        return one+two;
    }
}

