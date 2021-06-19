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

import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="*Make sure you have not entered Vehicle Name")
	@Column(name = "vname")
	private String vName;
	@NotBlank(message="*Make sure you have not entered Vehicle color")
	@Column(name = "vcolor")
	private String vColor;
	@NotBlank(message="*Make sure you have not entered vehicle number")
	@Column(name = "vnumber")
	private String vNumber;
	@Column(name = "created", columnDefinition = "timestamp default current_timestamp")
	private java.sql.Timestamp created;
	@Temporal(TemporalType.DATE)
	private Date updated;
	public Vehicle() {
		 super();
		}
		public Vehicle(String vName, String vColor, String vNumber, Timestamp created, Date updated) {
			super();
			this.vName = vName;
			this.vColor = vColor;
			this.vNumber = vNumber;
			this.created = created;
			this.updated = updated;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvColor() {
		return vColor;
	}
	public void setvColor(String vColor) {
		this.vColor = vColor;
	}
	public String getvNumber() {
		return vNumber;
	}
	public void setvNumber(String vNumber) {
		this.vNumber = vNumber;
	}
	public java.sql.Timestamp getCreated() {
		return created;
	}
	public void setCreated(java.sql.Timestamp created) {
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
		return "Vehicle [id=" + id + ", vName=" + vName + ", vColor=" + vColor + ", vNumber=" + vNumber + ", created="
				+ created + ", updated=" + updated + "]";
	}


}
