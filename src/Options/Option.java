package Options;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.sound.sampled.FloatControl;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Level.Level02;
import MainGame.Game;
import MainGame.GameManager;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Option extends JPanel {

	private static final long serialVersionUID = 1L;
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
				gm.getButtonSound().playSoundAgain();
				if (gm.getLastPanel() == "StartMenu") {
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
		SoundSettings.setBounds(22, 24, 217, 149);
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
		
		JLabel lblButtonVolume = new JLabel("Button Volume: 50");
		lblButtonVolume.setForeground(Color.LIGHT_GRAY);
		lblButtonVolume.setFont(new Font("MedievalSharp", Font.BOLD, 15));
		lblButtonVolume.setBounds(10, 94, 193, 18);
		SoundSettings.add(lblButtonVolume);
		
		JSlider slider_1 = new JSlider(0, 100, 50);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double value = slider_1.getValue() / 100.0;
				lblButtonVolume.setText("Button Volume: " + df.format((value) * 100));
				FloatControl gainControl = (FloatControl) gm.getButtonSound().getAudioClip()
						.getControl(FloatControl.Type.MASTER_GAIN);
				float dB = (float) (Math.log(value) / Math.log(10.0) * 20.0);
				gainControl.setValue(dB);
			}
		});
		slider_1.setForeground(Color.LIGHT_GRAY);
		slider_1.setBackground(Color.BLACK);
		slider_1.setBounds(10, 112, 193, 26);
		SoundSettings.add(slider_1);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double value = slider.getValue() / 100.0;
				lblSoundVolume.setText("Sound Volume: " + df.format((value) * 100));
				FloatControl gainControl = (FloatControl) gm.getBackgroundSound().getAudioClip()
						.getControl(FloatControl.Type.MASTER_GAIN);
				float dB = (float) (Math.log(value) / Math.log(10.0) * 20.0);
				gainControl.setValue(dB);
			}
		});
	}
}
