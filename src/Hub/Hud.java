package Hub;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Items.Trank;
import Items.Weapons;
import MainGame.Game;
import MainGame.GameManager;
import Options.Menu;

public class Hud extends JPanel {
	public Hud() {
//	hud(null, null);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public void hud(GameManager gm, JPanel p) {
		
		p.setBackground(Color.BLACK);
		p.setLayout(null);
		p.setBounds(100, 100, 811, 562);

		JPanel hudBar = new JPanel();
		hudBar.setBounds(10, 511, 790, 39);
		hudBar.setBackground(Color.BLACK);
		hudBar.setBorder(new LineBorder(Color.WHITE));
		p.add(hudBar);
		hudBar.setLayout(null);

		JPanel hudHealthBar = new JPanel();
		hudHealthBar.setBounds(0, 19, 110, 20);
		hudHealthBar.setBackground(Color.BLACK);
		hudHealthBar.setBorder(new LineBorder(Color.WHITE));
		hudBar.add(hudHealthBar);
		hudHealthBar.setLayout(null);

		JLabel lblHealthBar = new JLabel("Leben : ");
		lblHealthBar.setBounds(10, 0, 90, 20);
		lblHealthBar.setFont(Game.baseFont15);
		lblHealthBar.setForeground(Color.LIGHT_GRAY);
		lblHealthBar.setText("Leben : " + gm.getPlayer().getHealth());
		hudHealthBar.add(lblHealthBar);

		JPanel hudWeaponBar = new JPanel();
		hudWeaponBar.setBounds(108, 19, 574, 20);
		hudWeaponBar.setBackground(Color.BLACK);
		hudWeaponBar.setBorder(new LineBorder(Color.WHITE));
		hudBar.add(hudWeaponBar);
		hudWeaponBar.setLayout(null);

		
		JLabel lblNWeapon = new JLabel("Waffe : ");
		if (gm.getPlayer().getWeaponBag().isEmpty()) {
			lblNWeapon.setText("Waffe : leer!");
		} else {
			Weapons waffe = gm.getPlayer().getWeaponBag().get(0);
			lblNWeapon.setText("Waffe : " + waffe.getName() + " | Schaden = " + waffe.getDamage() + " | Reichweite = "
					+ waffe.getRange() + "m | Haltbarkeit : " + waffe.getDurability());
		}
		lblNWeapon.setBounds(10, 0, 671, 20);
		lblNWeapon.setFont(Game.baseFont15);
		lblNWeapon.setForeground(Color.LIGHT_GRAY);
		hudWeaponBar.add(lblNWeapon);
		
		JPanel hudTraenkeBar = new JPanel();
		hudTraenkeBar.setLayout(null);
		hudTraenkeBar.setBorder(new LineBorder(Color.WHITE));
		hudTraenkeBar.setBackground(Color.BLACK);
		hudTraenkeBar.setBounds(680, 19, 110, 20);
		hudBar.add(hudTraenkeBar);
		
		JLabel lblHealthBar_1 = new JLabel("Tr\u00E4nke : 0");
		lblHealthBar_1.setForeground(Color.LIGHT_GRAY);
		lblHealthBar_1.setText("Tränke : " + gm.getPlayer().getTrankBag().size());
		lblHealthBar_1.setFont(new Font("MedievalSharp", Font.BOLD, 15));
		lblHealthBar_1.setBounds(10, 0, 90, 20);
		hudTraenkeBar.add(lblHealthBar_1);
		
		JPanel hudMenu = new JPanel();
		hudMenu.setLayout(null);
		hudMenu.setBorder(new LineBorder(Color.WHITE));
		hudMenu.setBackground(Color.BLACK);
		hudMenu.setBounds(0, 0, 110, 20);
		hudBar.add(hudMenu);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMenu.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMenu.setForeground(Color.LIGHT_GRAY);
			}
			public void mousePressed(MouseEvent e) {
				gm.getButtonSound().playSoundAgain();
				Menu menu = new Menu(gm);
				gm.getLayeredPane().add(menu, "Menu");
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Menu");
			}
		});
		btnMenu.setForeground(Color.LIGHT_GRAY);
		btnMenu.setFont(new Font("MedievalSharp", Font.BOLD, 10));
		btnMenu.setFocusPainted(false);
		btnMenu.setBorder(new LineBorder(Color.WHITE));
		btnMenu.setBackground(Color.BLACK);
		btnMenu.setBounds(0, 0, 110, 20);
		hudMenu.add(btnMenu);
		
		JPanel hudBenutzen = new JPanel();
		hudBenutzen.setLayout(null);
		hudBenutzen.setBorder(new LineBorder(Color.WHITE));
		hudBenutzen.setBackground(Color.BLACK);
		hudBenutzen.setBounds(680, 0, 110, 20);
		hudBar.add(hudBenutzen);
		
		JButton btnTrankBenutzen = new JButton("BENUTZEN");
		btnTrankBenutzen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTrankBenutzen.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTrankBenutzen.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getButtonSound().playSoundAgain();
			}
		});
		btnTrankBenutzen.setForeground(Color.LIGHT_GRAY);
		btnTrankBenutzen.setFont(new Font("MedievalSharp", Font.BOLD, 10));
		btnTrankBenutzen.setFocusPainted(false);
		btnTrankBenutzen.setBackground(Color.BLACK);
		btnTrankBenutzen.setBorder(new LineBorder(Color.WHITE));
		btnTrankBenutzen.setBounds(0, 0, 110, 20);
		hudBenutzen.add(btnTrankBenutzen);
		
		JPanel hudTasche = new JPanel();
		hudTasche.setBounds(108, 0, 110, 20);
		hudBar.add(hudTasche);
		hudTasche.setLayout(null);
		hudTasche.setBorder(new LineBorder(Color.WHITE));
		hudTasche.setBackground(Color.BLACK);
		
		JButton btnBag = new JButton("TASCHE");
		btnBag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBag.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBag.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gm.getButtonSound().playSoundAgain();
			}
		});
		btnBag.setForeground(Color.LIGHT_GRAY);
		btnBag.setFont(new Font("MedievalSharp", Font.BOLD, 10));
		btnBag.setFocusPainted(false);
		btnBag.setBackground(Color.BLACK);
		btnBag.setBorder(new LineBorder(Color.WHITE));
		btnBag.setBounds(0, 0, 110, 20);
		hudTasche.add(btnBag);
	}
	
	public void insertWeapon(GameManager gm, JPanel p, String waffenName, int damage, int durability, int range) {
		
		
		Weapons waffe = new Weapons();
		waffe.setName(waffenName);
		waffe.setDamage(damage);
		waffe.setDurability(durability);
		waffe.setRange(range);
		gm.getPlayer().getWeaponBag().add(waffe);
		
		JPanel panel = new JPanel();
		panel.setBounds(180, 125, 445, 280);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.BLACK);
		p.add(panel);
		panel.setLayout(null);
		JLabel lblItem = new JLabel("<html><body>" + waffe.getName() + " <br><br> Schaden : " + waffe.getDamage()
				+ " <br> Reichweite : " + waffe.getRange() + " <br> Haltbarkeit : " + waffe.getDurability());
		lblItem.setForeground(Color.LIGHT_GRAY);
		lblItem.setFont(Game.baseFont30);
		lblItem.setVerticalAlignment(SwingConstants.TOP);
		lblItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem.setBounds(10, 11, 423, 257);
		panel.add(lblItem);
	}
	
	public void insertTrank(GameManager gm, JPanel p, int anzahlTranke, String trankName, int volumen) {
		
		Trank trank = null;
		for (int i = 0; i < anzahlTranke; i++) {
			trank = new Trank();
			trank.setName(trankName);
			trank.setBeschreibung("Ein Heiltrank regeneriert 25 Lebenspunkte.");
			gm.getPlayer().getTrankBag().add(trank);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(180, 125, 445, 280);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(Color.BLACK);
		p.add(panel);
		panel.setLayout(null);
		
		JLabel lblItem = new JLabel("<html><body>" + trank.getName()+ " " +  anzahlTranke + " St. " + " <br> BeSchreibung : " + trank.getBeschreibung());
		lblItem.setForeground(Color.LIGHT_GRAY);
		lblItem.setFont(Game.baseFont30);
		lblItem.setVerticalAlignment(SwingConstants.TOP);
		lblItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblItem.setBounds(10, 11, 423, 257);
		panel.add(lblItem);
	}

}
