package crm_project22.service;

import java.util.ArrayList;
import java.util.List;

import crm_project.entity.LoaiThanhVien;
import crm_project.reposivetory.LoaiThanhVienReposivetory;

public class RoleService {
private LoaiThanhVienReposivetory loaiThanhVienReposivetory = new LoaiThanhVienReposivetory();
public boolean InseartIntoLoaiThanhVien(String role,String mota) {
	int count = loaiThanhVienReposivetory.InsertLoaiThanhVien(role, mota);
	return count>0;
}
public List<LoaiThanhVien> ReadRoleService() {
	List<LoaiThanhVien> list = new ArrayList<LoaiThanhVien>();
	list = loaiThanhVienReposivetory.SelectAllFromLoaiThanhVien();
	return list;
	
}
public boolean deleteRoleById(int id) {
	int count=  loaiThanhVienReposivetory.deleteById(id);
	
	return count>0;
}
}
