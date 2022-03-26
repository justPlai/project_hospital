package soa.responsebyid;

import java.util.ArrayList;

import soa.model.Hospital;
import soa.model.Medicinedetail;

public class MedicinedetailIdResponse {
	private String status;
	private String msg;
	private Medicinedetail result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Medicinedetail getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(Medicinedetail result) {
		this.result = result;

	}
}
