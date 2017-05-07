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

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws ClassNotFoundException 
	 */
	public TV(){}
	public static void main(String[] args) throws UnknownHostException,
			IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Registeration r = new Registeration();
		System.out.println(r.register());
		NetworkConnector n = new NetworkConnector();
			String message = n.receive();
			System.out.println("recevied command: " + message);
			n.send("ack");
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}
}
