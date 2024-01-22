package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole game;
	
	@Autowired // 생략 가능
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
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
