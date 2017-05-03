package src;

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
	 */
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Registeration r = new Registeration();
		try{
			r.register();
			NetworkConnector n = new NetworkConnector();
			System.out.println(n.receive());
		}catch(Exception e){
			e.getMessage();
		}
		System.out.println("end of a tv program");
	}
	public String getIp() {
		return ip;
	}
	public int getPort() {
		return port;
	}
}
