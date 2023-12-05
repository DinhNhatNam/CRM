package crm_project22.service;

import java.util.ArrayList;
import java.util.List;

import crm_project.entity.CongViec;
import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.entity.NguoiDung;
import crm_project.entity.TrangThai;
import crm_project.reposivetory.CongViecReposivetory;
import crm_project.reposivetory.GroupWorkReposivetory;
import crm_project.reposivetory.NguoiDungReposivetory;
import crm_project.reposivetory.TrangThaiReposivetory;

public class TaskService {
	CongViecReposivetory congViecReposivetory = new CongViecReposivetory();
	TrangThaiReposivetory trangThaiReposivetory = new TrangThaiReposivetory();
	GroupWorkReposivetory groupWorkReposivetory = new GroupWorkReposivetory();
	NguoiDungReposivetory nguoiDungReposivetory = new NguoiDungReposivetory();
	public List<CongViecNguoiDung> readAllTask() {
	
		
		List<CongViecNguoiDung> listcvnd = congViecReposivetory.GetFromCongViecNguoiDung();
		
		for (int i = 0; i < listcvnd.size(); i++) {
			
			
			List<TrangThai> tt= trangThaiReposivetory.FindFromTrangThai(
					listcvnd.get(i).getId_CongViec().getTrangthai().getId()
					);
			
			List<GroupWork> gw = groupWorkReposivetory.FindDuAnById(
					listcvnd.get(i).getId_CongViec().getId_duan().getId()
					);
			
			listcvnd.get(i).getId_CongViec().getTrangthai().setTen(tt.get(0).getTen());
			listcvnd.get(i).getId_CongViec().getId_duan().setName(gw.get(0).getName());
		}
		return listcvnd;
	}
	public List<NguoiDung> ReadAllNguoiDung() {
		List<NguoiDung> nd = nguoiDungReposivetory.ReadAllNguoiDung();
		List <NguoiDung> nd_out = new ArrayList<NguoiDung>();
		for (int i = 0; i < nd.size(); i++) {
			if(!nd.get(i).getLoaithanhvien().getName().equalsIgnoreCase("ADMIN"))
			nd_out.add(nd.get(i));
		}
		return nd_out;
	}
	
	
	public boolean InsertCongViecNguoiDung(String tencv, String ngaybatdau, String ngaykethuc, int id_duan, int id_nguoidung) {
		congViecReposivetory.InsertCongViec(tencv, ngaybatdau, ngaykethuc, id_duan);
		
		List<CongViec> list = congViecReposivetory.getLastInsert(tencv, ngaybatdau, ngaykethuc, id_duan);
		
		int count = congViecReposivetory.InsertCongViecNguoiDung(list.get(0).getId(), id_nguoidung);
		return count>0;
	}
	public static void main(String[] args) {
		TaskService read = new TaskService();
		System.out.println(read.InsertCongViecNguoiDung("ahuhuuuuuuu", "2022-12-29", "2022-12-29", 1, 1));
	}
}
