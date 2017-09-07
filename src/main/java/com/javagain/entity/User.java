package com.javagain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author Sandeep.Sharma
 *
 */
@Entity
@Table(name = "users")
public class User {	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@NotBlank
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Column(name = "username")
	private String userName;
	
	@NotBlank
	@Column(name = "password")
	private String password;	
	
	
	/**
	 * Default constructor to be used by Hibernate
	 */
	public User() {}
	
	/**
	 * Parameterized constructor to build user with parameters from other part of application
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 */
	public User(String firstName, String lastName, 
			String userName, String password) {		
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	
	// Getter and Setters.......
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
