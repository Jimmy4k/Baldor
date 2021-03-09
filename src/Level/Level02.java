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

public class Level02 extends JPanel {

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
	public Level02(GameManager gm) {
		
		JPanel p = this;
		gm.getHud().hud(gm, p);
		
		gm.setLastPanel("Level02");
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);

		JLabel lblBegrüßung = new JLabel("<html><body> Vor langer Zeit, lebten die Länder von Baldor miteinander in Frieden und Harmonie...<br>"
				+ "Bis zum tot vom König Gambolin... Danach zog über ganz Baldor ein dunkler Schatten und die Länder verloren das gegenseitige Vertrauen zu einander... </body></html>");
		lblBegrüßung.setHorizontalAlignment(SwingConstants.LEFT);
		lblBegrüßung.setVerticalAlignment(SwingConstants.TOP);
		lblBegrüßung.setFont(Game.baseFont30);
		lblBegrüßung.setForeground(Color.LIGHT_GRAY);
		lblBegrüßung.setBounds(180, 90, 480, 410);
		add(lblBegrüßung);
		
		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getButtonSound().playSoundAgain();
				Level03 level03 = new Level03(gm);
				gm.getLayeredPane().add(level03, "Level03");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level03");
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
