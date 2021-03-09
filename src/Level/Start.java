package Level;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainGame.Game;
import MainGame.GameManager;

public class Start extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Start(GameManager gm) {

		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 800, 600);

		gm.setLastPanel("StartMenu");

		JLabel lblGameName = new JLabel("BALDOR");
		lblGameName.setFont(Game.baseFont90);
		lblGameName.setForeground(Color.LIGHT_GRAY);
		lblGameName.setBounds(225, 115, 367, 83);
		add(lblGameName);

		JButton btnStartGame = new JButton("START");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Level01 level01 = new Level01(gm);				
				gm.getButtonSound().playSoundAgain();
				gm.getLayeredPane().add(level01, "Level01");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Level01");
			}
		});
		btnStartGame.setFont(Game.baseFont30);
		btnStartGame.setBackground(Color.BLACK);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setForeground(Color.LIGHT_GRAY);
		btnStartGame.setBounds(320, 230, 160, 50);
		add(btnStartGame);

		JButton btnOption = new JButton("OPTION");
		btnOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getButtonSound().playSoundAgain();
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "OptionMenu");
			}
		});
		btnOption.setForeground(Color.LIGHT_GRAY);
		btnOption.setFont(Game.baseFont30);
		btnOption.setFocusPainted(false);
		btnOption.setBackground(Color.BLACK);
		btnOption.setBounds(320, 310, 160, 50);
		add(btnOption);

		JButton btnStartGame_1 = new JButton("EXIT");
		btnStartGame_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.getButtonSound().playSoundAgain();
				System.exit(0);
			}
		});
		btnStartGame_1.setForeground(Color.LIGHT_GRAY);
		btnStartGame_1.setFont(Game.baseFont30);
		btnStartGame_1.setFocusPainted(false);
		btnStartGame_1.setBackground(Color.BLACK);
		btnStartGame_1.setBounds(320, 390, 160, 50);
		add(btnStartGame_1);

	}
}
