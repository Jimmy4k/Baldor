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

public class Level04 extends JPanel {

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
	public Level04(GameManager gm) {

		JPanel p = this;
		gm.getHud().hud(gm, p);
		
		gm.setLastPanel("Level04");
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);

		JLabel lblBegrüßung = new JLabel("<html><body>Es ist nicht viel aber nimm dies von mir "
				+ gm.getPlayer().getName() + ". Es hat mir auf meinem Weg immer gute Dienste erwiesen.<body><html>");
		lblBegrüßung.setVerticalAlignment(SwingConstants.TOP);
		lblBegrüßung.setFont(Game.baseFont30);
		lblBegrüßung.setForeground(Color.LIGHT_GRAY);
		lblBegrüßung.setBounds(180, 90, 480, 410);
		add(lblBegrüßung);
		
		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Level05 level05 = new Level05(gm);
				gm.getLayeredPane().add(level05, "Level05");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level05");
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
