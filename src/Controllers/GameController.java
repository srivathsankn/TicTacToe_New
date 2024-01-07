package Controllers;

import Exceptions.WinningStrategyNotFound;
import Models.Board;
import Models.CellStatus;
import Models.Game;
import Models.GameStatus;
import Models.Move;
import Models.Player;
import Strategies.WinningStrategies.OrderOneWinningStrategy;

public class GameController {

	public void startGame(Game game) {
		game.setStatus(GameStatus.IN_PROGRESS);
	}

	public GameStatus getGameStatus(Game game) {
		return game.getStatus();
	}

	public void displayBoard(Game game) {
		game.showBoard();
	}

	public Player getNextPlayer(Game game) {
		return game.getPlayers().get(game.getNextToPlay());
	}

	public Board getBoard(Game game) {
		return game.getBoard();
	}

	public void executeMove(Game game, Move nextMove) {
		game.getBoard().getCells().get(nextMove.getCell().getRow()).get(nextMove.getCell().getCol()).setPlayer(nextMove.getPlayer());
		game.getBoard().getCells().get(nextMove.getCell().getRow()).get(nextMove.getCell().getCol()).setStatus(CellStatus.FILLED);
	}

	public boolean checkWin(Game game, Move move) throws WinningStrategyNotFound {
		if (game.getWinningStrategy() == null)
		{
			throw new WinningStrategyNotFound("No Winning Strategy found!!! Please check.");
		}
		if (game.getWinningStrategy().getWinner(game.getBoard(), move) != null)
			return true;
		
		return false;
		
	}

	public void setWinningStrategy(Game game, OrderOneWinningStrategy orderOneWinningStrategy) {
		game.setWinningStrategy(orderOneWinningStrategy);
	}

	public boolean checkDraw(Game game) {
		
		for (int i=0; i<game.getBoard().getCells().size(); i++)
		{
			for (int j=0; j<game.getBoard().getCells().size(); j++)
			{
				if (game.getBoard().getCells().get(i).get(j).getStatus() == CellStatus.EMPTY)
					return false;
			}
		}
		
		return true;
	}
	
}
