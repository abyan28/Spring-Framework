package com.abyan.springmvc;

public class User {
	private String nama;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String nama, String password) {
		super();
		this.nama = nama;
		this.password = password;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}