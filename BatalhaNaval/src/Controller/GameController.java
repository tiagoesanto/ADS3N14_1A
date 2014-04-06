package Controller;

import Model.GameBoard;

public class GameController
{
	private GameBoard board = new GameBoard();
	
	public GameController()
	{
		board.displaceShips();
	}

}
