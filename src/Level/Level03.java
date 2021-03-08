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

public class Level03 extends JPanel {

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
	public Level03(GameManager gm) {

		JPanel p = this;
		gm.getHud().hud(gm, p);
		
		gm.setLastPanel("Level03");
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);

		JLabel lblBegrüßung = new JLabel(
				"<html><body>Seitdem durchstreifen finstere Gestalten die Wälder und verbreiten Angst und Verderben. <br><br> "
						+ "Nimm dich in acht auf deiner langen Reise " + gm.getPlayer().getName() + "...<body><html>");
		lblBegrüßung.setVerticalAlignment(SwingConstants.TOP);
		lblBegrüßung.setFont(Game.baseFont30);
		lblBegrüßung.setForeground(Color.LIGHT_GRAY);
		lblBegrüßung.setBounds(180, 90, 480, 410);
		add(lblBegrüßung);

		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Level04 level04 = new Level04(gm);
				gm.getLayeredPane().add(level04, "Level04");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level04");
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
