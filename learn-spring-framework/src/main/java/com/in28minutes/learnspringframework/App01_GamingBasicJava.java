package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01_GamingBasicJava {

	public static void main(String[] args) {
		var game= new PacmanGame(); // 1: Object Creation
		
		var gameRunner= new GameRunner(game); 
			// 2: Object Creation + Wiring of Dependencies(의존성 연결)
			// Game is a Dependency of GameRunner 
		
		gameRunner.run();
	}

}
