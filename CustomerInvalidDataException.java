package org.bank.Exception;

public class CustomerInvalidDataException extends RuntimeException {

	private String msg;

	public CustomerInvalidDataException(String msg) {
		
		this.msg = msg;
	}

	public CustomerInvalidDataException() {
	
	
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CustomerInvalidDataException [msg=" + msg  + "]";
	}
	
	
	
	
}
