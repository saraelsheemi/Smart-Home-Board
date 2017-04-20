package Entities;



public class User {
	private String name; 
	private int id;
	private TYPE type; 
	private String email;
	private String password; 
	private String gender; 
	
	public enum TYPE { admin , user } ; 
	
	public int getId(){
		return id; 
	}
	public String getname(){
		return name; 
	}
	public TYPE gettype(){
		return type; 
	}
	public String getemail(){
		return email; 
	}
	public String getpassword(){
		return password; 
	}
	public String getgender(){
		return gender; 
	}
}
