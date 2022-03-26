package soa.response;

import java.util.ArrayList;

import soa.model.Hospital;
import soa.model.Medicine;

public class MedicineResponse {

	private String status;
	private String msg;
	private ArrayList<Medicine> result;
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

	public ArrayList<Medicine> getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(ArrayList<Medicine> result) {
		this.result = result;

	}
}
