/**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

   /**
	* The board of the game, stored as a single array.
	*/
	private CellValue[] board;


   /**
	* level records the number of rounds that have been
	* played so far. Starts at 0.
	*/
	private int level;

   /**
	* gameState records the current state of the game.
	*/
	private GameState gameState;


   /**
	* lines is the number of lines in the grid
	*/
	private final int lines;

   /**
	* columns is the number of columns in the grid
	*/
	private final int columns;


   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game. 
	* For simplicity, it will be always 3 in this assignment.
	*/
	private final int sizeWin; 


   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	public TicTacToeGame(){
		// your code here
		lines = 3;
		columns = 3;
		sizeWin = 3;
		board = new CellValue[lines*columns];
		resetBoard(board);
		gameState = GameState.PLAYING;
	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
	public TicTacToeGame(int lines, int columns){
		// your code here
		this.lines = lines;
		this.columns = columns;
		sizeWin = 3;
		board = new CellValue[lines*columns];
		resetBoard(board);
		gameState = GameState.PLAYING;
	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
	public TicTacToeGame(int lines, int columns, int sizeWin){
		// your code here
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;
		board = new CellValue[lines*columns];
		resetBoard(board);
		gameState = GameState.PLAYING;
	}



   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	public int getLines(){
		return(lines);
	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	public int getColumns(){
		return(columns);
	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){
		return(level);
	}


   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){
		return(gameState);
	}

   /**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){
		return (sizeWin);
	}


   /**
	* returns the cellValue that is expected next,
	* in other word, which played (X or O) should
	* play next.
	* This method does not modify the state of the
	* game.
	* @return
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){
		// your code here
		if (getLevel() % 2 == 0) {
			return CellValue.X;
		} else {
			return CellValue.O;
		}

	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return
    *  the value at index i in the variable board.
  	*/
	public CellValue valueAt(int i) {
		// your code here
		if (i < 0 || i > board.length -1) {
			System.out.println("The value should be between 1 and " + board.length);
			return null;
		} else if (board[i] != CellValue.EMPTY) {
			System.out.println("This cell has already been played");
			return null;
		} else {
			return board[i];
		}
	}

   /**
	* This method is called by the next player to play
	* at the cell  at index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, it is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded.
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been
    * selected by the next player
  	*/
	public void play(int i) {

		// your code here
		i--;
		if (i < 0 || i > board.length -1) {
			System.out.println("The value should be between 1 and " + board.length);
		} else if (valueAt(i) != CellValue.EMPTY) {
			System.out.println("This cell has already been played");
		} else {
			if (getLevel() % 2 == 0) {
				board[i] = CellValue.X;
			} else {
				board[i] = CellValue.O;
			}
		}
		level++;
	}


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set.
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (the the game was playing). Therefore, it only needs to
	* check if playing at index i has concluded the game
	* So check if 3 cells are formed to win.
//   	* @param i
    *  the index of the cell in the array board that has just
    * been set
  	*/

	private void setGameState(int index){

		// your code here
		

	}

	/**
	* A helper method which sets the board to all EMPTY
	* @param board
	* : Array holding the value of each position in a board
  	*/

	private static void resetBoard(CellValue[] board) {
		for (int i=0;i<board.length;i++){
			board[i] = CellValue.EMPTY;
		}
	}



	final String NEW_LINE = System.getProperty("line.separator");
	// returns the OS dependent line separator

   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	*
   	* @return
    *  String representation of the game
  	*/

	public String toString(){
		// your code here
		// use NEW_LINE defined above rather than \n
		String element;
		String visualBoard = "";

		for (int x=0;x<board.length;x++) {
			switch (board[x]) {
				case X:
					element = " X ";
					break;
				case O:
					element = " O ";
					break;
				default:
					element = "   ";
					break;
			}
			visualBoard += element;
			if ((x+1) % lines != 0) {
				visualBoard += "|";
			} else if ((x+1) % getLines() == 0 && (x+1) != board.length) {
				visualBoard += NEW_LINE + "-----------" + NEW_LINE;
			}
		}
		return visualBoard;
	}

}
