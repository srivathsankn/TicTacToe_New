package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Cell;
import Models.CellStatus;
import Models.Move;

public class EasyPlayingStrategy implements BotPlayingStrategy {

	@Override
	public Cell decideCell(Board board) {
		
		int dimension = board.getCells().size();
		for (int i=0; i<dimension; i++)
		{
			for (int j=0; j<dimension; j++)
			{
				if (board.getCells().get(i).get(j).getStatus() == CellStatus.EMPTY)
				{
					return board.getCells().get(i).get(j);
				}
			}
		}
		return null;
	}

}
