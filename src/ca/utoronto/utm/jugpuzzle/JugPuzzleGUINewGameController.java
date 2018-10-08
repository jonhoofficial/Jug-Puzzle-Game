package ca.utoronto.utm.jugpuzzle;

/**
 * Resets the gui back to the starting state. Change fill texts to original
 * amounts and enable the jug buttons if they have been disabled from 
 * winning the game.
 * 
 * @author csc207student
 */

public class JugPuzzleGUINewGameController extends JugPuzzleGUIController{
 
	public static void resetGUI() {
		// Enable the jug buttons
		JugPuzzleGUIUpdateController.enableJugs();

		// Display the starting amount of the jugs
		JugPuzzleGUIUpdateController.updateFill();

		// Reset the number of moves of the started round
		moveValue.setText(Integer.toString(jugPuzzle.getMoves()));	

		System.out.println("GUI Initated and Resetted");
	}
}
