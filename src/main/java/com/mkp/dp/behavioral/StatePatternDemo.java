package com.mkp.dp.behavioral;

/**
 * The State Pattern allows an object to change its behavior when its internal
 * state changes. The object will appear to change its class, enabling more
 * straightforward management of state transitions
 */
public class StatePatternDemo {
	public static void main(String[] args) {
		MediaPlayer mediaPlayer = new MediaPlayer();

		// Trying different actions
		mediaPlayer.play(); // Starting playback...
		mediaPlayer.pause(); // Pausing...
		mediaPlayer.play(); // Resuming...
		mediaPlayer.stop(); // Stopping...
		mediaPlayer.stop(); // Already stopped.
		mediaPlayer.pause(); // Can't pause, media is stopped.
	}

}

//State interface
interface State {
	void play(MediaPlayer player);

	void pause(MediaPlayer player);

	void stop(MediaPlayer player);
}

// Concrete states
class PlayingState implements State {
	public void play(MediaPlayer player) {
		System.out.println("Already playing.");
	}

	public void pause(MediaPlayer player) {
		System.out.println("Pausing...");
		player.setState(new PausedState());
	}

	public void stop(MediaPlayer player) {
		System.out.println("Stopping...");
		player.setState(new StoppedState());
	}
}

class PausedState implements State {
	public void play(MediaPlayer player) {
		System.out.println("Resuming...");
		player.setState(new PlayingState());
	}

	public void pause(MediaPlayer player) {
		System.out.println("Already paused.");
	}

	public void stop(MediaPlayer player) {
		System.out.println("Stopping...");
		player.setState(new StoppedState());
	}
}

class StoppedState implements State {
	public void play(MediaPlayer player) {
		System.out.println("Starting playback...");
		player.setState(new PlayingState());
	}

	public void pause(MediaPlayer player) {
		System.out.println("Can't pause. Media is stopped.");
	}

	public void stop(MediaPlayer player) {
		System.out.println("Already stopped.");
	}
}

//Context
class MediaPlayer {
	private State state;

	public MediaPlayer() {
		state = new StoppedState(); // Initial state
	}

	public void setState(State state) {
		this.state = state;
	}

	public void play() {
		state.play(this);
	}

	public void pause() {
		state.pause(this);
	}

	public void stop() {
		state.stop(this);
	}
}