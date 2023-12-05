package crm_project.entity;

public class LoaiThanhVien {
private int id;
private String name;
private String mota;

public LoaiThanhVien() {
	// TODO Auto-generated constructor stub
}

public LoaiThanhVien(int id, String name, String mota) {
	
	this.id = id;
	this.name = name;
	this.mota = mota;
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

}
