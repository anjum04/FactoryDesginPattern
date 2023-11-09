package LLDSnakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	Cell [][] cells;
	
	Board(int boardSize, int numOfSnake,int numOfLadder)
	{
		initializeCells(boardSize);
		addSnakesLadders(boardSize,numOfSnake,numOfLadder);
		
	}
	private void initializeCells(int boardSize)
	{
		cells = new Cell[boardSize][boardSize];
		for(int i=0;i<boardSize;i++)
		{
			for(int j=0;j<boardSize;j++)
			{
				Cell cellobj = new Cell();
				cells[i][j]=cellobj;
			}
		}
	}
	void addSnakesLadders(int boardSize, int numOfSnake,int numOfLadder)
	{  
		while(numOfSnake>0)
		{
			int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			if(snakeHead<=snakeTail)
				continue;
			
			Jump snakeObj = new Jump();
	        snakeObj.start = snakeHead;
	        snakeObj.end = snakeTail;

	        Cell cell = getCell(snakeHead);
	        cell.jump = snakeObj;

	         numOfSnake--;	
		}
		while(numOfLadder>0)
		{
			int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
			if(ladderEnd<=ladderStart)
				continue;
			
			Jump ladderObj = new Jump();
	        ladderObj.start = ladderStart ;
	        ladderObj.end =   ladderEnd;

	        Cell cell = getCell(ladderStart);
	        cell.jump = ladderObj;

	        numOfLadder--;	
			
		}
	}
	public Cell getCell(int playerPosition)
	{
		int boardRow   = (playerPosition/cells.length);
		int boardColumn= (playerPosition%cells.length);
		return cells[boardRow][boardColumn];
	}

}
