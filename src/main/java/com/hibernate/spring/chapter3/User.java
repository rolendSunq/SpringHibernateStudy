package com.hibernate.spring.chapter3;

import java.util.StringTokenizer;

public class User {
	private String firstname;
	private String lastname;
	private String username;
	private Address address;

	public User() {
		// empty
	}
	
	public String getName() {
		return new StringBuffer().append(firstname).append(" ").append(lastname).toString();
	}

	public void setName(String name) {
		StringTokenizer t = new StringTokenizer(name);
		firstname = t.nextToken();
		lastname = t.nextToken();
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("User [username=").append(username)
				.append(", address=").append(address.toString())
				.append("]").toString();
	}
	
	
}
