/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * Class Rook represents a Rook piece in the chess game.
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//1. each piece should print itself
//2. each piece has a color
//3. each piece should report  and color
//in piece, 2 constructors, getColor, print, getType

public class Rook extends Piece {
	private BufferedImage img;

	public Rook(int color, int x, int y) {
		super(color, x, y);
		try {
			if (color == Def.BLACK)
				img = ImageIO.read(new File(Def.ROOK_BLACK));
			else
				img = ImageIO.read(new File(Def.ROOK_WHITE));

		} catch (IOException e) {
			// We will learn about this later
			// For now just use it as is.

		}
	}

	/**
	 * get the type of the piece
	 */
	public int getType() {
		return Def.ROOK;
	}

	/**
	 * Draw the piece in designated place
	 */
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH - img.getWidth()) / 2;
		int offsetY = (Def.LENGTH - img.getHeight()) / 2;
		g2.drawImage(img, offsetX + Def.GAP + getX() * Def.LENGTH, offsetY + Def.GAP + getY() * Def.LENGTH,
				img.getWidth(), img.getHeight(), null);
	}
}
