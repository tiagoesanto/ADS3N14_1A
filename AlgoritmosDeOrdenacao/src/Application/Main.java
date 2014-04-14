package Application;

import java.util.Random;

import View.ConsoleView;
import Controller.*;

public class Main {

	public static void main(String[] args) 
	{
		int[] array = new int[10];
		BubbleSort bubbleSort = new BubbleSort();
		HeapSort heapSort = new HeapSort();
		ConsoleView consoleView = new ConsoleView();
		Random random = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		consoleView.showBubbleSort();
		consoleView.showDerangedArray(array);
		
		array = bubbleSort.sort(array);
		
		consoleView.showArrangedArray(array);
		
		consoleView.showCompareCount(bubbleSort.counter.getCompareCounter());
		consoleView.showChangeCount(bubbleSort.counter.getChangeCounter());
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		
		consoleView.showHeapSort();
		consoleView.showDerangedArray(array);
		
		heapSort.sort(array);
		
		consoleView.showArrangedArray(array);
		
		consoleView.showCompareCount(heapSort.counter.getCompareCounter());
		consoleView.showChangeCount(heapSort.counter.getChangeCounter());
	}

}
