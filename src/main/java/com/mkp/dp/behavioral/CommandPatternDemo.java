package com.mkp.dp.behavioral;

/**
 * This design decouples the object that invokes the operation from the one that
 * knows how to perform it, allowing dynamic command switching, queuing
 * commands, or undo functionality.
 */
public class CommandPatternDemo {
	public static void main(String[] args) {
		Light livingRoomLight = new Light();

		// Create commands
		Command lightsOn = new TurnOnLightCommand(livingRoomLight);
		Command lightsOff = new TurnOffLightCommand(livingRoomLight);

		// Create invoker
		RemoteControl remote = new RemoteControl();

		// Execute commands
		remote.setCommand(lightsOn);
		remote.pressButton(); // Output: Light is turned ON

		remote.setCommand(lightsOff);
		remote.pressButton(); // Output: Light is turned OFF
	}

}

//Command interface
interface Command {
	void execute();
}

//Receiver class - the actual object that performs actions
class Light {
	public void turnOn() {
		System.out.println("Light is turned ON");
	}

	public void turnOff() {
		System.out.println("Light is turned OFF");
	}
}

//Concrete Command to turn the light ON
class TurnOnLightCommand implements Command {
	private Light light;

	public TurnOnLightCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}
}

//Concrete Command to turn the light OFF
class TurnOffLightCommand implements Command {
	private Light light;

	public TurnOffLightCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
}

//Invoker - asks the command to carry out the request
class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}
