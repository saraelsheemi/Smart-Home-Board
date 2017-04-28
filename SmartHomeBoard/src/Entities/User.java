package Entities;

public class User {
	private int id;
	private String name;
	private String type; // need to be Enum Varibale 
	private String gender;
	private String email;
	private String password;
	/**
	 * @return the name
	 */
	public User(){}
	public User(String email, String password){
		this.email = email;
		this.password = password;
	}
	public User(String name, String type, String gender, String email, String password) {
		super();
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	public User(int id, String name, String type, String gender, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
