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
	int fontDif;
	Font font;
	int textSpace = 300;
	public void init(Graphics g, int[]arr) {
		r = g.getClipBounds();
		pageWidth = r.width-textSpace;
		pageHeight = r.height;
		squareWidth = (double) pageWidth/arr.length;
		squareHeight = (double) pageHeight/arr.length;
		fontDif = (int) (((pageHeight/9)-30)*1.5);
		font = new Font("Calibri", Font.PLAIN, ((fontDif+30)/3)-10);
		fontDif *= 0.45;
		drawStrings(g, true);
	}
	public void drawStrings(Graphics g, boolean nonRec) {
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pageWidth + textSpace, pageHeight);
		g.setColor(nonRec?Color.GREEN:Color.WHITE);
		g.drawString("Non recursive Sorts", pageWidth, fontDif*1);
		g.drawString("1: Bubble Sort", pageWidth, fontDif*2);
		g.drawString("2: Cocktail Shaker Sort", pageWidth, fontDif*3);
		g.drawString("3: Insertion Sort", pageWidth, fontDif*4);
		g.drawString("4: Radix LSD Sort", pageWidth, fontDif*5);
		g.drawString("5: Selection Sort", pageWidth, fontDif*6);
		g.drawString("6: ", pageWidth, fontDif*7);
		g.drawString("7: ", pageWidth, fontDif*8);
		g.drawString("8: ", pageWidth, fontDif*9);
		g.drawString("9: ", pageWidth, fontDif*10);
		g.setColor(nonRec?Color.WHITE:Color.GREEN);
		g.drawString("Recursive Sorts", pageWidth, fontDif*12);
		g.drawString("1: Radix MSD Sort", pageWidth, fontDif*13);
		g.drawString("2: Merge Sort", pageWidth, fontDif*14);
		g.drawString("3: Quick Sort", pageWidth, fontDif*15);
		g.drawString("4: ", pageWidth, fontDif*16);
		g.drawString("5: ", pageWidth, fontDif*17);
		g.drawString("6: ", pageWidth, fontDif*18);
		g.drawString("7: ", pageWidth, fontDif*19);
		g.drawString("8: ", pageWidth, fontDif*20);
		g.drawString("9: ", pageWidth, fontDif*21);
	}
	public void changeSize(int[] arr) {
		squareWidth = (double) pageWidth/arr.length;
		squareHeight = (double) pageHeight/arr.length;
	}
	public void drawFrame(Graphics g, List l) {
		int[] array = l.getArray();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pageWidth, pageHeight);
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString("Comparisons: " + l.getComparisons(), 20, fontDif*1);
		g.drawString("Writes to Auxilliary Arrays: " + l.getWrites(), 20, fontDif*2);
		g.drawString("Swaps: " + l.getSwaps(), 20, fontDif*3);
		g.setColor(Color.WHITE);
		double xPos = 0;
		for(int i = 0; i < array.length; i++, xPos+=squareWidth) {
			g.fillRect((int) Math.floor(xPos),(int)  Math.round(pageHeight-(squareHeight*(array[i]))), (int)  Math.floor(squareWidth),(int)  Math.round(squareHeight*array[i]));
		}
		
		

	}
}
