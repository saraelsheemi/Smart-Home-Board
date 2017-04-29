package Entities;

import java.util.ArrayList;

public class Board {
	
	private String name ;
	private int id ;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Device> devices = new ArrayList<Device>();
	
	public Board(){}
	public Board(String name) {
		this.name = name;
	}
	public Board(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Board(int id) {

		this.id = id;
	}
	public Board(String name, int id, ArrayList<User> users, ArrayList<Device> devices) {
		super();
		this.name = name;
		this.id = id;
		this.users = users;
		this.devices = devices;
	}
	public void addUser(User user){
		users.add(user);
	}
	public void addDevice(Device device){
		devices.add(device);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Device> getDevice() {
		return devices;
	}
	public void setDevice(ArrayList<Device> device) {
		this.devices = device;
	}

}
