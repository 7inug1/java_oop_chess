/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * Dummy class represents an empty box of the board. 
 */

import java.awt.Graphics2D;

// 1. each piece should print itself
// 2. each piece has a color
// 3. each piece should report and color
public class Dummy extends Piece {
	public Dummy(int x, int y) {
		super(x, y);
	}
	/**
	 * get the type of the piece
	 */
	public int getType() {
		return Def.DUMMY;
	}
	/**
	 * Draw nothing for dummy
	 */
	public void draw(Graphics2D g2) {

	}

}
