package crm_project22.service;

import java.util.ArrayList;
import java.util.List;

import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.NguoiDung;
import crm_project.reposivetory.NguoiDungReposivetory;

public class UserService {
	 NguoiDungReposivetory dungReposivetory= new NguoiDungReposivetory();
 public  List ReadAllNguoiDung() {
	List<NguoiDung> list = new ArrayList<NguoiDung>();
	return list = dungReposivetory.ReadAllNguoiDung();
}
 public List<CongViecNguoiDung> viewDetailUser(int id){
		return dungReposivetory.findbyID(id);
	}
 
 public boolean insert(String email,String matkhau,String fullname, String diachi, String soDienThoai,int id_loaithanhvien) {
		int count = dungReposivetory.insertThanhVen(email,matkhau,fullname,diachi,soDienThoai,id_loaithanhvien);
		return count > 0;
	}
 public boolean update(int id,String email,String matkhau,String fullname, String diachi, String soDienThoai,int id_loaithanhvien) {
		int count = dungReposivetory.updateThanhVien(id, email, matkhau, fullname, diachi, soDienThoai, id_loaithanhvien);
		return count > 0;
	}
 
 public boolean deleteUserByID(int id) {
		int count = dungReposivetory.deleteByID(id);
		return count > 0;
	}
 public static void main(String[] args) {
	UserService service = new UserService();
	List<NguoiDung> list = service.ReadAllNguoiDung();
	System.out.println(list.get(0));
}

}
