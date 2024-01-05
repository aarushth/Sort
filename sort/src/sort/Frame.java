package sort;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Frame extends JFrame implements Panel.EventListener{
	public interface EventListener{
		public void onPaintEvent(Graphics g);
		public void onEnterEvent();
		public void onNumEvent(int i);
	}
	
	public EventListener listener;
	private Panel p;
	
	
	public Frame(EventListener e) {
		setBounds(1, 1, 1000, 500);
		listener = e;
		setTitle("Sort");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		p = new Panel(this);

		add(p);

		
		addKeyListener(new KeyListener());
	}

	private class KeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent event) {
			int key = event.getKeyCode();
			switch(key) {
				case KeyEvent.VK_ENTER:
					listener.onEnterEvent();
					break;
				case KeyEvent.VK_1:
					listener.onNumEvent(1);
					break;
				case KeyEvent.VK_2:
					listener.onNumEvent(2);
					break;
				case KeyEvent.VK_3:
					listener.onNumEvent(3);
					break;
				case KeyEvent.VK_4:
					listener.onNumEvent(4);
					break;
				case KeyEvent.VK_5:
					listener.onNumEvent(5);
					break;
				case KeyEvent.VK_6:
					listener.onNumEvent(6);
					break;
				case KeyEvent.VK_7:
					listener.onNumEvent(7);
					break;
				case KeyEvent.VK_8:
					listener.onNumEvent(8);
					break;
				case KeyEvent.VK_9:
					listener.onNumEvent(9);
					break;
			}
		}
		
	}
	public void updateFrame() {
		p.repaint();
	}
	@Override
	public void onPaintEvent(Graphics g) {
		listener.onPaintEvent(g);
	}

}
