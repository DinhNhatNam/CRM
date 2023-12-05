package crm_project.entity;

public class CongViec {
private int id;
private String name;
private String mota;
private String ngaybatdau;
private String ngayketthuc;
private GroupWork id_duan;
private TrangThai trangthai;
public CongViec() {
	// TODO Auto-generated constructor stub
}
public CongViec(int id, String name, String mota, String ngaybatdau, String ngayketthuc, GroupWork id_duan,
		TrangThai trangthai) {
	
	this.id = id;
	this.name = name;
	this.mota = mota;
	this.ngaybatdau = ngaybatdau;
	this.ngayketthuc = ngayketthuc;
	this.id_duan = id_duan;
	this.trangthai = trangthai;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMota() {
	return mota;
}
public void setMota(String mota) {
	this.mota = mota;
}
public String getNgaybatdau() {
	return ngaybatdau;
}
public void setNgaybatdau(String ngaybatdau) {
	this.ngaybatdau = ngaybatdau;
}
public String getNgayketthuc() {
	return ngayketthuc;
}
public void setNgayketthuc(String ngayketthuc) {
	this.ngayketthuc = ngayketthuc;
}
public GroupWork getId_duan() {
	return id_duan;
}
public void setId_duan(GroupWork id_duan) {
	this.id_duan = id_duan;
}
public TrangThai getTrangthai() {
	return trangthai;
}
public void setTrangthai(TrangThai trangthai) {
	this.trangthai = trangthai;
}
@Override
public String toString() {
	return "CongViec [id=" + id + ", name=" + name + ", mota=" + mota + ", ngaybatdau=" + ngaybatdau + ", ngayketthuc="
			+ ngayketthuc + ", id_duan=" + id_duan + ", trangthai=" + trangthai + "]";
}



}
