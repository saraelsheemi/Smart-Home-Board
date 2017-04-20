package controllers;

public class Device {
	private int id ;
	private String name;
	private boolean Status;
	private boolean available ;
	private int portNumber;
	private boolean monitored;
	private boolean receiveNotification;
	
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
