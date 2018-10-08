package ca.utoronto.utm.jugpuzzle;

/**
 * This class contains methods for setting/updating, changing and getting data
 * on the player's JugPuzzle game. This includes setting jug selections, making moves,
 * finishing the game etc.
 * 
 * @author csc207student
 */
public class JugPuzzleGUIGameController extends JugPuzzleGUIController {

	/**
	 * Make a move in the game after the moves have been selected using the gui interface
	 * 
	 * @param f an integer identifying the from jug
	 * @param t an integer identifying the to jug
	 */
	public static void play(int f, int t) {
		jugPuzzle.move(f, t);
	}

	/**
	 * Return an integer value of either 0 or 1 to determine if the game is finished.
	 * 
	 * @return int 0 indicating game is not finished; 1 indicating game is finished.
	 */
	public static int isFinished() {
		return finish;
	}

	/**
	 * Let's the program know the game is finished.
	 */
	public static void setFinished() {
		finish = 1;
	}
	/**
	 * Let's the program know the game is not finished and/or a new game has started.
	 */
	public static void resetFinished() {
		finish = 0;
	}

	/**
	 * Return either From or To that determines which jug the player is selecting.
	 * 
	 * @return String 'from' for the from jug; 'to' for the to jug
	 */
	public static String getTurn() {
		return turn;
	}

	/**
	 * Set the selecting jug to 'FROM'.
	 */
	public static void turnFrom() {
		turn = "from";
	}

	/**
	 * Set the selecting jug to 'TO'.
	 */
	public static void turnTo() {
		turn = "to";
	}

	/**
	 * Increase move counter by 1
	 */
	public static void increaseRounds() {
		// Increase rounds counter by 1
		rounds = rounds + 1;
		roundPlayed.setText(Integer.toString(rounds)); 
	}

	/**
	 * Return true or false on whether or not the puzzle has been solved
	 * 
	 * @return boolean True for puzzle is solved; false for not
	 */
	public static boolean puzzleSolved() {
		return jugPuzzle.getIsPuzzleSolved();
	}

	/**
	 * Set the 'from' jug position
	 * 
	 * @param jugNum The 'from' jug number
	 */
	public static void setFrom(int jugNum) {
		from = jugNum;
	}

	/**
	 * Set the 'to' jug position
	 * 
	 * @param jugNum The 'to' jug number
	 */
	public static void setTo(int jugNum) {
		to = jugNum;
	}

	/**
	 * Get the 'from' jug position
	 * 
	 * @return jugNum The 'from' jug number
	 */
	public static int getFrom() {
		return from;
	}

	/**
	 * Get the 'to' jug position
	 * 
	 * @return jugNum The 'to' jug number
	 */
	public static int getTo() {
		return to;
	}
}
