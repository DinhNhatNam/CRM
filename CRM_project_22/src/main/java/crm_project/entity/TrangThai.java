package crm_project.entity;

import org.apache.catalina.util.ToStringUtil;

public class TrangThai {
private int id;
private String ten;
private String mota;
public TrangThai() {
	// TODO Auto-generated constructor stub
}
public TrangThai(int id, String ten, String mota) {
	
	this.id = id;
	this.ten = ten;
	this.mota = mota;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getMota() {
	return mota;
}
public void setMota(String mota) {
	this.mota = mota;
}
@Override
public String toString() {
	return "TrangThai [id=" + id + ", ten=" + ten + ", mota=" + mota + "]";
}

}
