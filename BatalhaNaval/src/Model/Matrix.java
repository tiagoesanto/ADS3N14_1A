package Model;

public class Matrix 
{
	
	private int ROWS;
	private int COLUMNS;
	private double[][] matrix;	
	 	 	
	public Matrix (int rows, int columns)
	{
		this.ROWS = rows;
		this.COLUMNS = columns;	
		
		 matrix = new double[ROWS][COLUMNS];
	}
	
	public double[][] getMatrix()
	{
		return this.matrix;
	}

	public int getROWS() 
	{
		return ROWS;
	}

	public int getCOLUMNS() 
	{
		return COLUMNS;
	}
}
