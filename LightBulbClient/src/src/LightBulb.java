package src;


import java.io.IOException;
import java.net.UnknownHostException;

import com.sun.java.swing.plaf.windows.resources.windows;


public class LightBulb {

	private final String ip = "localhost";
	private final int port = 5080;
	private final String deviceName = "Chandelier";
	private int id;
	private final String serialNumber = "12345";
	private boolean status = true;
	private static LightBulb thisLightBulb;

	public LightBulb() {
		thisLightBulb = this;
	}

	public int getId() {
		return id;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static LightBulb getThisLightBulb() {
		return thisLightBulb;
	}
	
	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void initializeIntrepreter(Interpreter i) {
		i = new Interpreter(this);
	}

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String message;
		String response;
		Registeration r = new Registeration();
		System.out.println(r.register());
		NetworkConnector n = new NetworkConnector();
		while (true) {
			message = n.receive();
			System.out.println("Recevied command: " + message);
			Interpreter i = new Interpreter(thisLightBulb);
			response = i.interpret(message);
			System.out.println("Light Bulb's status: " + thisLightBulb.isStatus());
			n.send(response);
			n.clean();
		}

	}
}
