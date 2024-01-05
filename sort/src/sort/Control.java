package sort;

import java.awt.Graphics;


public class Control implements Frame.EventListener, Sorter.EventListener{

	private List list;
	private Frame frame;
	private Draw drawer;
	private Sorter sort;
	//private int length;
	private boolean firstDraw = true;
	public Control() {
		//length = size;
		list = new List(500);
		list.randomize();
		
		sort = new Sorter(this);
		drawer = new Draw();
		frame = new Frame(this);
		
	}
	
	
	
	
	@Override
	public void onPaintEvent(Graphics g) {
		if(firstDraw) {
			drawer.init(g, list.getArray());
			firstDraw = false;
		}
		drawer.drawFrame(g, list.getArray());
	}

	@Override
	public void onEnterEvent() {
		
		//sort.randomize(list, frame);
	}




	@Override
	public void update() {
		frame.updateFrame();
	}




	@Override
	public void onNumEvent(int i) {
		Thread thread = new Thread(){
			public void run(){
				switch(i) {
					case 1:
						list = new List(50);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.bubbleSort(list, frame);
						frame.updateFrame();	
						break;
					case 2:
						list = new List(200);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.insertionSort(list, frame);
						frame.updateFrame();
						break;
					case 3:
						list = new List(500);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.radixLSD(list, frame);
						frame.updateFrame();
						break;
					case 4:
						list = new List(500);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.radixMSD(list, frame);
						frame.updateFrame();
						break;
					case 5:
						list = new List(100);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.cocktailShaker(list, frame);
						frame.updateFrame();
						break;
					case 6:
						list = new List(500);
						drawer.changeSize(list.getArray());
						sort.randomize(list, frame);
						sort.mergeSort(list, frame);
						frame.updateFrame();
						break;
				}	
				
			}
		};
		thread.start();
	}
	
	
}
