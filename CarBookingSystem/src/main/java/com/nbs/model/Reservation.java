package com.nbs.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="userid",referencedColumnName = "id")
	
	private  User user;
	@Column(name="fromdate")
	private Date fromDate;
	@Column(name="todate")
	private Date toDate;
	@ManyToOne(targetEntity =Vehicle.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="vehicleid",referencedColumnName = "id")

	private Vehicle vehicle;
	@Column(name="status")
	private boolean status;
	@Column(name = "created", columnDefinition = "timestamp default current_timestamp")
	private Timestamp created;
	@Temporal(TemporalType.DATE)
	@Column(name="updated")
	private Date updated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public void setUpdated(Date  updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", vehicle=" + vehicle + ", status=" + status + ", created=" + created + ", updated=" + updated + "]";
	}
	
	}


