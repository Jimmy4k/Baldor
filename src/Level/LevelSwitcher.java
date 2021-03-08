package Level;

import java.awt.CardLayout;

import javax.swing.JLayeredPane;

public class LevelSwitcher {
	
	public void switchPanel(CardLayout cl, JLayeredPane layeredPane, String level) {
		cl.show(layeredPane, level);
	}

}
