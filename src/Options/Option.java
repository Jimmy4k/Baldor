package Options;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MainGame.Game;
import MainGame.GameManager;

public class Option extends JPanel {

	private static final long serialVersionUID = 1L;
	private double value = 0.50;
	private Clip audioClip;
	private File soundFile = new File("D:\\Programme\\Eciplse\\Workspace\\Game\\src\\MainGame\\FantasyMusik.wav")
			.getAbsoluteFile();
	private DecimalFormat df = new DecimalFormat("##");

	/**
	 * Create the panel.
	 * 
	 * @param sounds
	 */
	public Option(GameManager gm) {

		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(100, 100, 800, 600);

		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if ( gm.getLastPanel() == "StartMenu") {
					gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "StartMenu");
				}
				gm.getLevelSwitcher().switchPanel(gm.getCardLayout(), gm.getLayeredPane(), "Menu");
			}
		});
		btnBack.setFont(Game.baseFont30);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFocusPainted(false);
		btnBack.setForeground(Color.LIGHT_GRAY);
		btnBack.setBounds(320, 390, 160, 50);
		add(btnBack);

		JPanel SoundSettings = new JPanel();
		SoundSettings.setBackground(Color.BLACK);
		SoundSettings.setBorder(new LineBorder(Color.LIGHT_GRAY));
		SoundSettings.setBounds(22, 24, 217, 111);
		add(SoundSettings);
		SoundSettings.setLayout(null);

		JSlider slider = new JSlider(0, 100, 50);
		slider.setBounds(10, 66, 193, 26);
		SoundSettings.add(slider);
		slider.setBackground(Color.BLACK);
		slider.setForeground(Color.LIGHT_GRAY);

		JLabel lblSoundVolume = new JLabel("Sound Volume: 50");
		lblSoundVolume.setBounds(10, 48, 193, 18);
		SoundSettings.add(lblSoundVolume);
		lblSoundVolume.setForeground(Color.LIGHT_GRAY);
		lblSoundVolume.setFont(Game.baseFont15);

		JLabel lblSoundSettings = new JLabel("Sound Settings");
		lblSoundSettings.setForeground(Color.LIGHT_GRAY);
		lblSoundSettings.setFont(new Font("MedievalSharp", Font.BOLD, 25));
		lblSoundSettings.setBounds(10, 11, 193, 26);
		SoundSettings.add(lblSoundSettings);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				value = slider.getValue() / 100.0;
				lblSoundVolume.setText("Sound Volume: " + df.format((value) * 100));
				FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
				float dB = (float) (Math.log(value) / Math.log(10.0) * 20.0);
				gainControl.setValue(dB);
			}
		});
	}

	public void sounds() {
		try {
			audioClip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			audioClip.open(ais);
			audioClip.start();

		} catch (Exception ex) {
			System.out.println("Kann die Sounddatei nicht abspielen.");
			ex.printStackTrace();

		}
	}
}
