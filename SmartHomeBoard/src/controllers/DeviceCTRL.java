package controllers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Device;
import dbAccess.DeviceQueries;

public class DeviceCTRL {
	private Device device ;
	public DeviceCTRL() {
	}
	public DeviceCTRL(Device device) {
		this.device = device;
	}
	public void registerDevice() throws SQLException{
		 DeviceQueries query = new DeviceQueries(device);
		 ResultSet result = query.checkExistance();
		 if(!result.next()){
			 query.registerDevice();
		 }
	 }
	public void removeDevice(){
		
	}
	public void addDevice(){
		
	}
	public String sendCommand(String command) throws SQLException, UnknownHostException, IOException{
		DeviceQueries query = new DeviceQueries(device);
		NetworkCTRL network;
		int portNumber;
		ResultSet result = query.getInfo();
		result.next();
		portNumber = Integer.valueOf(result.getString("portNumber"));
		network = new NetworkCTRL(portNumber);
		network.sendData(command);
		return network.receieveData();
	}
	public void enableNotification(){}
	public void disableNotification(){}
	public void pullNotification(){}
	public Device getInfo() throws SQLException{
		DeviceQueries query = new DeviceQueries(device);
		ResultSet result = query.getInfo();
		result.next();
		device.setName(result.getString("deviceName"));
		device.setSerialNumber(Integer.valueOf(result.getString("serialNumber")));
		device.setIpAddress(result.getString("IPAddress"));
		device.setPortNumber(Integer.valueOf(result.getString("portNumber")));
		return device;
	}
	public String getStatus() throws SQLException, UnknownHostException, IOException{
		DeviceQueries query = new DeviceQueries(device);
		NetworkCTRL network;
		int portNumber;
		ResultSet result = query.getInfo();
		result.next();
		portNumber = Integer.valueOf(result.getString("portNumber"));
		network = new NetworkCTRL(portNumber);
		network.sendData("getStatus");
		return network.receieveData();
	}  
	 
	 
}
