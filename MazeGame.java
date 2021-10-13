package solution;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * A maze game.
 * 
 * @author Patrick Turner
 * @version 1/23/2020
 *
 */
public class MazeGame {
    // The size of each side of the game map.
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    // The game map, as a 2D array of ints.
    private boolean[][] blocked;
    
    // The array that places breadCrumbs after player movement.
    private boolean[][] breadCrumbs;
    
    // The current location of the player vertically.
    private int userRow;
    
    // The current location of the player horizontally.
    private int userCol;
    
    // The scanner from which each move is read.
    private Scanner moveScanner = new Scanner(System.in);
    
    // The column of the goal.
    private int goalCol;
    
    // The row of the goal.
    private int goalRow;
    
    // The column of the start.
    private int startCol;
    
    // The row of the start.
    private int startRow;
    
    // The flag to see if the game has been quit.
    private boolean quitFlag;
    
    // Constructor methods
    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     */
    public MazeGame(String mazeFile) {
        moveScanner = new Scanner(System.in);
        loadMaze(mazeFile);
        userCol = 0;
        userRow = 0;
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner) {
    	this.moveScanner = moveScanner;
        loadMaze(mazeFile);
    	userCol = 0;
    	userRow = 0;
    }

    // Accessor Methods
    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze() {
        if (blocked == null)
            return null;

        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        
	for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * getBlocked returns the blocked field.
     * 
     * @return blocked
     */
    public boolean[][] getBlocked() {
        return blocked;
    }

    /**
     * getBreadCrumbs returns the breadCrumbs field.
     * 
     * @return breadCrumbs
     */
    public boolean[][] getBreadCrumbs() {
        return breadCrumbs;
    }

    /**
     * getUserRow returns the current row the user is on.
     * 
     * @return userRow
     */
    public int getUserRow() {
        return userRow;
    }

    /**
     * getUserCol returns the current column the user is on.
     * 
     * @return userCol
     */
    public int getUserCol() {
        return userCol;
    }

    /**
     * getMoveScanner returns the Scanner object that moves the user.
     * 
     * @return moveScanner
     */
    public Scanner getMoveScanner() {
        return moveScanner;
    }

    /**
     * getGoalCol returns the goalCol field.
     * 
     * @return goalCol
     */
    public int getGoalCol() {
        return goalCol;
    }

    /**
     * getGoalRow returns the goalRow field.
     * 
     * @return goalRow
     */
    public int getGoalRow() {
        return goalRow;
    }

    /**
     * getStartCol returns the startCol field.
     * 
     * @return startCol
     */
    public int getStartCol() {
        return startCol;
    }

    /**
     * getStartRow returns the startRow field.
     * 
     * @return startRow
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * getQuitFlag returns the quitFlag field.
     * 
     * @return quitFlag
     */
    public boolean getQuitFlag() {
        return quitFlag;
    }
    
    // Mutator methods
    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze) {
        this.blocked = maze;
    }

    /**
     * setBlocked sets the blocked field.
     * 
     * @param blocked boolean[][]
     */
    public void setBlocked(boolean[][] blocked) {
        this.blocked = blocked;
    }

    /**
     * setBreadCrumbs sets the breadCrumbs field.
     * 
     * @param breadCrumbs boolean[][]
     */
    public void setBreadCrumbs(boolean[][] breadCrumbs) {
        this.breadCrumbs = breadCrumbs;
    }

    /**
     * setUserRow sets the userRow field.
     * 
     * @param userRow int
     */
    public void setUserRow(int userRow) {
        this.userRow = userRow;
    }

    /**
     * setUserCol sets the userCol field.
     * 
     * @param userCol int
     */
    public void setUserCol(int userCol) {
        this.userCol = userCol;
    }

    /**
     * setMoveScanner sets the moveScanner field.
     * 
     * @param moveScanner Scanner
     */
    public void setMoveScanner(Scanner moveScanner) {
        this.moveScanner = moveScanner;
    }

    /**
     * setQuitFlag sets the quitFlag field.
     * 
     * @param quitFlag boolean
     */
    public void setQuitFlag(boolean quitFlag) {
        this.quitFlag = quitFlag;
    }
    
