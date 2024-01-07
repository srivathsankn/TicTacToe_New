package Models;

public enum DifficultyLevel {
	EASY(1),
	MEDIUM(2),
	HARD(3);
	
	int difficultylevel;
	private DifficultyLevel(int d)
	{
		this.difficultylevel = d;
	}
	public int getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(int difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	
	
}
