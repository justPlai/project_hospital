package soa.model;
// Generated Mar 26, 2022, 5:09:20 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Hospital generated by hbm2java
 */
public class Hospital implements java.io.Serializable {

	private Integer hospitalId;
	private String hospitalName;
	private String hospitalLocation;
	private String hospitalPhonenumber;
	@JsonIgnore
	private Set doctors = new HashSet(0);

	public Hospital() {
	}

	public Hospital(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Hospital(String hospitalName, String hospitalLocation, String hospitalPhonenumber, Set doctors) {
		this.hospitalName = hospitalName;
		this.hospitalLocation = hospitalLocation;
		this.hospitalPhonenumber = hospitalPhonenumber;
		this.doctors = doctors;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalLocation() {
		return this.hospitalLocation;
	}

	public void setHospitalLocation(String hospitalLocation) {
		this.hospitalLocation = hospitalLocation;
	}

	public String getHospitalPhonenumber() {
		return this.hospitalPhonenumber;
	}

	public void setHospitalPhonenumber(String hospitalPhonenumber) {
		this.hospitalPhonenumber = hospitalPhonenumber;
	}

	public Set getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Set doctors) {
		this.doctors = doctors;
	}

}
