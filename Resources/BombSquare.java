import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public void clicked()
	{
		if ((thisSquareHasBomb) == true)
		{
			setImage("images/bomb.png");
		}
	}

	public void checkBomb()
	{
		int bombNumber = 0;

		int[][] coordinate ={	{-1, 1}, {0,1}, {1, 1},
								{-1, 0}, {0,0}, {1,0},
								{-1,-1}, {0,-1}, {1,-1}
							};

		for (int i = 0; i < coordinate.length; i++){

		}
		
	}
}
