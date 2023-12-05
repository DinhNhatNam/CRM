package crm_project22.service;

import java.util.List;

import crm_project.entity.NguoiDung;
import crm_project.reposivetory.NguoiDungReposivetory;

/*
 * tên class của service p thể hiện logic code
 * tên hàm trong service p đặt gợi nhớ tới tính năng đang 
 * xử lý
 * 
 */
public class LoginService {

 private NguoiDungReposivetory nguoiDungReposivetory= new NguoiDungReposivetory();
	public List<NguoiDung> checkLogin(String email,String pass) {
		List<NguoiDung> list = nguoiDungReposivetory.findByEmailAndPass(email, pass);	
		
		return list;
	}
	public static void main(String[] args) {
		LoginService loginService= new LoginService();
		System.out.println(loginService.checkLogin("ahihi@gmail.com", "12345"));
	}
}
