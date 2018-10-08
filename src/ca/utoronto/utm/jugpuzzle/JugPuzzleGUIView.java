package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;
import java.util.Observer;

/**
 * @author csc207student
 */
public class JugPuzzleGUIView implements Observer{

	public void update(Observable o, Object arg) {
		JugPuzzle puzzle = (JugPuzzle)o;
		System.out.println(puzzle.toString() + " has detected "+ arg);
	}
}
