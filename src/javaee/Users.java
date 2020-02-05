package javaee;

import java.io.Serializable;

public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4647748570493695954L;
	private int id;
	private String password;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Users(){
		
	}
	
	public Users(String name, String password) {
		this.password = password;
		this.name = name;
	}
}
