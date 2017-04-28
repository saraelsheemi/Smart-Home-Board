import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NetworkConnector {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream outputStream;
	private DataInputStream inputStream;
	private TV tv;
	
	public void send(String data) throws UnknownHostException, IOException{
		socket=new Socket(serverSocket.getInetAddress(),tv.getPort());
		DataOutputStream dataout=new DataOutputStream(socket.getOutputStream());  
		dataout.writeUTF(data);  
		dataout.flush();  
		dataout.close();  
		socket.close(); 
	}
	public String receive() throws IOException{
		try {
			serverSocket = new ServerSocket(tv.getPort());
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            socket = serverSocket.accept();
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            inputStream = new DataInputStream(socket.getInputStream());
            System.out.println("recevied command :" + inputStream);
		}catch(SocketTimeoutException s){
			System.out.println("Socket timed out!");
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
		return inputStream.toString();  
	}
	
}
