package Level;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import MainGame.GameManager;

public class Level08 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 * @param Level05
	 * 
	 * @param player
	 * @param layeredPane
	 * @param cl
	 * @param ls
	 */

	public Level08(GameManager gm) {
		
		JPanel p = this;
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);

		gm.getHud().hud(gm, p);
		
		gm.setLastPanel("Level08");


		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Level09 level09 = new Level09(gm);
				gm.getLayeredPane().add(level09, "Level09");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level09");
			}			@Override
			public void mouseEntered(MouseEvent e) {
				btnWeiter.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnWeiter.setForeground(Color.LIGHT_GRAY);
			}
		});
		btnWeiter.setForeground(Color.LIGHT_GRAY);
		btnWeiter.setFont(new Font("MedievalSharp", Font.BOLD, 30));
		btnWeiter.setFocusPainted(false);
		btnWeiter.setBackground(Color.BLACK);
		btnWeiter.setBounds(325, 450, 150, 50);
		add(btnWeiter);
		
	}
}
