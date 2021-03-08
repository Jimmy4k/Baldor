package Options;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import MainGame.Game;
import MainGame.GameManager;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu(GameManager gm) {

		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 800, 600);

		JButton btnBack = new JButton("ZURÜCK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), gm.getLastPanel());
			}
		});
		btnBack.setFont(Game.baseFont30);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFocusPainted(false);
		btnBack.setForeground(Color.LIGHT_GRAY);
		btnBack.setBounds(320, 390, 160, 50);
		add(btnBack);
		
		JButton btnBeenden = new JButton("ENDE");
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnBeenden.setForeground(Color.LIGHT_GRAY);
		btnBeenden.setFont(new Font("MedievalSharp", Font.BOLD, 30));
		btnBeenden.setFocusPainted(false);
		btnBeenden.setBackground(Color.BLACK);
		btnBeenden.setBounds(320, 329, 160, 50);
		add(btnBeenden);
		
		JButton btnOptionen = new JButton("OPTION");
		btnOptionen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "OptionMenu");
			}
		});
		btnOptionen.setForeground(Color.LIGHT_GRAY);
		btnOptionen.setFont(new Font("MedievalSharp", Font.BOLD, 30));
		btnOptionen.setFocusPainted(false);
		btnOptionen.setBackground(Color.BLACK);
		btnOptionen.setBounds(320, 268, 160, 50);
		add(btnOptionen);
		
		JButton btnSpeichern = new JButton("SAVE");
		btnSpeichern.setForeground(Color.LIGHT_GRAY);
		btnSpeichern.setFont(new Font("MedievalSharp", Font.BOLD, 30));
		btnSpeichern.setFocusPainted(false);
		btnSpeichern.setBackground(Color.BLACK);
		btnSpeichern.setBounds(320, 207, 160, 50);
		add(btnSpeichern);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setForeground(Color.LIGHT_GRAY);
		btnLoad.setFont(new Font("MedievalSharp", Font.BOLD, 30));
		btnLoad.setFocusPainted(false);
		btnLoad.setBackground(Color.BLACK);
		btnLoad.setBounds(320, 146, 160, 50);
		add(btnLoad);

	}

}
