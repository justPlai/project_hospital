package soa.response;

import java.util.ArrayList;

import soa.model.Doctor;

public class DoctorResponse {

		private String status;
		private String msg;
		private ArrayList<Doctor> result;
		

		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public ArrayList<Doctor> getResult() {
			return result;
		}
		
		public void setResult(ArrayList<Doctor> result) {
			this.result = result;
		}
		
		public String getMsg() {
			return msg;
		}
		
		public void setMsg(String msg) {
			this.msg = msg;
		}
}
