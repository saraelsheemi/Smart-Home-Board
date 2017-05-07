package Entities;

public class Device {
	
	
	private int id ;
	private String name;
	private int serialNumber;
	private boolean Status;
	private boolean available ;
	private int portNumber;
	private String ipAddress ;
	private boolean monitored;
	private int boardID;
	
	public Device(){
		this.id = 0;
		this.name = " ";
		this.serialNumber = 0;
		this.Status = false;
		this.available = false;
		this.portNumber = 0;
		this.ipAddress = " ";
		this.monitored = false;
		this.boardID = 0;
	}
	
	public Device(String name, String serialNumber, int portNumber) {
		this.name = name;
		this.portNumber = portNumber;
		this.serialNumber = Integer.valueOf(serialNumber);
	}
	
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	private boolean receiveNotification;
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		Status = status;
	}
	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	/**
	 * @return the portNumber
	 */
	public int getPortNumber() {
		return portNumber;
	}
	/**
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	/**
	 * @return the monitored
	 */
	public boolean isMonitored() {
		return monitored;
	}
	/**
	 * @param monitored the monitored to set
	 */
	public void setMonitored(boolean monitored) {
		this.monitored = monitored;
	}
	/**
	 * @return the receiveNotification
	 */
	public boolean isReceiveNotification() {
		return receiveNotification;
	}
	/**
	 * @param receiveNotification the receiveNotification to set
	 */
	public void setReceiveNotification(boolean receiveNotification) {
		this.receiveNotification = receiveNotification;
	}
	
}
