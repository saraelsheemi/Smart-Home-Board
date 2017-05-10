package src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NetworkConnector {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private LightBulb lightBulb = new LightBulb();
	
	public void send(String data) throws UnknownHostException, IOException{
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.writeObject(data);
	}
	public String receive() throws IOException, ClassNotFoundException{
		String command = new String();
		try {
			serverSocket = new ServerSocket(lightBulb.getPort());
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            inputStream = new ObjectInputStream(socket.getInputStream());
            command = (String) inputStream.readObject();
		}catch(SocketTimeoutException s){
			System.out.println("Socket timed out!");
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
		return command;  
	}
	public void clean() throws IOException{
		socket.close();
		serverSocket.close();
		outputStream.close();
		inputStream.close();
	}
	
}

