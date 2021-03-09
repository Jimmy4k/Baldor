package MainGame;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.JLayeredPane;

import Hub.Hud;
import Level.LevelSwitcher;
import Options.Sound;
import Player.Player;

public class GameManager {

	private CardLayout cardLayout;
	private JLayeredPane layeredPane;
	private Player player;
	private LevelSwitcher levelSwitcher;
	private Hud hud;
	private String lastPanel;
	private Sound backgroundSound;
	private Sound buttonSound;
	private File backgroundSoundFile = new File("D:\\Programme\\Eciplse\\Workspace\\Game\\src\\Options\\FantasyMusik.wav").getAbsoluteFile();
	private File buttonSoundFile = new File("D:\\Programme\\Eciplse\\Workspace\\Game\\src\\Options\\Button.wav").getAbsoluteFile();

	public GameManager() {
		
		cardLayout = new CardLayout();
		layeredPane = new JLayeredPane();
		player = new Player();
		levelSwitcher = new LevelSwitcher();
		hud = new Hud();
		backgroundSound = new Sound();
		buttonSound = new Sound();
		
	}
	
	public File getBackgroundSoundFile() {
		return backgroundSoundFile;
	}

	public void setBackgroundSoundFile(File backgroundSoundFile) {
		this.backgroundSoundFile = backgroundSoundFile;
	}

	public File getButtonSoundFile() {
		return buttonSoundFile;
	}

	public void setButtonSoundFile(File buttonSoundFile) {
		this.buttonSoundFile = buttonSoundFile;
	}

	public Sound getButtonSound() {
		return buttonSound;
	}

	public void setButtonSound(Sound buttonSound) {
		this.buttonSound = buttonSound;
	}

	public Sound getBackgroundSound() {
		return backgroundSound;
	}

	public void setBackgroundSound(Sound backgroundSound) {
		this.backgroundSound = backgroundSound;
	}

	public Hud getHud() {
		return hud;
	}

	public void setHud(Hud hud) {
		this.hud = hud;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public LevelSwitcher getLevelSwitcher() {
		return levelSwitcher;
	}

	public void setLevelSwitcher(LevelSwitcher levelSwitcher) {
		this.levelSwitcher = levelSwitcher;
	}

	public String getLastPanel() {
		return lastPanel;
	}

	public void setLastPanel(String lastPanel) {
		this.lastPanel = lastPanel;
	}
}
