package Model;

public class GameBoard 
{
	private Matrix gameBoard;
	
	public GameBoard()
	{
		this.gameBoard = new Matrix(9, 9);
	}

	public void displaceShips()
	{
		for (int i = 0; i < 9; i++) 
		{			
			for (int j = 0; j < 9; j++) 
			{
				gameBoard.setPosition(i, j, Math.random());
			}
		}
		
		for (int x = 0; x < gameBoard.getMatrix().length; x++) 
		{
			System.out.println();
			for (int y = 0; y < gameBoard.getMatrix()[x].length; y++) 
			{
			System.out.print("\t" + gameBoard.getMatrix()[x][y]);
			}
		}
	}
}
