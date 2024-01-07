package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<List<Cell>> cells;

	public Board(int dimension) {
		List<List<Cell>> cells = new ArrayList<>();
		for (int i=0; i<dimension; i++)
		{	cells.add(new ArrayList<>());
			for (int j=0; j<dimension; j++)
			{
				cells.get(i).add(new Cell(i,j,CellStatus.EMPTY,null));
			}
		}
		this.cells = cells;
	}

	public List<List<Cell>> getCells() {
		return cells;
	}

	public void setCells(List<List<Cell>> cells) {
		this.cells = cells;
	}
	
}
