package Models;

import java.util.Scanner;

public class Human extends Player {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	Human()
	{
		
	}
	
	public Human(String name, String email, Character sym)
	{
		super(name, sym, PlayerType.HUMAN);
		this.email = email;
	}
	
	@Override
	public Move decideMove(Board board) {
		Scanner s = new Scanner(System.in);
		boolean validMove = false;
		while(!validMove)
		{
			System.out.println("Please enter the row and column for next move (seperated by space) - (" + 0 + "-" + (board.getCells().size()-1) + ")" );
			int r = s.nextInt();
			int c = s.nextInt();
			validMove = checkMoveValidity(board,r,c);
			if (validMove) 
				return new Move(board.getCells().get(r).get(c),this);
			else
				System.out.println("Invalid Move!! That cell is already taken !!");
		}  
		return null;
	}
	
	public boolean checkMoveValidity(Board board, int r, int c)
	{
		return (board.getCells().get(r).get(c).getStatus() == CellStatus.EMPTY);
	}
}
