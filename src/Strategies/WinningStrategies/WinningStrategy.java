package Strategies.WinningStrategies;

import Models.Board;
import Models.Move;
import Models.Player;

public interface WinningStrategy {
	public Player getWinner(Board board, Move move);
}
