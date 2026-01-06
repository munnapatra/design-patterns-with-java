package com.mkp.dp.structural;

/**
 * separates an abstraction from its implementation so the two can vary
 * independently. This helps avoid a combinatorial explosion of subclasses when
 * extending functionality in multiple orthogonal dimensions.
 */
public class BridgePatternDemo {
	public static void main(String[] args) {
		Device tv = new TV();
		RemoteControl remote = new RemoteControl(tv);

		remote.turnOn();
		remote.setVolume(10);

		Device radio = new Radio();
		AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

		advancedRemote.turnOn();
		advancedRemote.mute();
	}

}

//Implementor Interface (Device)
interface Device {
	void turnOn();

	void turnOff();

	void setVolume(int volume);
}

//Concrete Implementors (TV, Radio)
class TV implements Device {
	@Override
	public void turnOn() {
		System.out.println("TV turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV turned OFF");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("TV volume set to " + volume);
	}
}

class Radio implements Device {
	@Override
	public void turnOn() {
		System.out.println("Radio turned ON");
	}

	@Override
	public void turnOff() {
		System.out.println("Radio turned OFF");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("Radio volume set to " + volume);
	}
}

// Abstraction (RemoteControl)
class RemoteControl {
	protected Device device;

	public RemoteControl(Device device) {
		this.device = device;
	}

	public void turnOn() {
		device.turnOn();
	}

	public void turnOff() {
		device.turnOff();
	}

	public void setVolume(int volume) {
		device.setVolume(volume);
	}
}

//Refined Abstraction (Advanced Remote)
class AdvancedRemoteControl extends RemoteControl {
	public AdvancedRemoteControl(Device device) {
		super(device);
	}

	public void mute() {
		System.out.println("Muting device");
		setVolume(0);
	}
}
