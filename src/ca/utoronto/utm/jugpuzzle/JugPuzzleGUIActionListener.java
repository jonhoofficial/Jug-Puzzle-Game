package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * ActionListener for the gui buttons
 * 
 * @author csc207student
 */
public class JugPuzzleGUIActionListener implements ActionListener {
	
	private static String objectiveText;

	/**
	 * Constructor for the action listener of the button in JugPuzzleGUIController
	 * 
	 * @param name of the button to implement action listener
	 */
	JugPuzzleGUIActionListener(String name) {
		// Display on console that ActionListener has been successfully created for the button
		System.out.println("JugPuzzleGUIActionListener Constructor created for: " + name);
	}

	/**
	 * Code to run when button pressed action is detected
	 * 
	 * @param e the value of the button pressed
	 */
	public void actionPerformed(ActionEvent e) {

		// If the button pressed are one of the three jugs (0, 1, 2)
		if (e.getActionCommand() == "0" || e.getActionCommand() == "1" || e.getActionCommand() == "2" ) {

			// If the program detects the player is selecting the 'from' jug
			if (JugPuzzleGUIGameController.getTurn() == "from") {
				// Set the from position and change jug selection to 'to' jug
				System.out.println(" (from) button pressed: Selected Jug " + e.getActionCommand());
				JugPuzzleGUIGameController.setFrom(Integer.parseInt(e.getActionCommand()));
				objectiveText = "You have selected Jug " + JugPuzzleGUIGameController.getFrom() + ". Please select a jug to pour to.";
				JugPuzzleGUIUpdateController.updateObjective(objectiveText);
				
				// Change jug selection to 'to' jug
				JugPuzzleGUIGameController.turnTo();
			}

			// If the program detects the player is selecting the 'to' jug
			else {
				// Set the to position of the 'to' jug
				System.out.println(" (to) button pressed: Selected Jug " + e.getActionCommand());
				JugPuzzleGUIGameController.setTo(Integer.parseInt(e.getActionCommand()));
				System.out.println("Initating move from Jug " + JugPuzzleGUIGameController.getFrom() + " to Jug " + JugPuzzleGUIGameController.getTo());

				// Make the play using the from and to values
				JugPuzzleGUIGameController.play(JugPuzzleGUIGameController.getFrom(), JugPuzzleGUIGameController.getTo()); // Initiate the play with the from and to move jug numbers

				// Update the GUI texts to the game's most updated details
				objectiveText = " Move has been made from Jug " + JugPuzzleGUIGameController.getFrom() + " to " + JugPuzzleGUIGameController.getTo() + ". Please select a jug to pour from.";
				JugPuzzleGUIUpdateController.updateObjective(objectiveText);
				JugPuzzleGUIUpdateController.updateFill();
				JugPuzzleGUIMovesController.updateMoves();

				// Reset the turns back to select the from jug
				JugPuzzleGUIGameController.turnFrom();

				// Run if the puzzle has been solved (Jug 0 and Jug 1 contains a fill of 4)
				if (JugPuzzleGUIGameController.puzzleSolved()) { 
					JugPuzzleGUIGameController.setFinished();
					JugPuzzleGUIUpdateController.disableJugs();
					objectiveText = "Congrats! You solved it in " + JugPuzzleGUIMovesController.getMoves() + " moves!! Please select an option below to quit or play again.";
					JugPuzzleGUIUpdateController.updateObjective(objectiveText);
					JugPuzzleGUIUpdateController.checkAndUpdateHighScore();
					System.out.println("Game Completed. Awaiting player's decision...");
				}
			}
		}

		// If the button pressed is the 'Restart Game' button
		else if (e.getActionCommand() == "Restart Game") {
			System.out.println(" (restart) button pressed");
			// Run if the game is not finished
			if (JugPuzzleGUIGameController.isFinished() == 0) {
				// Show dialogue box asking for confirmation to restart game
				System.out.println("Restart Confirmation Dialogue Initiated");
				int restartConfirm = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to restart the game?", "Restart JugPuzzle",
						JOptionPane.YES_NO_OPTION);
				if (restartConfirm == JOptionPane.YES_OPTION) {
					System.out.println(" (yes) restart confirmation observed");
					System.out.println("JugPuzzle game has restarted");
					JugPuzzleGUINewGameController.newGame(); // Initiate a new game
					JugPuzzleGUIGameController.increaseRounds();
				}
				else {
					System.out.println(" (no) restart confirmation observed");
				}
			}
			// Run if the game is finished
			else {
				// Start new game without dialogue
				System.out.println("JugPuzzle game has restarted");
				JugPuzzleGUINewGameController.newGame(); // Initiate a new game
				JugPuzzleGUIGameController.increaseRounds();
			}
		} 

		// If the button pressed is the 'Quit Game' button
		else if (e.getActionCommand() == "Quit Game") {
			System.out.println(" (quit) button pressed");
			// Open dialogue box asking for confirmation to quit game
			System.out.println("Quit Game Confirmation Dialogue Initiated");
			int exitConfirmation = JOptionPane.showConfirmDialog(null, 
					"Are you sure you want to quit the game?" + System.lineSeparator() + "Your stats and game will be lost upon quitting.", "Quit JugPuzzle",
					JOptionPane.YES_NO_OPTION);

			// If the selection is yes
			if (exitConfirmation == JOptionPane.YES_OPTION) {
				System.out.println(" (yes) quit game confirmation observed");
				System.exit(0); // Quit the game
			}
			else {
				System.out.println(" (no) quit game confirmation observed");
			}
		}
	}
}
