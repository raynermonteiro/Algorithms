package hackerrank.DynamicProgramming;

public class PathsInMaze {
    static int countPaths(int [][] maze) {
        int row=maze.length,col = maze.length;

        if(maze[0][0] == -1 || maze[row-1][col-1] == -1) {
            return 0;
        }

        //Initialize first row to 1 if path exists
        for(int r=0;r<row;r++){
            if(maze[r][0] == 0)
                maze[r][0] = 1;
            else
                break;
        }


        //Initialize first column to 1 if path exists
        for(int c=1;c<col;c++) {
            if(maze[0][c] == 0)
                maze[0][c] = 1;
            else
                break;
        }
        printMaze(maze);

        System.out.println("After finding path");
        for(int r=0;r<row;r++) {
            for (int c = 0; c < col; c++) {
                if(r!=0 && c!=0) {
                    if (maze[r][c] == -1) {
                        System.out.print(" "+maze[r][c]);
                        continue;
                    }
                    if (maze[r - 1][c] > 0) {
                        maze[r][c] = maze[r][c] + maze[r - 1][c];
                    }
                    if (maze[r][c - 1] > 0) {
                        maze[r][c] = maze[r][c] + maze[r][c - 1];
                    }
                }
                System.out.print(" "+maze[r][c]);
            }
            System.out.println();
        }
        return 0;
    }

    static void printMaze(int[][] maze) {
        int row = maze.length;
        int col = maze.length;
        for(int r=0;r<row;r++){
            for (int c = 0; c < col; c++)
                System.out.print(" "+maze[r][c]);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int [][] maze= {{0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
        countPaths(maze);
    }
}
