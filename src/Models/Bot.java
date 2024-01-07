package Models;

import Exceptions.BotPlayingStrategyNotfound;
import Factories.BotPlayingStrategyCreator;
import Strategies.BotPlayingStrategies.BotPlayingStrategy;

public class Bot extends Player {
	DifficultyLevel difficultyLevel;
	BotPlayingStrategy botPlayingStrategy;

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
	
	
	public BotPlayingStrategy getBotPlayingStrategy() {
		return botPlayingStrategy;
	}

	public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
		this.botPlayingStrategy = botPlayingStrategy;
	}

	public Bot(Character sym,  int dl )
	{
		super("BOT",sym, PlayerType.BOT);
		setDifficultyLevel(getDifficultyLevelFromInt(dl));
//		System.out.println(this.difficultyLevel);
		setBotPlayingStrategy(BotPlayingStrategyCreator.getBotPlayingStrategy(this.difficultyLevel));
	}
	
	private DifficultyLevel getDifficultyLevelFromInt(int dl) {
		for (DifficultyLevel d : DifficultyLevel.values())
		{
			if (d.getDifficultylevel() == dl)
				return d;
		}
		return null;
	}
	
	@Override
	public Move decideMove(Board board) throws BotPlayingStrategyNotfound {
		
		if (botPlayingStrategy == null) 
			throw new BotPlayingStrategyNotfound("No strategy set for Bot Playing!!");
			
		return new Move(botPlayingStrategy.decideCell(board),this);
	}


	
}
