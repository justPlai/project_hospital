package soa.response;

import java.util.ArrayList;

import soa.model.Hospital;
import soa.model.Medicinedetail;

public class MedicinedetailResponse {
	private String status;
	private String msg;
	private ArrayList<Medicinedetail> result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Medicinedetail> getResult() {
		return result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setResult(ArrayList<Medicinedetail> result) {
		this.result = result;

	}
}
