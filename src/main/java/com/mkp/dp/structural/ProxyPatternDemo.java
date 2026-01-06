package com.mkp.dp.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * A proxy object acts as a placeholder or intermediary to control access to
 * another object, called the real subject. The proxy can add functionalities
 * like access control, logging, lazy loading, and more, without changing the
 * real object’s code.
 */
public class ProxyPatternDemo {
	public static void main(String[] args) {
		Internet internet = new ProxyInternet();
		try {
			internet.connectTo("example.com"); // Allowed
			internet.connectTo("banned.com"); // Blocked by proxy
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

//Subject Interface
interface Internet {
	void connectTo(String serverHost) throws Exception;
}

//RealSubject
class RealInternet implements Internet {
	@Override
	public void connectTo(String serverHost) {
		System.out.println("Connecting to " + serverHost);
	}
}

//3. Proxy Class
class ProxyInternet implements Internet {
	private RealInternet realInternet = new RealInternet();
	private static List<String> bannedSites = new ArrayList<>();

	static {
		bannedSites.add("banned.com");
		bannedSites.add("blocked.com");
	}

	@Override
	public void connectTo(String serverHost) throws Exception {
		if (bannedSites.contains(serverHost.toLowerCase())) {
			throw new Exception("Access Denied to " + serverHost);
		}
		realInternet.connectTo(serverHost);
	}
}