package ca.utoronto.utm.jugpuzzle;

/**
 * This class contains methods for solely updating general elements of the GUI
 * including its buttons and text boxes.
 * 
 * @author csc207student
 */

public class JugPuzzleGUIUpdateController extends JugPuzzleGUIController {

	/**
	 * Disable Jug Buttons.
	 */
	public static void disableJugs() {
		j0.setEnabled(false); // Disable the jug buttons
		j1.setEnabled(false);
		j2.setEnabled(false);
	}

	/**
	 * Enable Jug Buttons.
	 */
	public static void enableJugs() {
		j0.setEnabled(true); // Enable the jug buttons
		j1.setEnabled(true);
		j2.setEnabled(true);
	}

	/**
	 * Update the jug fill amount text boxes on the GUI.
	 */
	public static void updateFill() {
		String[] jugresult = jugPuzzle.toString().split(":");
		jug0amt = jugresult[1].substring(1, 4);
		jugfill0.setText(jug0amt); // Set jug0 fill level text
		jug1amt = jugresult[2].substring(1, 4);
		jugfill1.setText(jug1amt); // Set jug1 fill level text
		jug2amt = jugresult[3].substring(1, 4);
		jugfill2.setText(jug2amt); // Set jug2 fill level text
	}

	/**
	 * Set the objective text box message located above the game.
	 * 
	 * @param text The text to be updated.
	 */
	public static void updateObjective(String text) {
		objective.setText(text);
	}

	/**
	 * Checks the high score with the finishing score and set the new high score
	 * if the number of moves is better.
	 * 
	 */
	public static void checkAndUpdateHighScore() {
		// Set the high score (if better than previous or if high score is 0)
		if (JugPuzzleGUIMovesController.getMoves() < JugPuzzleGUIMovesController.getBestMoves() || JugPuzzleGUIMovesController.getBestMoves() == 0) {
			JugPuzzleGUIMovesController.updateBestMoves(JugPuzzleGUIMovesController.getMoves());
		}
	}

}
