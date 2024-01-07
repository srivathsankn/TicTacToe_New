package Gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controllers.GameController;
import Exceptions.BotPlayingStrategyNotfound;
import Exceptions.WinningStrategyNotFound;
import Models.Bot;
import Models.Game;
import Models.GameStatus;
import Models.Human;
import Models.Move;
import Models.Player;
import Strategies.WinningStrategies.OrderOneWinningStrategy;

public class GamePlay {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of the Board");
		int boardSize = s.nextInt();
		
		System.out.println("Enter the number of Players");
		int playersCount = s.nextInt();
		
		System.out.println("Is there a bot (Y/N)?");
		String isThereABot = s.next();
		
		List<Player> players = new ArrayList<Player>();
		
		int humanPlayers = playersCount;
		if (isThereABot.equalsIgnoreCase("Y"))
		{
			System.out.println("What is the difficulty level for the Bot(1-EASY, 2-MEDIUM, 3-HARD)?");
			int diffLevel = s.nextInt();
			System.out.println("Please enter the symbol for Bot");
			Character sym = s.next().charAt(0);
			players.add(new Bot(sym, diffLevel));
			humanPlayers--;
		}
		
		for (int i=1; i<=humanPlayers; i++)
		{
			System.out.println("Enter the name of Human Player "+ i);
			String name = s.next();
			System.out.println("Enter the email of Human Player "+ i);
			String email = s.next();
			System.out.println("Please enter the symbol for Human Player "+ i);
			Character sym = s.next().charAt(0);
			players.add(new Human(name, email, sym));
		}
		
		Game game = Game.getBuilder().setDimension(boardSize).setPlayers(players).build();

		GameController gameController = new GameController();
		gameController.setWinningStrategy(game, new OrderOneWinningStrategy(boardSize));
		gameController.startGame(game);
		
		
		while (gameController.getGameStatus(game) == GameStatus.IN_PROGRESS)
		{
			gameController.displayBoard(game);
			System.out.println("It is the turn of " + gameController.getNextPlayer(game).getName());
			Move nextMove = null;
			try {
				nextMove = gameController.getNextPlayer(game).decideMove(gameController.getBoard(game));
				gameController.executeMove(game, nextMove);
			}
			catch(BotPlayingStrategyNotfound e)
			{
				System.out.println(e.getMessage());
			}

			
			boolean isWin;
			try {
				isWin = gameController.checkWin(game, nextMove);
			}
			catch (WinningStrategyNotFound e)
			{
				System.out.println(e.getMessage());
				break;
			}
			
			if (isWin)
			{
				System.out.println(nextMove.getPlayer().getName() + " is the Winner. Congrats!!");
				game.setStatus(GameStatus.WIN);
				break;
			}
			
			boolean isDraw = gameController.checkDraw(game);
			
			if (isDraw)
			{
				System.out.println("Match ended in draw!!!");
				break;
			}
			game.setNextToPlay((game.getNextToPlay() + 1)%game.getPlayers().size());
		}
		
	}

}
