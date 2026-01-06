package com.mkp.dp.structural;

/**
 * provides a simplified, unified interface to a complex set of interfaces or a
 * subsystem, making it easier for clients to interact with the system without
 * understanding its complexity.
 */
public class FacadePatternDemo {
	public static void main(String[] args) {
		Amplifier amp = new Amplifier();
		DVDPlayer dvd = new DVDPlayer();
		Projector projector = new Projector();
		Lights lights = new Lights();

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights);

		homeTheater.watchMovie("Inception");
		homeTheater.endMovie();
	}

}

//complex sub system classes
class Amplifier {
	public void on() {
		System.out.println("Amplifier on");
	}

	public void setVolume(int level) {
		System.out.println("Amplifier setting volume to " + level);
	}
}

class DVDPlayer {
	public void on() {
		System.out.println("DVD Player on");
	}

	public void play(String movie) {
		System.out.println("DVD Player playing " + movie);
	}
}

class Projector {
	public void on() {
		System.out.println("Projector on");
	}

	public void wideScreenMode() {
		System.out.println("Projector in widescreen mode");
	}
}

class Lights {
	public void dim(int level) {
		System.out.println("Lights dimming to " + level + "%");
	}
}

//facade class

class HomeTheaterFacade {
	private Amplifier amp;
	private DVDPlayer dvd;
	private Projector projector;
	private Lights lights;

	public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
		this.amp = amp;
		this.dvd = dvd;
		this.projector = projector;
		this.lights = lights;
	}

	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		lights.dim(10);
		projector.on();
		projector.wideScreenMode();
		amp.on();
		amp.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}

	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		lights.dim(100);
		projector.on();
		amp.setVolume(0);
		// additional shutdown logic
	}
}
