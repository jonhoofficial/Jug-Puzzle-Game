package ca.utoronto.utm.jugpuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * This class creates the JugPuzzleGUI Interface for the game and initializes/resets
 * the JugPuzzle game for the GUI.
 * 
 * @author csc207student
 */

public class JugPuzzleGUIController {

	public static JugPuzzle jugPuzzle; // The puzzle the user will be playing
	public static JButton j0, j1, j2, newGame, quitGame;  // The JugPuzzle GUI buttons
	private static JLabel jugLabel, fillLabel, titleLabel, goalLabel, moveLabel, bestMoveLabel, roundsPlayedLabel;  // The JugPuzzle GUI labels
	public static JTextField objective, jugfill0, jugfill1, jugfill2, moveValue, bestMoveValue, roundPlayed;  // The JugPuzzle GUI text fields
	public static String turn = "from";  // Used to determine if the jug selection is for the from position or to position
	public static String jugresult, jug0amt, jug1amt, jug2amt;  // Used to store the jug fill amounts
	public static int finish, rounds, from, to; // Used to store game information

	/**
	 * Create and play the GUI version of JugPuzzle
	 * @param args are not used
	 */
	public static void main(String[] args) { 
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
				// Start a new JugPuzzle game
				JugPuzzleGUINewGameController.newGame();
			}
		});
	}

	/**
	 * Start a new game of jug puzzle and reset the gui to the initial state
	 */
	public static void newGame() {
		jugPuzzle = new JugPuzzle();
		JugPuzzleGUINewGameController.resetGUI();
		JugPuzzleGUIGameController.resetFinished();

		// View
		JugPuzzleGUIView jpguiView1 = new JugPuzzleGUIView();

		// Model
		JugPuzzle jug1model = jugPuzzle;

		// Hook the model to the view.
		jug1model.addObserver(jpguiView1);

		objective.setText(" Welcome to the game. Please select a jug to pour from.");
		System.out.println("New JugPuzzle Game Created");
	}

	/**
	 * Creates the graphic user interface for the game using various panels and
	 * GUI elements for the JugPuzzle game.
	 */
	public static void createAndShowGUI() {


		// Create the software frame
		JFrame game = new JFrame("JugPuzzle GUI Game"); // Frame with title
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the overall frame layout to a grid of 1 column
		GridLayout gridLayout = new GridLayout(0,1); 
		game.getContentPane().setLayout(gridLayout);

		// Create individual panels for each section 
		// of the GUI to be added to the frame
		JPanel titleFrame= new JPanel();  // Title Panel
		JPanel gameFrame= new JPanel();  // Game Panel
		JPanel detailsFrame= new JPanel();  // Details Panel

		// Set layouts for each individual panels
		GridLayout titleArea= new GridLayout(0,1);   
		GridLayout gameArea= new GridLayout(0,4); 
		GridLayout detailsArea = new GridLayout(0,4); 
		titleFrame.setLayout (titleArea);
		gameFrame.setLayout (gameArea);
		detailsFrame.setLayout (detailsArea);

		// Create buttons for the program
		j0 = new JButton("0");
		j1 = new JButton("1");
		j2 = new JButton("2");
		newGame = new JButton("Restart Game");
		quitGame = new JButton("Quit Game");

		// Create labels for the program
		titleLabel = new JLabel("JugPuzzle Game", SwingConstants.CENTER );
		titleLabel.setFont(new Font("Sans_Serif", Font.PLAIN, 30)); 
		goalLabel = new JLabel("Objective: Spill liquid between jugs until jugs 0 and 1 contain 4 units of liquid each.", SwingConstants.CENTER );
		jugLabel = new JLabel("   Jugs:");
		fillLabel = new JLabel("   Fill Level:");
		moveLabel = new JLabel("   Moves Made:  ");
		bestMoveLabel = new JLabel("   High Score:  "); 
		roundsPlayedLabel = new JLabel("   Rounds Played:  ");

		// Create text fields for the program
		objective = new JTextField(10); // TextField for the objective output text
		objective.setEditable(false);
		objective.setBackground(new Color(210, 210, 210));
		objective.setText(" Welcome to the game. Please select a jug to pour from.");

		jugfill0 = new JTextField(5); // TextField for the jug 0's fill amount and capacity
		jugfill0.setEditable(false);
		jugfill0.setText("8/8");
		jugfill0.setBackground(new Color(210, 210, 210));
		jugfill0.setHorizontalAlignment(SwingConstants.CENTER);

		jugfill1 = new JTextField(5); // TextField for the jug 1's fill amount and capacity
		jugfill1.setEditable(false);
		jugfill1.setText("0/5");
		jugfill1.setBackground(new Color(210, 210, 210));
		jugfill1.setHorizontalAlignment(SwingConstants.CENTER);

		jugfill2 = new JTextField(5); // TextField for the jug 2's fill amount and capacity
		jugfill2.setEditable(false);
		jugfill2.setText("0/3");
		jugfill2.setBackground(new Color(210, 210, 210));
		jugfill2.setHorizontalAlignment(SwingConstants.CENTER);

		moveValue = new JTextField(5); // TextField for the amount of moves text
		moveValue.setEditable(false);
		moveValue.setText("0");
		moveValue.setBackground(new Color(210, 210, 210));
		moveValue.setHorizontalAlignment(SwingConstants.CENTER);

		bestMoveValue = new JTextField(5); // TextField for the high score number of moves text
		bestMoveValue.setEditable(false);
		bestMoveValue.setText("0");
		bestMoveValue.setBackground(new Color(210, 210, 210));
		bestMoveValue.setHorizontalAlignment(SwingConstants.CENTER);

		roundPlayed = new JTextField(5); // TextField for the number of rounds played
		roundPlayed.setEditable(false);
		roundPlayed.setText("0");
		roundPlayed.setBackground(new Color(210, 210, 210));
		roundPlayed.setHorizontalAlignment(SwingConstants.CENTER);

		// Add the components to the various panels
		titleFrame.add(titleLabel);
		titleFrame.add(goalLabel);
		titleFrame.add(objective);
		gameFrame.add(jugLabel);
		gameFrame.add(j0);
		gameFrame.add(j1);
		gameFrame.add(j2);
		gameFrame.add(fillLabel);
		gameFrame.add(jugfill0);
		gameFrame.add(jugfill1);
		gameFrame.add(jugfill2);
		detailsFrame.add(moveLabel);
		detailsFrame.add(moveValue);
		detailsFrame.add(bestMoveLabel);
		detailsFrame.add(bestMoveValue);
		detailsFrame.add(roundsPlayedLabel);
		detailsFrame.add(roundPlayed);
		detailsFrame.add(newGame);
		detailsFrame.add(quitGame);

		// Add the panels to the program's frame
		game.add(titleFrame);
		game.add(gameFrame);
		game.add(detailsFrame);

		// Set a titled border for the panels
		TitledBorder gameBorder = new TitledBorder("Game");
		gameFrame.setBorder(gameBorder);
		TitledBorder detailsBorder = new TitledBorder("Game Details");
		detailsFrame.setBorder(detailsBorder);

		// Set frame configurations
		game.setVisible(true);
		game.setResizable(false);
		game.setSize(600,350);

		// Create button press event handlers
		JugPuzzleGUIActionListener eventJug0 = new JugPuzzleGUIActionListener("Jug0");
		JugPuzzleGUIActionListener eventJug1 = new JugPuzzleGUIActionListener("Jug1");
		JugPuzzleGUIActionListener eventJug2 = new JugPuzzleGUIActionListener("Jug2");
		JugPuzzleGUIActionListener restartGame = new JugPuzzleGUIActionListener("Restart Game");
		JugPuzzleGUIActionListener exitGame = new JugPuzzleGUIActionListener("New Game");

		// Create listeners for the button press (actions)
		j0.addActionListener(eventJug0);
		j1.addActionListener(eventJug1);
		j2.addActionListener(eventJug2);
		newGame.addActionListener(restartGame);
		quitGame.addActionListener(exitGame);
	}
}
