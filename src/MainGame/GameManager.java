package MainGame;

import java.awt.CardLayout;

import javax.swing.JLayeredPane;

import Hub.Hud;
import Level.LevelSwitcher;
import Player.Player;

public class GameManager {

	private CardLayout cardLayout;
	private JLayeredPane layeredPane;
	private Player player;
	private LevelSwitcher levelSwitcher;
	private Hud hud;
	private String lastPanel;

	public GameManager() {
		cardLayout = new CardLayout();
		layeredPane = new JLayeredPane();
		player = new Player();
		levelSwitcher = new LevelSwitcher();
		hud = new Hud();

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
