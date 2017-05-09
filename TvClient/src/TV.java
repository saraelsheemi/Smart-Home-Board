package src;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * 
 */

/**
 * @author joe
 *
 */
public class TV {
	private final String ip = "localhost";
	private final int port = 6678;
	private final String deviceName = "Smart TV";
	private int id;
	private final String serialNumber = "1352865";
	private boolean status = true;
	private static TV thisTV;

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws ClassNotFoundException
	 */
	public TV() {
		thisTV = this;
	}
	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	public void initializeIntrepreter(Intrepreter i){
		i = new Intrepreter(this);
	}
	public static void main(String[] args) throws UnknownHostException, IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		String message;
		String response;
		Registeration r = new Registeration();
		System.out.println(r.register());
		NetworkConnector n = new NetworkConnector();
		while (true) {
			message = n.receive();
			System.out.println("recevied command: " + message);
			Intrepreter i = new Intrepreter(thisTV);
			response = i.intrepret(message);
			System.out.println("TV status: "+thisTV.isStatus());
			n.send(response);
			n.clean();
		}
	}
}
