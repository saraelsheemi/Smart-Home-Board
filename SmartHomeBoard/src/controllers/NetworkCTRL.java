package controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkCTRL {
	private Socket socket ;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	//String command;
	int port;
	
	public NetworkCTRL(int port){
		this.port= port;
	}
	public void sendData(String data) throws UnknownHostException, IOException{
		socket = new Socket("127.0.0.1", port);
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.writeObject(data);
		System.out.println("message sent: "+ data);
		//outputStream.writeBytes(data);
	}
	public String receieveData() throws UnknownHostException, IOException, ClassNotFoundException{
		inputStream = new ObjectInputStream(socket.getInputStream());
		String ack = (String) inputStream.readObject();
		System.out.println(ack);
		return ack;
	}
	public void clean() throws IOException{
		socket.close();
		outputStream.close();
		inputStream.close();
	}
}
