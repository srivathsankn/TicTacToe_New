package Models;

import Exceptions.BotPlayingStrategyNotfound;

public abstract class Player {

	private String name;
	private Character symbol;
	private PlayerType type;
	
	public Player()
	{
		
	}
	
	public Player(String name, Character symbol, PlayerType type) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getSymbol() {
		return symbol;
	}
	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}
	public PlayerType getType() {
		return type;
	}
	public void setType(PlayerType type) {
		this.type = type;
	}

	public abstract Move decideMove(Board board) throws BotPlayingStrategyNotfound;
	
	
	
	
}
