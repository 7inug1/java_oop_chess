/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * ChessBoard class
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JComponent;


public class ChessBoard {
	private int SIZE = 8;
	private Box[][] board;
	private Piece[][] pieces;
	private BasicStroke stroke;

	public ChessBoard() {
		board = new Box[SIZE][SIZE];
		pieces = new Piece[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = new Box(Def.GAP + j * Def.LENGTH, Def.GAP + i * Def.LENGTH, Def.LENGTH);
			}
		}
		populate();
	}
	/**
	 * A method that checks whether there is a piece inside. 
	 * @param x
	 * @param y
	 * @return pieces
	 */
	public Piece clickedPiece(double x, double y) {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				if(board[i][j].isInside(x, y)) {
					return pieces[j][i];
				}
			}
		}
		return null;
	}
	/**
	 * Making a chessboard that has a switching tile.
	 * 
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if ((i + j) % 2 == 0)
					board[i][j].draw(g2);
				else
					board[i][j].fill(g2);
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				//draw a circle of the size of the box
				//graphically when clicked. 
				if(pieces[i][j].isClicked()) {
					Ellipse2D circle = new Ellipse2D.Double(Def.GAP + pieces[i][j].getX()* Def.LENGTH, Def.GAP + pieces[i][j].getY()*Def.LENGTH, Def.LENGTH, Def.LENGTH);
					g2.setColor(Color.red);
	                g2.setStroke(new BasicStroke(5));
	                
					g2.draw(circle);
				} 
				pieces[i][j].draw(g2);
			}
		}

	}

	/**
	 * Chess coordinates :
	 *   a b c d e f g h 
	 * 7 
	 * 6 
	 * 5 
	 * 4 
	 * 3 
	 * 2 
	 * 1 
	 * 0 
	 * 
	 * (0,0)Rook (7,0)Rook
	 * 
	 * 
	 * 
	 * (0,7)Rook (7,7)Rook
	 */
	public void populate() {
		pieces[0][0] = new Rook(Def.BLACK, 0, 0);
		pieces[7][0] = new Rook(Def.BLACK, 7, 0);
		pieces[1][0] = new Knight(Def.BLACK, 1, 0);
		pieces[6][0] = new Knight(Def.BLACK, 6, 0);
		pieces[2][0] = new Bishop(Def.BLACK, 2, 0);
		pieces[5][0] = new Bishop(Def.BLACK, 5, 0);
		pieces[3][0] = new Queen(Def.BLACK, 3, 0);
		pieces[4][0] = new King(Def.BLACK, 4, 0);

		pieces[0][7] = new Rook(Def.WHITE, 0, 7);
		pieces[7][7] = new Rook(Def.WHITE, 7, 7);
		pieces[1][7] = new Knight(Def.WHITE, 1, 7);
		pieces[6][7] = new Knight(Def.WHITE, 6, 7);
		pieces[2][7] = new Bishop(Def.WHITE, 2, 7);
		pieces[5][7] = new Bishop(Def.WHITE, 5, 7);
		pieces[3][7] = new Queen(Def.WHITE, 3, 7);
		pieces[4][7] = new King(Def.WHITE, 4, 7);

		for (int i = 0; i < 8; i++) {
			pieces[i][1] = new Pawn(Def.BLACK, i, 1);
			pieces[i][6] = new Pawn(Def.WHITE, i, 6);
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 2; j < SIZE - 2; j++) {
				pieces[i][j] = new Dummy(i, j);
			}
		}

		// (0,1)~(7,1)
		// (0,6)~(7,6)

	}

	/**
	 * Move method that does all the parts about moving pieces.
	 * @param from_row
	 * @param from_column
	 * @param to_row
	 * @param to_column
	 */
	public void move(Piece pre, Piece after) {
		pieces[after.getX()][after.getY()] = pre;
		pieces[pre.getX()][pre.getY()] = new Dummy(pre.getX(), pre.getY());
		pre.move(after.getX(), after.getY());
		after = null;
		
	}
	//lookUp and remove method from the previous lab have been
	//removed as they are not required anymore.

}
