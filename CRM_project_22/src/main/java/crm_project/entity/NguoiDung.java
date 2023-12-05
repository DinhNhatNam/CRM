package crm_project.entity;

public class NguoiDung {
private int id;
private String email;
private String matkhau;
private String fullname;
private String diachi;
private String sdt;
private LoaiThanhVien loaithanhvien;


public NguoiDung() {
	
}



public NguoiDung(int id, String email, String matkhau, String fullname, String diachi, String sdt,
		LoaiThanhVien loaithanhvien) {
	
	this.id = id;
	this.email = email;
	this.matkhau = matkhau;
	this.fullname = fullname;
	this.diachi = diachi;
	this.sdt = sdt;
	this.loaithanhvien = loaithanhvien;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMatkhau() {
	return matkhau;
}
public void setMatkhau(String matkhau) {
	this.matkhau = matkhau;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}

public LoaiThanhVien getLoaithanhvien() {
	return loaithanhvien;
}

public void setLoaithanhvien(LoaiThanhVien loaithanhvien) {
	this.loaithanhvien = loaithanhvien;
}



@Override
public String toString() {
	return "NguoiDung [id=" + id + ", email=" + email + ", matkhau=" + matkhau + ", fullname=" + fullname + ", diachi="
			+ diachi + ", sdt=" + sdt + ", loaithanhvien=" + loaithanhvien + "]";
}



}
