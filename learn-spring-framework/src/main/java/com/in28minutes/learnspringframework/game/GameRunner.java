package com.in28minutes.learnspringframework.game;

public class GameRunner {
	// private MarioGame game;
	private SuperContraGame game;
	
	public GameRunner(SuperContraGame game) {
		this.game= game;
	}

	public void run() {
		System.out.println("Runnung game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
