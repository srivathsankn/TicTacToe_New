package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Cell;
import Models.Move;

public interface BotPlayingStrategy {
	public Cell decideCell(Board board);
	
}
