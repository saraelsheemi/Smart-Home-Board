package dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Device;
import dbAccess.DatabaseConnection; 
public class DeviceQueries {
	private DatabaseConnection databaseConnection=new DatabaseConnection();
	private Device device;
	
	public DeviceQueries(Device device) throws SQLException {
		this.device = device;
	}
	public void registerDevice() throws SQLException{
		String statement="insert into Sensor values ('"+ device.getName().toString() +"',"+ String.valueOf(this.getLastID()+1)+",'"+
		String.valueOf(device.getSerialNumber())+"','"+String.valueOf(device.getPortNumber())+"','20393933X','Type',true,true,true,233)";
		System.out.println("sql statment: "+statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");
	}
	public ResultSet checkExistance() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet result = databaseConnection.executeQuery("select serialNumber from Sensor where serialNumber = "+String.valueOf(device.getSerialNumber()));
		return result;
	}
	public int getLastID() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet resultSet = databaseConnection.executeQuery("Select max(deviceID) from Sensor");
		resultSet.next();
		return Integer.parseInt(resultSet.getString(1));		

	}
}
