package soa.response;

import java.util.ArrayList;

import soa.model.Hospital;

public class HospitalResponse {

	private String status;
	private String msg;
	private ArrayList<Hospital> result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Hospital> getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(ArrayList<Hospital> result) {
		this.result = result;

	}
}
