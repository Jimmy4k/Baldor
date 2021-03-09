package Level;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainGame.Game;
import MainGame.GameManager;

public class Level01 extends JPanel {

	private static final long serialVersionUID = 1L;
	private Level02 level02;

	/**
	 * Create the panel.
	 * 
	 * @param player
	 * @param layeredPane
	 * @param cl
	 * @param player
	 * @param ls
	 */


	public Level01(GameManager gm) {
		
		JPanel p = this;
		gm.getHud().hud(gm, p);
		
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 811, 562);
		
		gm.setLastPanel("Level01");
		
		JLabel lblHerzlichWillkommen = new JLabel("Herzlich Willkommen in der Welt von Baldor!");
		lblHerzlichWillkommen.setFont(Game.baseFont30);
		lblHerzlichWillkommen.setForeground(Color.LIGHT_GRAY);
		lblHerzlichWillkommen.setBounds(70, 90, 650, 30);
		add(lblHerzlichWillkommen);

		JLabel lblWieLautetDeinName = new JLabel("Wie lautet dein Name Held?");
		lblWieLautetDeinName.setForeground(Color.LIGHT_GRAY);
		lblWieLautetDeinName.setFont(Game.baseFont30);
		lblWieLautetDeinName.setBounds(210, 196, 391, 30);
		add(lblWieLautetDeinName);
		
		
		JTextField tfName = new JTextField();
		tfName.setBackground(Color.BLACK);
		tfName.setForeground(Color.LIGHT_GRAY);
		tfName.setFont(Game.baseFont30);
		tfName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					level02 = new Level02(gm);
					gm.getPlayer().setName(tfName.getText());
					gm.getLayeredPane().add(level02, "Level02");
					level02 = new Level02(gm);
					gm.getButtonSound().playSoundAgain();
					gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level02");
				}
			}
		});
		tfName.setBounds(210, 237, 391, 40);
		tfName.setColumns(10);
		add(tfName);
		
		JButton btnWeiter = new JButton("WEITER");
		btnWeiter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				level02 = new Level02(gm);
				gm.getPlayer().setName(tfName.getText());
				gm.getLayeredPane().add(level02, "Level02");
				level02 = new Level02(gm);
				gm.getButtonSound().playSoundAgain();
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level02");
			}
			@Override
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
