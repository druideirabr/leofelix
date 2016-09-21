package TelaRecursiva;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Tela extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static final int   CANVAS_WIDTH = 600;
	private static final int   CANVAS_HEIGHT = 600;
	private static final Color CANVAS_BG_COLOR = Color.green;
	
	private BufferedImage offscreenBuffer;
	private Graphics2D osg;
	private Color drawingColor;
	
	public Tela(){
		super("= -- = Tela = -- =");
		
		this.offscreenBuffer = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		this.osg = this.offscreenBuffer.createGraphics();
		this.drawingColor = Color.blue;
		
		//listener pra fechar a janela
		this.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				onClosing();
			}
		});
		
		// fixa dimensoes da janela
		this.setSize (CANVAS_WIDTH+10, CANVAS_HEIGHT+40);
		this.setResizable(false);
		this.setVisible (true);
	}
	
	public void onClosing() {
		System.exit(0);
	}
	
	public void paint(Graphics g) {
		g.drawImage(this.offscreenBuffer, 
				    5, 30, CANVAS_WIDTH+4, CANVAS_HEIGHT+29, 
				    0, 0,  CANVAS_WIDTH-1, CANVAS_HEIGHT-1, 
				    CANVAS_BG_COLOR, 
				    null);
	}
	
	public Graphics2D getOsg() {
		return osg;
	}

	public void setOsg(Graphics2D osg) {
		this.osg = osg;
	}

	public void desenhaRetangulo(int x, int y, int largura, int altura){
		this.osg.setColor(this.drawingColor);
		this.osg.drawRect(x, y, largura, altura);
		this.repaint();
		
	}
	
	public void desenhaPonto(int x, int y){
		desenhaRetangulo(x, y, 1, 1);			
	}
	
	public void desenhaLinha(int x1, int y1, int x2, int y2){	
		this.osg.setColor(this.drawingColor);
		this.osg.drawLine(x1, y1, x2, y2);
		this.repaint();
	}
	
	public void desenhaElipse(int x, int y, int largura, int altura){
		this.osg.setColor(this.drawingColor);
		this.osg.drawOval(x, y, largura, altura);
		this.repaint();
	}
	
	public void mudaCor(int r, int g, int b) {
		this.drawingColor = new Color(r,g,b);
		this.osg.setColor(drawingColor);
	}
	
	public void limpar() {
		this.osg.setColor(this.drawingColor);
		this.osg.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
		this.repaint();		
	}

	public int getCanvasWidth() {
		return CANVAS_WIDTH;
	}

	public int getCanvasHeight() {
		return CANVAS_HEIGHT;
	}


	
}