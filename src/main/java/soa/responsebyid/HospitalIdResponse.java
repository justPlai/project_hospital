package soa.responsebyid;

import java.util.ArrayList;

import soa.model.Hospital;

public class HospitalIdResponse {

	private String status;
	private String msg;
	private Hospital result;
	/*private Hospital resultid;
	
	public Hospital getResultid() {
		return resultid;
	}

	public void setResultid(Hospital resultid) {
		this.resultid = resultid;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Hospital getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(Hospital result) {
		this.result = result;

	}
}
