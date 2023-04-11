import java.util.Arrays;

public class allPath {
    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        // allPaths("", maze, 0, 0);

        int[][] path = new int[maze.length][maze[0].length];
        allPathsPrint("", maze, 0, 0, path, 1);
    }

    static void allPaths(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        // if (r > 1 && c > 1) {
        //     path(p + 'D', r - 1, c - 1);
        // }

        if (maze[r][c] == false) {
            return;
        }

        // I am consi this block in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPaths(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPaths(p + 'R', maze, r, c + 1);
        }

        if (r > 0) {
            allPaths(p + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            allPaths(p + 'L', maze, r, c - 1);
        }

        // This line where the function will be over 
        // so before the function gets removed, also removes the changes that were made by the function.
        maze[r][c] = true;

    }

    static void allPathsPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println("\n");
            return;
        }

        // if (r > 1 && c > 1) {
        //     path(p + 'D', r - 1, c - 1);
        // }

        if (maze[r][c] == false) {
            return;
        }

        // I am consi this block in my path
        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathsPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPathsPrint(p + 'R', maze, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            allPathsPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            allPathsPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }

        // This line where the function will be over 
        // so before the function gets removed, also removes the changes that were made by the function.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
