package soa.responsebyid;

import java.util.ArrayList;

import soa.model.Hospital;
import soa.model.Medicine;

public class MedicineIdResponse {

	private String status;
	private String msg;
	private Medicine result;
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

	public Medicine getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(Medicine result) {
		this.result = result;

	}
}
