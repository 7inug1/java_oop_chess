/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * Class Pawn represents a Pawn piece in the chess game.
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Pawn extends Piece {

	private BufferedImage img;

	public Pawn(int color, int x, int y) {

		super(color, x, y);
		try {
			if (color == Def.BLACK)
				img = ImageIO.read(new File(Def.PAWN_BLACK));
			else
				img = ImageIO.read(new File(Def.PAWN_WHITE));

		} catch (IOException e) {
			// We will learn about this later
			// For now just use it as is.

		}
	}

	/**
	 * get the type of the piece
	 */
	public int getType() {
		return Def.PAWN;
	}

	/**
	 * Draw the piece in designated place
	 */
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH - img.getWidth()) / 2;
		int offsetY = (Def.LENGTH - img.getHeight()) / 2;
		g2.drawImage(img, offsetX + Def.GAP + getX() * Def.LENGTH, offsetY + Def.GAP + getY() * Def.LENGTH,
				img.getWidth(), img.getHeight(), null);
		// g2.drawImgage(1.img, 2. x place, 3. y place, 4. image width, 5. image height)
	}

}
