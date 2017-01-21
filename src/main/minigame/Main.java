package minigame;

import fhfl.miniGame.engine.MiniGame;
import fhfl.miniGame.io.IOFactory;

/**
 * This class is used to start a {@link MiniGame}. There is no need to edit this file. If you want to debug you project you can use this file as starting point.
 * 
 */
public class Main
{
	public static void main(String[] args)
	{
		// Create a new player with the given game.
		IOFactory.getDefaultIOFactory().getMiniGamePlayer(new MyMiniGame());
	}
}
