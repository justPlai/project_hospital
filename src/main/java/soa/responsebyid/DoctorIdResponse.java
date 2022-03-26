package soa.responsebyid;

import java.util.ArrayList;

import soa.model.Doctor;

public class DoctorIdResponse {

	private String status;
	private String msg;
	private Doctor result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Doctor getResult() {
		return result;
	}

	public void setResult(Doctor result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
