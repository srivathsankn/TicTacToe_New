package Factories;

import Models.DifficultyLevel;
import Strategies.BotPlayingStrategies.BotPlayingStrategy;
import Strategies.BotPlayingStrategies.EasyPlayingStrategy;

public class BotPlayingStrategyCreator {
	public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel)
	{
		if (difficultyLevel == DifficultyLevel.EASY)
			return new EasyPlayingStrategy();
		
		return new EasyPlayingStrategy(); // Default strategy....
	}
}

