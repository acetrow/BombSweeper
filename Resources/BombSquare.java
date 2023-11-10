import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private boolean isClicked = false;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public void clicked()
	{
		//a bolean to check if the square has been clicked already
		if (isClicked) 
		{
            return; 
        }

        isClicked = true;

		if ((thisSquareHasBomb) == true)
		{
			setImage("images/bomb.png");
		}
		else 
		{
			//check how many bombs detected
			int bombTotal = checkBomb();

			if (bombTotal > 0) {
				//set image as number of surrounding bombs
				setImage("images/" + bombTotal + ".png");
			} 
			else 
			{
				setImage("images/0.png");
				checkSpace();
			}
		}
	}

	private int checkBomb()
	{
		int bombNumber = 0;

		int[][] coordinate ={	{-1, 1}, {0,1}, {1, 1},
								{-1, 0}, 		{1,0},
								{-1,-1}, {0,-1},{1,-1}
							};

		for (int i = 0; i < coordinate.length; i++){
			
			//declaring every single element in the array (coordinate fom the clicked) as xChange and yChange
			int xChange = coordinate[i][0];
        	int yChange = coordinate[i][1];
			
			//adding the change to determine position of neighboring squares relative to the current square
        	int x = xLocation + xChange;
        	int y = yLocation + yChange;		

			//return a GameSquare object
			//casting operation - treat results as a BombSquare object
			//otherwise, return= error: incompatible types: GameSquare cannot be converted to BombSquare
			BombSquare surrounding = (BombSquare) board.getSquareAt(x, y);

			if (surrounding != null && surrounding.thisSquareHasBomb) 
			{
				bombNumber++;
			}
		}

		return bombNumber;
		
	}

	private void checkSpace()
	{

		int[][] coordinate ={	{-1, 1}, {0,1}, {1, 1},
								{-1, 0}, 		{1,0},
								{-1,-1}, {0,-1},{1,-1}
							};

		for (int i = 0; i < coordinate.length; i++)
		{
			
			//declaring every single element in the array (coordinate fom the clicked) as xChange and yChange
			int xChange = coordinate[i][0];
        	int yChange = coordinate[i][1];
			
			//adding the change to determine position of neighboring squares relative to the current square
        	int x = xLocation + xChange;
        	int y = yLocation + yChange;		

			//square (variable GameSquare) is initialized as getSquareAt() results
			GameSquare square = board.getSquareAt(x, y);

			//if not out of board
            if (square != null) 
			{
				//square variable is cast to a BombSquare object
				//assigned to variable surrounding
				//allows access to BombSquare methods and properties on the surrounding object
                BombSquare surrounding = (BombSquare) board.getSquareAt(x, y);
				//check if the surrounding is already clicked or not containing bomb
                if (!surrounding.isClicked && !surrounding.thisSquareHasBomb) 
				{
					//click the square
                    surrounding.clicked();
                }
            }

			
			
		}

	}
}
