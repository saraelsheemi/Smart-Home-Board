package controllers;

import java.sql.SQLException;

import Entities.Device;
import dbAccess.DeviceQueries;

public class DeviceCTRL {
	private Device device ;
	public DeviceCTRL(Device device) {
		this.device = device;
	}
	public void registerDevice() throws SQLException{
		 DeviceQueries query = new DeviceQueries(device);
		 query.registerDevice();
	 }
	public void removeDevice(){}
	public void addDevice(){}
	public void sendCommand(){}
	 public void enableNotification(){}
	 public void disableNotification(){}
	 public void pullNotification(){}
	 public void getInfo(){}
	 public void getStatus(){} // needs to be boolean 
	 
	 
}
