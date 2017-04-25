import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class NetworkConnector {
	
	private ServerSocket serverSocket;
	private DataOutputStream outputStream;
	private DataInputStream inputStream;
	private TV tv;
	
	public void send(String data){
		
	}
	public void receive() throws IOException{
		try {
            	System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            	Socket server = serverSocket.accept();
            	System.out.println("Just connected to " + server.getRemoteSocketAddress());
            	inputStream = new DataInputStream(server.getInputStream());
            	System.out.println(inputStream);
			}catch(SocketTimeoutException s){
				System.out.println("Socket timed out!");
	        }catch(IOException e) {
	            e.printStackTrace();
	        }
            
	}
	
}
