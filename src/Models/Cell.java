package Models;

public class Cell {
	private int row;
	private int col;
	private CellStatus status;
	private Player player;
	
	public Cell(int r, int c, CellStatus cs, Player player)
	{
		setRow(r);
		setCol(c);
		setStatus(cs);
		setPlayer(player);
	}
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public CellStatus getStatus() {
		return status;
	}
	public void setStatus(CellStatus status) {
		this.status = status;
	}
	public Player getPlayer() {
		return this.player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

}
