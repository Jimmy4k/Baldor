package MainGame;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Level.Start;
import Options.Option;

public class Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Font baseFont30 = new Font("MedievalSharp", Font.BOLD, 30);
	public static Font baseFont15 = new Font("MedievalSharp", Font.BOLD, 15);
	public static Font baseFont90 = new Font("MedievalSharp", Font.BOLD, 90);
	
	private JPanel contentPane;
	private GameManager gm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws LineUnavailableException
	 * @throws InterruptedException 
	 */
	public Game() throws LineUnavailableException, InterruptedException {
		gm = new GameManager();
		
		setTitle("Baldor");
		setFont(baseFont90);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 608);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(gm.getLayeredPane(), "name_24697681903300");
		gm.getLayeredPane().setLayout(gm.getCardLayout());
		
		Start startMenu = new Start(gm);
		gm.getLayeredPane().add(startMenu, "StartMenu");
		gm.setLastPanel("StartMenu");
	
		Option option = new Option(gm);
		gm.getLayeredPane().add(option, "OptionMenu");
		option.sounds();

		gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "StartMenu");
	}
}
