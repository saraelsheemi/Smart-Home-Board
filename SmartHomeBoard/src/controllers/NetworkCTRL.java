package controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkCTRL {
	private Socket socket ;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	//String command;
	int port;
	
	public NetworkCTRL(int port){
		this.port= port;
	}
	public void sendData(String data) throws UnknownHostException, IOException{
		socket = new Socket("localhost", port);
		outputStream = new DataOutputStream(socket.getOutputStream());
		outputStream.writeBytes(data);
	}
	public String receieveData() throws UnknownHostException, IOException{
		socket = new Socket("localhost", port);
		inputStream = new DataInputStream(socket.getInputStream());
		String ack = inputStream.readUTF();
		System.out.println(ack);
		return ack;
	}
	public static void main(String args[]) throws IOException, InterruptedException{
		NetworkCTRL c = new NetworkCTRL(6678);
		c.sendData("turn on");
		c.wait();
	}

}
