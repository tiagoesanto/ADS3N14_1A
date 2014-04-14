package Controller;

import Model.Counter;

public class HeapSort 
{
	public Counter counter;
	int changeCounter;
	int compareCounter;
	
	public HeapSort()
	{
		changeCounter = 0;
		compareCounter = 0;
		counter = new Counter();
	}
	
	public void sort(int[] array)
	{	
		heapify(array);
		
		int end =  array.length - 1;	
		
		while (end > 0)
		{
			swap(array, end, 0);
			
			end--;
			
			siftDown(array, 0, end);
		}
		
		counter.setChangeCounter(changeCounter);
		counter.setCompareCounter(compareCounter);
	}

	private void heapify(int[] array) 
	{
		int start = ((array.length - 2) / 2);
		
		while (start >= 0)
		{
			siftDown(array, start, (array.length -1));
			
			start--;
		}
	}
	
	private void siftDown(int[] array, int start, int end) 
	{
		int root = start;
		
		while ((root * 2 + 1) <= end)
		{
			int child = root * 2 + 1;
			int swap = root;

			if (array[swap] < array[child])
			{
				swap = child;
				this.compareCounter++;
			}
			if ((child + 1) <= end && array[swap] < array[child + 1])
			{
				swap = child + 1;
				this.compareCounter++;
			}
			if (swap != root)
			{
				swap(array, root, swap);
				root = swap;
				changeCounter++;
			}
			else
				break;
		}
		
	}

	private void swap(int[] array, int i, int j) 
	{
		int swappingAuxiliar = array[i];
		array[i] = array[j];
		array[j] = swappingAuxiliar;
	}
			
}
