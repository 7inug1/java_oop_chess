/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * Class Piece is an abstract class that is the base for the real pieces in chess.
 */

import java.awt.Graphics2D;

public abstract class Piece {
	private int x;
	private int y;
	private int color;
	private boolean clicked;

	// Constructor used by Dummy
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Def.NO_COLOR;
		this.clicked = false;
	}

	// constructor used by chess piece
	public Piece(int color, int x, int y) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.clicked = false;
	}

	/**
	 * Getting the color for piece
	 * 
	 * @return
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Moving the piece
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Get X
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get Y
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isClicked() {
		return clicked;
	}
	/**
	 * A toggle method
	 */
	public void toggle() {
		clicked = !clicked;
	}
	
	/**
	 * Draw
	 * 
	 * @param g2
	 */
	abstract public void draw(Graphics2D g2);

	/**
	 * Get the type of each piece
	 * 
	 * @return
	 */
	abstract public int getType();

}
