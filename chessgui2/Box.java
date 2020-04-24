/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * Class Box 
 * 
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Box {
	private Rectangle2D.Double box;

	public Box(double x, double y, double width) {
		box = new Rectangle2D.Double(x, y, width, width);

	}

	/**
	 * Return true if isInside
	 * @param x
	 * @param y
	 * @return boolean
	 */
	public boolean isInside(double x, double y) {
		if (x >= box.getX() && x <= box.getX() + box.getWidth() && y >= box.getY()
				&& y <= box.getY() + box.getHeight()) {
			return true;
		}
		return false;
	}

	/**
	 * Drawing box
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		g2.draw(box);
	}

	/**
	 * Filling the box
	 * 
	 * @param g2
	 */
	public void fill(Graphics2D g2) {
		g2.draw(box);
		g2.setColor(new Color(204, 102, 0));
		g2.fill(box);
	}
}