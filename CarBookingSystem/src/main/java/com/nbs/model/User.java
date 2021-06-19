package com.nbs.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.UniqueConstraint;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="user" ,uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "* please enter name")
	private String name;
	@NotBlank(message="* please enter emailid")
	@Email(message = "* please enter valid email id")
	private String email;
	@NotBlank(message = "* please enter password")
	private String password;
	private int type;
	@Column(name = "created", columnDefinition = "timestamp default current_timestamp")
	private Timestamp created;
	@Temporal(TemporalType.DATE)
	private Date updated;
	public User() {
		super();
	}
	public User(Integer id, String name, String email, String password, int type, Timestamp created, Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.type = type;
		this.created = created;
		this.updated = updated;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", type=" + type
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
	

}
