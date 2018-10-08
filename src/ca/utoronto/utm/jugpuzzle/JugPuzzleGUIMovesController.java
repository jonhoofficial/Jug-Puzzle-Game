package ca.utoronto.utm.jugpuzzle;

/**
 * This class contains methods for setting/updating, changing and getting data
 * on JugPuzzle player moves and rounds only.
 * 
 * @author csc207student
 */

public class JugPuzzleGUIMovesController extends JugPuzzleGUIController {
	/**
	 * Get the number of rounds.
	 * 
	 * @return The number of rounds so far in the game
	 */
	public static int getRounds() {
		return JugPuzzleGUIController.rounds;
	}

	/**
	 * Updates the move count in the moves text box.
	 */
	public static void updateMoves() {
		moveValue.setText(Integer.toString(jugPuzzle.getMoves()));
	}

	/**
	 * Updates the best move count in the moves text box.
	 * 
	 * @param move The number of moves made in the round.
	 */
	public static void updateBestMoves(int move) {
		bestMoveValue.setText(Integer.toString(move));
	}

	/**
	 * Get the number of moves made in the game.
	 * 
	 * @return int The number of rounds so far in the game
	 */
	public static int getMoves() {
		return jugPuzzle.getMoves();
	}

	/**
	 * Get the best moves (high score) made in the game.
	 * 
	 * @return String The number of rounds so far in the game
	 */
	public static int getBestMoves() {
		return Integer.parseInt(bestMoveValue.getText());
	}
}
