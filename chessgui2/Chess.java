
/**
	@author Jinwook Shin 100227640
	Date finished : 6/24/19 (Mon)
*/

/**
 * 
 * 
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Chess {

	public static void main(String[] args) {
		GameControllerComponent component = new GameControllerComponent();
		class MousePressedListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent event) {
				// TODO Auto-generated method stub

				component.click(event.getX(), event.getY());
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		}

		// Frame
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 570;
		final int FRAME_HEIGHT = 600;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// component instantiated and then added onto the frame
		MousePressedListener listener = new MousePressedListener();

		component.addMouseListener(listener);

		frame.add(component);

		frame.setVisible(true);

		// Note that you should call after set frame to visible.

	}

}
