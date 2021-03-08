package Level;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MainGame.Game;
import MainGame.GameManager;

public class Level06 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * 
	 * @param player
	 * @param layeredPane
	 * @param cl
	 * @param ls
	 */
	public Level06(GameManager gm) {

		JPanel p = this;
		gm.getHud().hud(gm, p);
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);
		
		gm.setLastPanel("Level06");

		JLabel lblBegr��ung = new JLabel("<html><body>Und bevor ich es vergesse..." + gm.getPlayer().getName() + " Nimm auch diese Tr�nke von mir, sie werden dir in schwachen Momenten wieder Kraft schenken.<body><html>");
		lblBegr��ung.setVerticalAlignment(SwingConstants.TOP);
		lblBegr��ung.setFont(Game.baseFont30);
		lblBegr��ung.setForeground(Color.LIGHT_GRAY);
		lblBegr��ung.setBounds(180, 90, 480, 410);
		add(lblBegr��ung);

		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Level07 level07 = new Level07(gm);
				gm.getLayeredPane().add(level07, "Level07");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level07");
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
