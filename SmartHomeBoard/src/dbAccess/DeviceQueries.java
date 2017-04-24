package dbAccess;

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
		String statement="insert into Sensor values ('"+ device.getName().toString() +"',4,'"+
		String.valueOf(device.getSerialNumber())+"','"+String.valueOf(device.getPortNumber())+"','20393933X','Type',true,true,true,233)";
		//String statement = "insert into Sensor values ('tv',3,'24442','3424','AKOEO29301','fun',true,true,true,233)";
		System.out.println("sql statment: "+statement);
		databaseConnection.executeUpdate(statement);
		System.out.println("query executed");
	}
}
