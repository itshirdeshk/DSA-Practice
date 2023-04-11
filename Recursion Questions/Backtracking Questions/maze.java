public class maze {
    public static void main(String[] args) {
        // System.out.println(count(3, 3));
        // path("", 3, 3);

        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
        };

        pathWithRestrictions("", maze, 0, 0);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1 && c > 1) {
            path(p + 'D', r - 1, c - 1);
        }

        if (r > 1) {
            path(p + 'V', r - 1, c);
        }

        if (c > 1) {
            path(p + 'H', r, c - 1);
        }
    }
    
    static void pathWithRestrictions(String p, boolean[][] maze, int r, int c) {
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

        if (r < maze.length - 1) {
            pathWithRestrictions(p + 'V', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            pathWithRestrictions(p + 'H', maze, r, c + 1);
        }
    }
}