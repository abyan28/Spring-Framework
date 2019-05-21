package com.abyan.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

@Entity
@Table(name="guest")
public class Penghuni {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "firs_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "id_number")	
	private String idNumber;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@ManyToOne(	fetch=FetchType.EAGER, cascade = {
					CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH,
						})
	@JoinColumn(name = "room_id")
	private Kamar kamar;

	@Column(name = "checkout_date")
	private LocalDate checkoutDate;
	
	@Column(name = "checkin_date")
	private LocalDate checkinDate;
	
	@Column(name = "is_checkedout")
	private boolean isCheckedout;

	@OneToOne(cascade = {})
	@JoinColumn(name = "last_checkedout_room_id")
	private Kamar lastCheckedoutRoom;

	public Penghuni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Penghuni(String firstName, String lastName, String idNumber, String phoneNumber, Kamar kamar,
			LocalDate checkoutDate, LocalDate checkinDate, boolean isCheckedout) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.kamar = kamar;
		this.checkoutDate = checkoutDate;
		this.checkinDate = checkinDate;
		this.isCheckedout = isCheckedout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Kamar getKamar() {
		return kamar;
	}

	public void setKamar(Kamar kamar) {
		this.kamar = kamar;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public boolean getIsCheckedout() {
		return isCheckedout;
	}

	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}
	
	public Kamar getLastCheckedoutRoom() {
		return lastCheckedoutRoom;
	}

	public void setLastCheckedoutRoom(Kamar lastCheckedoutRoom) {
		this.lastCheckedoutRoom = lastCheckedoutRoom;
	}
	
	@Override
	public boolean equals(Object o) {
	    // self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Penghuni penghuni = (Penghuni) o;
	    // field comparison
	    return penghuni.getFirstName().equals(this.firstName) && 
	    		penghuni.getLastName().equals(this.lastName) && 
	    		penghuni.getId() == this.id && 
	    		penghuni.getIdNumber().equals(this.idNumber) && 
	    		penghuni.getPhoneNumber().equals(this.phoneNumber);
	}

	@Override
	public String toString() {
		return "Penghuni [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", idNumber=" + idNumber
				+ ", isCheckedout=" + isCheckedout + "]";
	}
	
	
}
