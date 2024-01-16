package sort;

import java.util.ArrayList;

public class List {
	private int[] array;
	int size;
	private long comparison = 0;
	private long writeToAux = 0;
	private long swap = 0;
	public void compare() {
		comparison++;
	}
	public void writeToAux() {
		writeToAux++;
	}
	public long getComparisons() {
		return comparison;
	}
	public long getWrites() {
		return writeToAux;
	}
	public long getSwaps() {
		return swap;
	}
	public int[] getArray() {
		return array;
	}
	public List(int s) {
		size = s;
		array = new int[size];
	}
	public String toString() {
		String arr = "";
		for(int i = 0; i < size; i++) {
			arr += array[i] + " ";
		}
		return arr;
	}
	public int[] getList() {
		return array;
	}
	public void swap(int ind1, int ind2) {
		int temp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = temp;
		swap++;
	}
	public void shift(int ind1, int ind2, int shift) {
		for(int i = ind2; i >= ind1; i--) {
			array[i+shift] = array[i];
			swap++;
		}
	}
	public void set(int[] arr) {
		array = arr;
	}
	public void randomize() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++) {
			nums.add(i);
		}
		for(int i = 0; i < array.length; i++) {
			int index = (int) (Math.random()*nums.size());
			int rand = nums.get(index);
			nums.remove(index);
			array[i] = rand;
		}
	}
}
