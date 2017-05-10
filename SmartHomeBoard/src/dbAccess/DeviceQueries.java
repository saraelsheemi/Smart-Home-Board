package dbAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.Device;
import dbAccess.DatabaseConnection; 
public class DeviceQueries {
	private DatabaseConnection databaseConnection;
	private Device device;
	
	public DeviceQueries(Device device) throws SQLException {
		databaseConnection=new DatabaseConnection();
		this.device = device;
	}
	public DeviceQueries() throws SQLException {
		databaseConnection=new DatabaseConnection();
	}
	public void registerDevice() throws SQLException{
		System.out.println("inside register device query");
		//System.out.println("insert into Sensor values ('"+ device.getName().toString() +"','3','"+
		//		String.valueOf(device.getSerialNumber())+"','"+String.valueOf(device.getPortNumber())+"','127.0.0.1','electronics',true,true,true,233)");
		String assignedID = String.valueOf(this.getLastID()+1);
		System.out.println("assigned ID:" +assignedID);
		try{
		String statement="insert into Sensor values ('"+ device.getName().toString() +"','"+ assignedID +"','"+
						String.valueOf(device.getSerialNumber())+"','"+String.valueOf(device.getPortNumber())+"','127.0.0.1','electronics',true,true,true,233)";
		System.out.println("sql statment: "+statement);
		databaseConnection.executeUpdate(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("query executed");
	}
	public ResultSet checkExistance() throws SQLException{
		databaseConnection = new DatabaseConnection();
		String statement = "select * from Sensor where serialNumber = "+String.valueOf(device.getSerialNumber());
		System.out.println("statement: "+statement);
		ResultSet result = null;
		result = databaseConnection.executeQuery(statement);
		return result;
	}
	public ResultSet getInfo() throws SQLException{
		databaseConnection = new DatabaseConnection();
		ResultSet result = databaseConnection.executeQuery("select * from Sensor where deviceID = "+String.valueOf(device.getId()));
		return result;
	}
	public ResultSet getBoardDevices() throws SQLException {
		// TODO Auto-generated method stub
		databaseConnection = new DatabaseConnection();
		ResultSet result = databaseConnection.executeQuery("select * from Sensor where BoardID = "+String.valueOf(device.getBoardID()));
		System.out.println("query: select * from Sensor where BoardID = "+String.valueOf(device.getBoardID()));
		return result;
	}
	public ResultSet getNewDevices() throws SQLException {
		// TODO Auto-generated method stub
		databaseConnection = new DatabaseConnection();
		ResultSet result = databaseConnection.executeQuery("select * from Sensor where BoardID IS NULL");
		return result;
	}
	public void addDevice(String deviceID, String boardID) throws SQLException {
		// TODO Auto-generated method stub
		databaseConnection = new DatabaseConnection();
		databaseConnection.executeUpdate("UPDATE Sensor SET boardID = "+boardID+" WHERE deviceID = "+deviceID);
	}
	public void removeDevice() throws SQLException {
		// TODO Auto-generated method stub
		databaseConnection = new DatabaseConnection();
		databaseConnection.executeUpdate("UPDATE Sensor SET boardID = NULL WHERE deviceID = "+String.valueOf(device.getId()));
	}
	public int getLastID() throws SQLException{
		databaseConnection = new DatabaseConnection();
		System.out.println("obtaining device new ID......");
		ResultSet resultSet = databaseConnection.executeQuery("Select max(deviceID) from Sensor");
		resultSet.next();
		System.out.println("device ID obtained");
		if(resultSet.getString(1) == null){
			return 0;
		}
		System.out.println("new device ID is: "+resultSet.getString(1));
		return Integer.parseInt(resultSet.getString(1));		

	}
	public DatabaseConnection getConnection(){
		return databaseConnection;
	}
}
