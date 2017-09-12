package com.javagain.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This class represent roles in the application
 * 
 * @author Sandeep.Sharma
 *
 */
@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userRoles")
	private List<User> users;
	
	public Role() {}
	
	public Role(Integer id) {
		this.id = id;
	}
	
	public Role(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
