package com.mkp.dp.behavioral;

/**
 * A behavioral design pattern that defines the skeleton of an algorithm in an
 * abstract class but lets subclasses override specific steps without changing
 * the overall algorithm structure.
 */
public class TemplatePatternDemo {
	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();

		System.out.println();

		game = new Football();
		game.play();
	}
}

abstract class Game {
	// Template method, final so subclasses can't override
	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}

	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();
}

class Cricket extends Game {
	@Override
	void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("Cricket Game Finished!");
	}
}

class Football extends Game {
	@Override
	void initialize() {
		System.out.println("Football Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Football Game Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		System.out.println("Football Game Finished!");
	}
}
