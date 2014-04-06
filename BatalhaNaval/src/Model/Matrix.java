package Model;

public class Matrix
{
	
	private int ROWS;
	private int COLUMNS;
	private Double[][] matrix;	
		 	
	
	public Matrix (int rows, int columns)
	{
		this.ROWS = rows;
		this.COLUMNS = columns;	
		matrix = new Double[ROWS][COLUMNS];		
	}
	
	public void setPosition(int row, int column, Double insertion)
	{
		matrix[row][column] = insertion;
	}
	
	public Double[][] getMatrix()
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
