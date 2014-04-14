package Controller;

import Model.Counter;

public class BubbleSort 
{
	public Counter counter;
	
	public BubbleSort()
	{
		counter = new Counter(); 
	}
	
	public int[] sort(int[] array)
	{
		int swappingAuxiliar = 0;
		int compareCounter = 0;
		int changeCounter = 0;
		
		for(int i = 0; i < array.length; i++)
		{ 
			for(int j = 0; j < (array.length - 1); j++)
			{ 
				if(array[j] > array[j + 1])
				{ 
					swappingAuxiliar = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = swappingAuxiliar; 
					changeCounter++;
				} 
				compareCounter++;
			} 
		}
		
		counter.setChangeCounter(changeCounter);
		counter.setCompareCounter(compareCounter);
		
		return array;
	}
	
}
