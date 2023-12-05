package crm_project.payload.respone;

public class BaseRespone {
private int statuscode;
private String message;
private Object data;
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public BaseRespone() {
	// TODO Auto-generated constructor stub
}
public int getStatuscode() {
	return statuscode;
}
public void setStatuscode(int statuscode) {
	this.statuscode = statuscode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}



}
