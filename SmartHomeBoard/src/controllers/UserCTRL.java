package controllers;

import Entities.User;
import dbAccess.UserQueries;

public class UserCTRL {
	private User user;
	public UserCTRL(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	public void signIn(){
		UserQueries query = new UserQueries(user);
		query.signIn();
	}
	public void SignOut(){}
	public void signUp(){
		UserQueries query = new UserQueries(user);
		query.signUp();
	}
	public void addUser(){
		UserQueries query = new UserQueries(user);
		query.addUser();
	}
	public void removeUser(){
		UserQueries query = new UserQueries(user);
		query.removeUser();
	}
	public void deleteAccount(){
		UserQueries query = new UserQueries(user);
		query.deleteAccount();
	}
	
}
