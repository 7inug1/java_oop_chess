/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * 
 */

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameControllerComponent extends JComponent {
	private ChessBoard theBoard;
	private boolean turn;
	//clickedPiece added
	private Piece clickedPiece = null;

	public GameControllerComponent() {
		theBoard = new ChessBoard();
		theBoard.populate();
		//turn starts with true;
		turn = true;	
	}

	public void paintComponent(Graphics g) {
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		theBoard.draw(g2);
	}
	//start, validInput from previous have been removed
	//click has been created. 
	/**
	 * Click method that deals everything with checking the basic rules
	 * of the chess program. It checks whether the user's clicks are
	 * valid ones or not. 
	 * @param x
	 * @param y
	 */
	public void click(double x, double y) {
		
		Piece p = theBoard.clickedPiece(x, y);
	
		if((!turn && p.getColor()==Def.WHITE) || (turn && p.getColor()==Def.BLACK)) {
			if(clickedPiece == null) {
				JOptionPane.showMessageDialog(null, "Not your turn");
			} else {
				theBoard.move(clickedPiece, p);
				clickedPiece.toggle();
				clickedPiece = null;
				turn = !turn;
			}
		} else {
			
			if( p != null && !(p instanceof Dummy) ) {
				if(clickedPiece != null && clickedPiece.equals(p)) {
					clickedPiece.toggle();
					clickedPiece = null;
				} else {
					if(clickedPiece != null) {
						clickedPiece.toggle();
						clickedPiece = null;
					}
					p.toggle();
					clickedPiece = p;
				}
			}
		
			if(clickedPiece != null && p instanceof Dummy) {
				theBoard.move(clickedPiece, p);
				clickedPiece.toggle();
				clickedPiece = null;
				turn = !turn;
			}
		}
		repaint();
	}

}
