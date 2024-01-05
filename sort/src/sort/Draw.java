package sort;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Draw {
	private Rectangle r;
	private int pageWidth;
	private int pageHeight;
	private double squareWidth;
	private double squareHeight;
	int textSpace = 300;
	public void init(Graphics g, int[]arr) {
		r = g.getClipBounds();
		pageWidth = r.width-textSpace;
		pageHeight = r.height;
		squareWidth = (double) pageWidth/arr.length;
		squareHeight = (double) pageHeight/arr.length;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pageWidth + textSpace, pageHeight);
		g.setColor(Color.WHITE);
		g.drawString("1: Bubble Sort", pageWidth-textSpace, 0);
		int fontDif = (int) (((pageHeight/9)-30)*1.5);
		g.setFont(new Font("Calibri", Font.PLAIN, ((fontDif+30)/3)-10));
		fontDif *= 0.5;
		g.drawString("1: Bubble Sort", pageWidth, fontDif*1);
		g.drawString("2: Insertion Sort", pageWidth, fontDif*2);
		g.drawString("3: Radix LSD Sort", pageWidth, fontDif*3);
		g.drawString("4: Radix MSD Sort", pageWidth, fontDif*4);
		g.drawString("5: Cocktail Shaker Sort", pageWidth, fontDif*5);
		g.drawString("6: Merge Sort", pageWidth, fontDif*6);
		g.drawString("7: ", pageWidth, fontDif*7);
		g.drawString("8: ", pageWidth, fontDif*8);
		g.drawString("9: ", pageWidth, fontDif*9);
	}
	public void changeSize(int[] arr) {
		squareWidth = (double) pageWidth/arr.length;
		squareHeight = (double) pageHeight/arr.length;
	}
	public void drawFrame(Graphics g, int[] array) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pageWidth, pageHeight);
		g.setColor(Color.WHITE);
		double xPos = 0;
		for(int i = 0; i < array.length; i++, xPos+=squareWidth) {
			g.fillRect((int) Math.floor(xPos),(int)  Math.round(pageHeight-(squareHeight*(array[i]))), (int)  Math.floor(squareWidth),(int)  Math.round(squareHeight*array[i]));
		}
		
		

	}
}
