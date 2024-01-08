package sort;

import java.util.ArrayList;

public class Sorter {
	
	public interface EventListener{
		public void update();
	}
	
	
	public EventListener listener;
	
	public Sorter(EventListener e) {
		listener = e;
	}
	private void wait(int time) {
		this.listener.update();
		long start = System.currentTimeMillis();
		while(start + time >= System.currentTimeMillis());
	}
	
	public void randomize(List l, Frame f) {
		l.randomize();
		this.listener.update();
	}
	long start;
	private void swap(List l, int ind1, int ind2, Frame f) {
		l.swap(ind1, ind2);
		wait(0);
	}
	private void shift(List l, int ind1, int ind2, int shift) {
		l.shift(ind1, ind2, shift);
		wait(0);
	}
	public void bubbleSort(List l, Frame f) {
		for(int j = l.size; j > 0;j--) {
			for(int i = 0; i < j-1; i++) {
				if(l.getArray()[i] > l.getArray()[i+1]) {
					this.swap(l, i, i+1, f);
				}
			}
		}
	}
	public void insertionSort(List l, Frame f) {
		for(int j = 1; j < l.size;j++) {
			for(int i = 0; i < j; i++) {
				if(l.getArray()[j] < l.getArray()[i]) {
					int temp = l.getArray()[j];
					shift(l, i, j-1, 1);
					l.getArray()[i] = temp;
					wait(0);
				}
			}
		}
	}
	public void radixLSD(List l, Frame f) {
		int max = 0;
		for(int i = 0; i < l.size; i++) {
			if(l.getArray()[i] > max) {
				max = l.getArray()[i];
			}
		}
		for(int i = 1; i <= Integer.toString(max).length();i++) {
			int mod = (int) Math.pow(10, i);
			int divide = (int) Math.pow(10,  i-1);
			int maxDig = 0;
			for(int j = 0; j < l.size;j++) {
				if((l.getArray()[j]%mod)/divide > maxDig) {
					maxDig = (l.getArray()[j]%mod)/divide;
				}
			}
			int[] countArr = new int[maxDig+1];
			for(int j = 0; j < l.size;j++) {
				int st = (l.getArray()[j]%mod)/divide;
				countArr[st]++;
			}
			for(int j = 1; j < countArr.length; j++) {
				countArr[j] += countArr[j-1];
			}
			int[] outputArr = new int[l.size];
			for(int j = l.size-1; j >=0; j--) {
				int outInd = countArr[(l.getArray()[j]%mod)/divide];
				outputArr[outInd - 1] = l.getArray()[j];
				countArr[(l.getArray()[j]%mod)/divide]--;
			}
			l.set(outputArr);
			wait(1000);
		}
		
	}
	private void internalMSD(List l, Frame f, int start, int end, int i) {
		if(i <= 0) {
			return;
		}
		int mod = (int) Math.pow(10, i);
		int divide = (int) Math.pow(10,  i-1);
		int maxDig = 0;
		for(int j = start; j <= end;j++) {
			if((l.getArray()[j]%mod)/divide > maxDig) {
				maxDig = (l.getArray()[j]%mod)/divide;
			}
		}
		int[] countArr = new int[maxDig+1];
		for(int j = start; j <= end;j++) {
			int st = (l.getArray()[j]%mod)/divide;
			countArr[st]++;
		}
		ArrayList<Integer> divisions =  new ArrayList<Integer>();
		divisions.add(start);
		divisions.add(countArr[0]+start);
		for(int j = 1; j < countArr.length; j++) {
			countArr[j] += countArr[j-1];
			divisions.add(countArr[j]+start);
		}
		int[] outputArr = new int[l.size];
		
		for(int j = end; j >=start; j--) {
			int outInd = countArr[(l.getArray()[j]%mod)/divide];
			outputArr[outInd - 1 + start] = l.getArray()[j];
			countArr[(l.getArray()[j]%mod)/divide]--;
		}
		for(int j = start; j < outputArr.length; j++) {
			if(outputArr[j] != 0) {
				l.getArray()[j] = outputArr[j];
				wait(0);
			}
		}
		if(i > 1) {
			for(int j = 0; j < divisions.size()-1; j++) {
				internalMSD(l, f, divisions.get(j), divisions.get(j+1)-1,  i-1);
			}
		}
		return;
	}
	public void radixMSD(List l, Frame f) {
		int max = 0;
		for(int i = 0; i < l.size; i++) {
			if(l.getArray()[i] > max) {
				max = l.getArray()[i];
			}
		}
		int i = Integer.toString(max).length();
		internalMSD(l, f, 0, l.size-1, i);
	}
	
	public void cocktailShaker(List l, Frame f) {
		int low = 0;
		int high = l.size-1;
		while(low < high) {
			for(int i = low; i < high; i++) {
				if(l.getArray()[i] > l.getArray()[i+1]) {
					l.swap(i, i+1);
					wait(0);
				}
			}
			high--;
			for(int i = high; i > low; i--) {
				if(l.getArray()[i] < l.getArray()[i-1]) {
					l.swap(i, i-1);
					wait(0);
				}
			}
			low++;
		}
		return;
	}
	public void mergeSort(List l, Frame f) {
		internalMergeSort(l, f, 0, l.size-1);
	}
	private void internalMergeSort(List l, Frame f, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = ((end-start)/2)+start;
		internalMergeSort(l, f, start, mid);
		internalMergeSort(l, f, mid+1, end);
		int[] outArr = new int[l.size];
		int i = start;
		int j = mid+1;
		int k = start;
		for(; i <= mid && j <= end && k <= end; k++) {
			if(l.getArray()[i] < l.getArray()[j]) {
				outArr[k] = l.getArray()[i];
				i++;
			}else {
				outArr[k] = l.getArray()[j];
				j++;
			}
		}
		if(j <= end) {
			while(k <= end) {
				outArr[k] = l.getArray()[j];
				k++;
				j++;
			}
		}else if(i <= end) {
			while(k <= end) {
				outArr[k] = l.getArray()[i];
				k++;
				i++;
			}
		}
		for(int c = 0; c < l.size; c++) {
			if(outArr[c] != 0) {
				l.getArray()[c] = outArr[c];
				wait(0);
			}
		}
		return;
	}

	public void quickSort(List l, Frame f) {
		internalQuickSort(l, f, 0, l.size-1);
	}
	private void internalQuickSort(List l, Frame f, int start, int end) {
		if(start >= end) {
			return;
		}
		int i = start;
		for(int j = start; j <= end; j++) {
			if(l.getArray()[j] < l.getArray()[end]) {
				swap(l, i, j, f);
				i++;
			}
		}
		swap(l, i, end, f);
		internalQuickSort(l, f, start, i-1);
		internalQuickSort(l, f, i, end);
	}
}
