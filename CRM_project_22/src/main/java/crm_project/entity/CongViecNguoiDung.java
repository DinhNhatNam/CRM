package crm_project.entity;

public class CongViecNguoiDung {
private CongViec Id_CongViec;
private NguoiDung Id_NguoiDung;

public CongViecNguoiDung() {
	// TODO Auto-generated constructor stub
}

public CongViecNguoiDung(CongViec id_CongViec, NguoiDung id_NguoiDung) {
	super();
	Id_CongViec = id_CongViec;
	Id_NguoiDung = id_NguoiDung;
}

public CongViec getId_CongViec() {
	return Id_CongViec;
}

public void setId_CongViec(CongViec id_CongViec) {
	Id_CongViec = id_CongViec;
}

public NguoiDung getId_NguoiDung() {
	return Id_NguoiDung;
}

public void setId_NguoiDung(NguoiDung id_NguoiDung) {
	Id_NguoiDung = id_NguoiDung;
}

@Override
public String toString() {
	return "CongViecNguoiDung [Id_CongViec=" + Id_CongViec + ", Id_NguoiDung=" + Id_NguoiDung + "]";
}



}
