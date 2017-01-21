package minigame;
import fhfl.miniGame.engine.*;



public class MyMiniGame extends MiniGame
{
    private Sprite computerSymbol = createSprite(64, 64);
    private Sprite playerSymbol = createSprite(64, 64);
    private Sprite[] coins = createSprites(50, 50, 10);    
    private int playerPos = 0;
    private int computerPos = 0;
    private int MAX_POS = 9;
    private int playerscore;
    private int computerscore;
    private int difficulty;
    private Sprite[] kugelPlayer = createSprites(50, 50, 255);
    private Sprite[] kugelComputer = createSprites(50, 50, 255);
    private Sprite levelExtraShooter = createSprite(50, 50);
    private int kugelnr;
    private int computerkugelnr;
	
	
	public MyMiniGame() 
	{
		getBackgroundPicture().paintImage("Spielhintergrund.png");
	        
	   computerSymbol.paintImage("ghost.png");
	   playerSymbol.paintImage("pacman.png");
	   coins[0].paintImage("coin.png");
	   kugelPlayer[0].paintImage("kugel.png");
	   kugelComputer[0].paintImage("kugelcomputer.png");
	   levelExtraShooter.paintImage("levelExtraShooter1.png"); 
	}

	@Override
	protected void initGame()
	{
		 	playerscore = 0;
	        computerscore = 0;
	        kugelnr = 0;
	       
	        getBackgroundPicture().fill(255, 255, 0);
	        
	        for (int i = 0; i < coins.length; i++)
	        {
	            coins[i].setPosition(205, i * 60);
	        }
	        
	        setPlayerSymbolPositions();
	        setComputerSymbolPositions();
	}

		

	
	@Override
	protected void gameHasStarted()
	{
		// TODO Auto-generated method stub
		
		for(int i=0; i<coins.length; i++ )
		{
			if(getRandomNr(1, 2)==1)
			{
				coins[i].animateTo(640, coins[i].getYPosition(), getRandomNr(5000, 15000));
			}
			
			else
			{
				coins[i].animateTo(-50, coins[i].getYPosition(), getRandomNr(5000, 15000));
			}			
		}
		
        levelExtraShooter.setPosition(300,140);
        levelExtraShooter.animate(0, 300);
	}
	

	@Override
	protected void gameHasFinished()
	{
		 getBackgroundPicture().fill(0, 200, 0);
	        for (int i = 0; i < kugelPlayer.length; i++)
	        {
	            kugelPlayer[i].dontShow(); //wieso dont show?
	        }
	        
	        for (int i = 0; i < kugelComputer.length; i++)
	        {
	            kugelComputer[i].dontShow();  
	        }
		
			for(Sprite coin: coins) 
			{
		        coin.stopAnimation();
		        coin.dontShow();    
			}
	        
	        
	        
	  	  levelExtraShooter.stopAnimation();
	      levelExtraShooter.dontShow();  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}


	
	
	@Override
	protected void playerMove(Action action)
	{
		switch (action)
		{
			case GO:
				kugelPlayer[kugelnr].setPosition(playerSymbol.getXPosition(), playerSymbol.getYPosition());
				kugelPlayer[kugelnr].animate(-500, 0);
				kugelnr++;
				if(kugelnr>200)
					kugelnr = 0;
				setPlayerSymbolPositions();
				break;
				
			case DOWN:
				playerPos = (playerPos+1) % MAX_POS;
				setPlayerSymbolPositions();
				break;
				
			case UP:
				playerPos = (MAX_POS + playerPos -1) % MAX_POS;
				setPlayerSymbolPositions();
				break;
				
			default:
				break;
	}
		
		
		
    }

	@Override
	protected void computerMove(Action action)
	{
		switch (action)
		{
			case GO:
			kugelComputer[computerkugelnr].setPosition(computerSymbol.getXPosition(), computerSymbol.getYPosition());	
			kugelComputer[computerkugelnr].animate(500, 0);
			kugelnr++;
			
			if(kugelnr>200) //dann ist sie ausserhalb, deshalb wieder ab Null
				kugelnr = 0;
			setComputerSymbolPositions();
			break;
			
			case DOWN:
				computerPos = (computerPos + 1) % MAX_POS;
				setComputerSymbolPositions();
				break;
				
			case UP:
				computerPos = (MAX_POS + computerPos - 1) % MAX_POS;
				setComputerSymbolPositions();
				break;
				
			default:
			break;
		}
	}
	
	
	@Override
	protected void gameUpdate() //Kollisionserkennung
	{
	for(int i = 0; i<coins.length; i++)
	{
		if (coins[i].overlapsSprite(playerSymbol))
		{
			coins[i].setPosition(coins[i].getXPosition(), coins[i].getYPosition() - playerSymbol.getHeight());
			coins[i].animateTo(coins[i].getXPosition(), -64, 1000);
			playAudio("ping.wav");
			playerscore++;
		}
		
		
		if(coins[i].overlapsSprite(computerSymbol))
		{
			coins[i].setPosition(coins[i].getXPosition(), coins[i].getYPosition()-playerSymbol.getHeight());
			coins[i].animateTo(coins[i].getXPosition(), -64, 1000);
			playAudio("ping.wav");
			computerscore++;
		}
	
	}
	
	
	for(int i=0; i<kugelPlayer.length; i++)
	{
		if(kugelPlayer[i].overlapsSprite(levelExtraShooter))
		{
			playerscore=playerscore+2;
			kugelPlayer[i].dontShow();
		}
	}
	
	
	for(int i=0; i<kugelComputer.length; i++)
	{
		if(kugelComputer[i].overlapsSprite(levelExtraShooter))
		{
			computerscore = computerscore+2;
			kugelComputer[i].dontShow();
		}
	}
	
	
	
	
	

	@Override
	public int getNrOfPlayerGoActionsMax(int difficulty)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNrofComputerGoActions(int difficulty)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentComputerScore()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentPlayerScore()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
    
	private void setPlayerSymbolPositions() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void setComputerSymbolPositions() {
		playerSymbol.animateTo(550, playerPos * 60 + 60, 300);
		
	}

}
