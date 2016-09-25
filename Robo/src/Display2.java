import javax.swing.JOptionPane;

import javax.swing.ImageIcon;

public class Display2 implements Display {

	@Override
	public void exibir(String msg) {
		
		ImageIcon icon = new ImageIcon("C:/Users/Leo/workspace/Robo/R2D2-icon.png");
		JOptionPane.showMessageDialog(null, msg, "Sobre mim", JOptionPane.INFORMATION_MESSAGE, icon);

	}
		
	}

