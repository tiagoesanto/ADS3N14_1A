package View;

public class ConsoleView
{
	public void showBubbleSort()
	{
		System.out.println("Bubble Sort: ");
	}
	
	public void showHeapSort()
	{
		System.out.println("Heap Sort: ");
	}
	
	public void showDerangedArray(int[] array)
	{
		System.out.println("Array Desordenado:");
		
		for (int i = 0; i < array.length; i++) 
		{	
			System.out.print(array[i] + "  ");
		}
	}
	
	public void showArrangedArray(int[] array)
	{
		System.out.println("\nArray Ordenado:");
		
		for (int i = 0; i < array.length; i++) 
		{			
			System.out.print(array[i] + "  ");
		}

	}
	
	public void showCompareCount(int compareCount)
	{
		System.out.println("\nNumero de Comparações: " + compareCount);
	}
	
	public void showChangeCount(int changeCount)
	{
		System.out.println("Numero de Trocas: " + changeCount + "\n");
	}

}
