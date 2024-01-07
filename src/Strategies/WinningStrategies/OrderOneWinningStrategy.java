package Strategies.WinningStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Models.Board;
import Models.Move;
import Models.Player;

public class OrderOneWinningStrategy implements WinningStrategy {
	
	private List<HashMap<Character,Integer>> rowCounts;
	private List<HashMap<Character,Integer>> colCounts;
	private HashMap<Character,Integer> ldiagCounts;
	private HashMap<Character,Integer> rdiagCounts;
	int dimension;
	
	public OrderOneWinningStrategy(int dim)
	{	
		dimension = dim;
		rowCounts = new ArrayList<>();
		colCounts = new ArrayList<>();
		ldiagCounts = new HashMap<>();
		rdiagCounts = new HashMap<>();
		
		for (int i=0; i<dim; i++)
		{
			rowCounts.add(new HashMap<>());
			colCounts.add(new HashMap<>());
		}
		
	}
	
	@Override
	public Player getWinner(Board board, Move move) {
		
		Character symbol = move.getPlayer().getSymbol();
		
		HashMap<Character,Integer> rowMap = rowCounts.get(move.getCell().getRow());
		rowMap.put(symbol, rowMap.getOrDefault(symbol, 0)+1);
		
		HashMap<Character,Integer> colMap = colCounts.get(move.getCell().getCol());
		colMap.put(symbol, colMap.getOrDefault(symbol, 0)+1);
		
		if ((rowCounts.get(move.getCell().getRow()).get(symbol) == dimension ) ||
			(colCounts.get(move.getCell().getCol()).get(symbol) == dimension ))
			return move.getPlayer();
		
		if (move.getCell().getRow()==move.getCell().getCol())
		{
			ldiagCounts.put(symbol, ldiagCounts.getOrDefault(symbol, 0)+1);
			if (ldiagCounts.get(symbol) == dimension)
				return move.getPlayer();
		}
		
		if (move.getCell().getRow() + move.getCell().getCol() == this.dimension-1)
		{
			rdiagCounts.put(symbol, rdiagCounts.getOrDefault(symbol, 0)+1);
			if (rdiagCounts.get(symbol) == dimension)
				return move.getPlayer();
		}
			
		return null;
	}

}
