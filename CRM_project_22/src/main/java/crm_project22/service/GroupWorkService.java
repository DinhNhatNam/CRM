package crm_project22.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.mysql.cj.Session;

import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.DuAnNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.reposivetory.GroupWorkReposivetory;

public class GroupWorkService {
	private GroupWorkReposivetory groupWorkReposivetory = new GroupWorkReposivetory();

	public List ReadAllGroupWork() {
		List<GroupWork> list = new ArrayList<GroupWork>();
		return list = groupWorkReposivetory.SelectAllFromDuAn();

	}

	public boolean CreateGroupWork(String ten, String ngaybatdau, String ngayketthuc, int id_nguoidung) {
		if (ten != null || ngaybatdau != null || ngayketthuc != null) {
			int count = groupWorkReposivetory.InseartGroupWork(ten, ngaybatdau, ngayketthuc, id_nguoidung);
			return count > 0;
		} else {
			return false;
		}

	}

	public List<CongViecNguoiDung> Groupworkmetmoiqua(int id) {
		List<CongViecNguoiDung> list = groupWorkReposivetory.Selectmotdongmetbome(id);
		return list;
	}


public List<DuAnNguoiDung> GetDuAnNguoiDung(int id) {
	List<DuAnNguoiDung> list = groupWorkReposivetory.FindDuAnByIdNguoiDung(id);
	return list;
}
public List<Double> Counting(int id) {
	List<CongViecNguoiDung> list = groupWorkReposivetory.Selectmotdongmetbome(id);
	int count1=0;
	int count2=0;
	int count3=0;
	for (int i = 0; i < list.size(); i++) {
		if(list.get(i).getId_CongViec().getTrangthai().getId()==1) {
			count1++;
		}
if(list.get(i).getId_CongViec().getTrangthai().getId()==2) {
			count2++;
		}
if(list.get(i).getId_CongViec().getTrangthai().getId()==3) {
	count3++;
}
	}
	double percentChuahoanthanh =(double)count3*100/list.size();
	
	double percentDanghoanthanh =(double)count2*100/list.size();
	double percentDahoanthanh = (double)count1*100/list.size();
	
	List<Double> listout = new ArrayList<Double>();
	listout.add(percentChuahoanthanh);
	listout.add(percentDahoanthanh);
	listout.add(percentDanghoanthanh);	

	
	return listout;
}
public List FindDuAnById(int id) {
	List<GroupWork> list = groupWorkReposivetory.FindDuAnById(id);
	
	return list;
	
}
public boolean UpdateGroupwork (GroupWork gr) {
	int count = groupWorkReposivetory.UpdateDuAn(gr);
	return count>0;
}
public static void main(String[] args) {
	GroupWorkReposivetory groupWorkReposivetory = new GroupWorkReposivetory();
	List<GroupWork> list1 = groupWorkReposivetory.FindDuAnById(6);
	
	System.out.println(list1.get(0));
}
}
