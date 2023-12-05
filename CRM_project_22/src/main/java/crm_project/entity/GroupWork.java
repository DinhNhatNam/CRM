package crm_project.entity;

public class GroupWork {
 private int id;
 private String name;
 private String ngaybatdau;
 private String mota;
 private NguoiDung IdNguoidung;
 private String ngaykethuc;
 private TrangThai trangthai;
 
 public GroupWork() {
	// TODO Auto-generated constructor stub
}

public GroupWork(int id, String name, String ngaybatdau, String mota, NguoiDung idNguoidung, String ngaykethuc,
		TrangThai trangthai) {
	super();
	this.id = id;
	this.name = name;
	this.ngaybatdau = ngaybatdau;
	this.mota = mota;
	IdNguoidung = idNguoidung;
	this.ngaykethuc = ngaykethuc;
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

public String getNgaybatdau() {
	return ngaybatdau;
}

public void setNgaybatdau(String ngaybatdau) {
	this.ngaybatdau = ngaybatdau;
}

public String getMota() {
	return mota;
}

public void setMota(String mota) {
	this.mota = mota;
}

public NguoiDung getIdNguoidung() {
	return IdNguoidung;
}

public void setIdNguoidung(NguoiDung idNguoidung) {
	IdNguoidung = idNguoidung;
}

public String getNgaykethuc() {
	return ngaykethuc;
}

public void setNgaykethuc(String ngaykethuc) {
	this.ngaykethuc = ngaykethuc;
}

public TrangThai getTrangthai() {
	return trangthai;
}

public void setTrangthai(TrangThai trangthai) {
	this.trangthai = trangthai;
}

@Override
public String toString() {
	return "GroupWork [id=" + id + ", name=" + name + ", ngaybatdau=" + ngaybatdau + ", mota=" + mota + ", IdNguoidung="
			+ IdNguoidung + ", ngaykethuc=" + ngaykethuc + ", trangthai=" + trangthai + "]";
}

}
