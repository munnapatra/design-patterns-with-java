package com.mkp.dp.structural;

public class AdapterPatternDemo {
	public static void main(String[] args) {
		AppleCharger charger = new ChargerAdapter(new AndroidCharger());
		IphoneMobile imobile = new IphoneMobile(charger);
		imobile.charge();
	}
}

//Target Interface
interface AppleCharger {
	void charge();
}

//Adaptee
class AndroidCharger {
	public void charge() {
		System.out.println("Charging with Android charger");
	}
}

//Adapter
class ChargerAdapter implements AppleCharger {
	private AndroidCharger androidCharger;

	public ChargerAdapter(AndroidCharger androidCharger) {
		this.androidCharger = androidCharger;
	}

	@Override
	public void charge() {
		androidCharger.charge();
	}
}

//Client Code
class IphoneMobile {
	AppleCharger charger;

	public IphoneMobile(AppleCharger charger) {
		this.charger = charger;
	}

	void charge() {
		charger.charge();
	}
}