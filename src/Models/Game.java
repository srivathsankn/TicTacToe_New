package Models;

import java.util.ArrayList;
import java.util.List;

import Strategies.WinningStrategies.WinningStrategy;

public class Game {
	private Board board;
	private List<Player> players;
	private int nextToPlay;
	private GameStatus status;
	private List<Move> moves;
	private WinningStrategy winningStrategy;
	
	private Game()
	{
		
	}
	
	private Game(GameBuilder gb)
	{
		// Any Validations required can be here....
		
		//setting details from gameBuilder object
		this.setBoard(new Board(gb.dimension));
		this.setPlayers(gb.players);
		this.setNextToPlay((int)(Math.random() * (gb.players.size()-1) )) ;
		this.setMoves(new ArrayList<>());
		this.setStatus(GameStatus.NOT_STARTED);
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public WinningStrategy getWinningStrategy() {
		return winningStrategy;
	}

	public void setWinningStrategy(WinningStrategy winningStrategy) {
		this.winningStrategy = winningStrategy;
	}

	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public int getNextToPlay() {
		return nextToPlay;
	}
	public void setNextToPlay(int nextToPlay) {
		this.nextToPlay = nextToPlay;
	}
	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	
	public static GameBuilder getBuilder()
	{
		return new GameBuilder();
	}
	
	public static class GameBuilder
	{
		private int dimension;
		private List<Player> players;
		
		public GameBuilder setDimension(int dimension)
		{
			this.dimension = dimension;
			return this;
		}
		
		public GameBuilder setPlayers(List<Player> players)
		{
			this.players = players;
			return this;
		}
		
		public Game build()
		{	
			return new Game(this);
		}
		
	}

	public void showBoard() {
		for (int i=0; i<this.board.getCells().size(); i++)
		{
			for(int j=0; j<this.board.getCells().get(i).size(); j++)
			{
				if (this.board.getCells().get(i).get(j).getStatus() == CellStatus.EMPTY)
					System.out.print("|   |");
				else
				{
					//System.out.println(this.board.getCells().get(i).get(j).getStatus());
					System.out.print("| " + this.board.getCells().get(i).get(j).getPlayer().getSymbol() + " |");
					
				}
	
			}
			System.out.println();
		}
	}
}