    // Class methods
    /**
     * Function loads the data from the maze file and creates the 'blocked' 
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */ 
    private void loadMaze(String mazeFile) {
        breadCrumbs = new boolean[HEIGHT][WIDTH];
        blocked = new boolean[HEIGHT][WIDTH];
        Scanner fileIn = null;

        try {
            fileIn = new Scanner(new FileReader(mazeFile));
            while (fileIn.hasNext()) {
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        breadCrumbs[i][j] = false;
                        String check = fileIn.next();

                        if (check.equals("1"))
                            blocked[i][j] = true;
                        else if (check.equals("0"))
                            blocked[i][j] = false;
                        else if (check.equals("S")) {
                            blocked[i][j] = false;
                            startRow = j;
                            startCol = i;
                        }
                        else if (check.equals("G")) {
                            blocked[i][j] = false;
                            goalRow = j;
                            goalCol = i;
                        }
                    }
                }
            }
            fileIn.close();
        }
        catch (FileNotFoundException ioe) {
            System.out.println("Could not open the input file.");
            System.exit(0);
        }
    }

    /**
     * Actually plays the game.
     */
    public void playGame() {
        String input = "";
        int moveCount = 0;

        while (playerAtGoal() != true) {
            input = moveScanner.nextLine();
            if (input.length() != 0) {
                makeMove(input);
                if (quitFlag == true) {
                    System.out.println("You have quit the game.");
                    break;
                }
                moveCount++;
                printMaze();
            }
        }
        System.out.println("Congrats, you won the game!");
        System.out.println("Total number of moves used: " + moveCount);
    }

    /**
     * Checks to see if the player has won the game.
     * @return true if the player has won.
     */
    public boolean playerAtGoal() {
        if ((getUserRow() == goalCol) && (getUserCol() == goalRow))
            return true;
        else
            return false;
    }

    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move) {
        move.toLowerCase();
        char moveChar = move.charAt(0);

        if (moveChar == 'u') {
            if (blocked[userRow - 1][userCol] == false) {
                breadCrumbs[userRow][userCol] = true;
                setUserRow(userRow - 1);
                return true;
            }
            else 
                return false;
        }
        else if (moveChar == 'd') {
            if ((userRow + 1) >= 0 && (userRow + 1) < HEIGHT &&
                blocked[userRow + 1][userCol] == false) {
                breadCrumbs[userRow][userCol] = true;
                setUserRow(userRow + 1);
                return true;
            }
            else
                return false;
        }
        else if (moveChar == 'l') {
            if ((userCol - 1) >= 0 && 
                blocked[userRow][userCol - 1] == false) {
                breadCrumbs[userRow][userCol] = true;
                setUserCol(userCol - 1);
                return true;
            }
            else
                return false;
        }
        else if (moveChar == 'r') {
            if ((userCol + 1) >= 0 && (userCol + 1) < WIDTH &&
                blocked[userRow][userCol + 1] == false) {
                breadCrumbs[userRow][userCol] = true;
                setUserCol(userCol + 1);
                return true;
            }
            else
                return false;
        }  
        else if (moveChar == 'q') {
            quitFlag = true;
            return true;
        }
        return false;
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze() {
        System.out.println("*-------------------"
                         + "--------------------*");

        for (int i = 0; i < blocked.length; i++) {
            System.out.print("|");
            for (int j = 0; j < blocked[i].length; j++) {
                if (j == getUserCol() && i == getUserRow())
                    System.out.print("@");
                else if (j == startRow && i == startCol)
                    System.out.print("S");
                else if (j == goalRow && i == goalCol)
                    System.out.print("G");
                else if (blocked[i][j] == true)
                    System.out.print("X");
                else if (breadCrumbs[i][j] == true && blocked[i][j] == false)
                    System.out.print(".");
                else if (blocked[i][j] == false)
                    System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("*-------------------"
                         + "--------------------*");
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        System.out.println("Please input the name of the text file you want to use: ");
        Scanner scan = new Scanner(System.in);
        String mapFile = scan.nextLine();
        MazeGame game = new MazeGame(mapFile, scan);
        System.out.println("Enter any character to continue...");
        game.playGame();
    }
}
