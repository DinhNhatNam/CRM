package crm_project.reposivetory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project.confic.MysqlConfig;
import crm_project.entity.CongViec;
import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.entity.LoaiThanhVien;
import crm_project.entity.NguoiDung;
import crm_project.entity.TrangThai;

// class tạo theo tên bảng để quản lý tất cả các câu query liên quan
//findBy dành cho câu select có điều kiện where
public class NguoiDungReposivetory {
	public List<NguoiDung> findByEmailAndPass(String email, String pass) {
		 List<NguoiDung> list = new ArrayList<NguoiDung>();
		 String query = "Select * from NguoiDung nd join LoaiThanhVien ltv ON nd.id =ltv .id \r\n"
					+ "\r\n"
					+ "where nd.email = ? and nd.matkhau= ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			/*
			 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
			 * trả dữ liệu
			 * 
			 */
			
			statement.setString(1, email);
			statement.setString(2, pass);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NguoiDung ng = new NguoiDung();
				LoaiThanhVien loaithanhvien = new LoaiThanhVien();
				//-------------------//
				ng.setId(resultSet.getInt("id"));
				ng.setFullname(resultSet.getString("fullname"));
				ng.setEmail(resultSet.getString("matkhau"));	
				loaithanhvien.setName(resultSet.getString("ten"));
				//------------------------//
				ng.setLoaithanhvien(loaithanhvien);
				list.add(ng);
			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("lỗi thực thi" + e.getLocalizedMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("lỗi đóng kết nối " + e.getLocalizedMessage());
				}
		}
		
		return list;
	}
	
public List ReadAllNguoiDung () {
	 List<NguoiDung> list = new ArrayList<NguoiDung>();
		String query = "SELECT nd.id , nd.fullname ,nd.email ,ltv.ten  "
				+ "FROM NguoiDung nd join LoaiThanhVien ltv ON nd.id = ltv.id ";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NguoiDung ng = new NguoiDung();
				LoaiThanhVien loaithanhvien = new LoaiThanhVien();
				ng.setId(resultSet.getInt("id"));
				ng.setFullname(resultSet.getString("fullname"));
				ng.setEmail(resultSet.getString("email"));	
				
				
				loaithanhvien.setName(resultSet.getString("ten"));
				
				
				ng.setLoaithanhvien(loaithanhvien);
				list.add(ng);
			}
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("lỗi thực thi" + e.getLocalizedMessage());
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println("lỗi đóng kết nối " + e.getLocalizedMessage());
				}
		}
		
		return list;
}
public List FindNguoiDungByID (int id) {
	 List<NguoiDung> list = new ArrayList<NguoiDung>();
	 String query = "SELECT * FROM NguoiDung nd WHERE id = ?"
	 		;

	Connection connection = MysqlConfig.getConnection();

	try {
		PreparedStatement statement = connection.prepareStatement(query);

		/*
		 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
		 * trả dữ liệu
		 * 
		 */
		
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			NguoiDung ng = new NguoiDung();
			LoaiThanhVien loaithanhvien = new LoaiThanhVien();
			//-------------------//
			ng.setId(resultSet.getInt("id"));
			ng.setFullname(resultSet.getString("fullname"));
			ng.setEmail(resultSet.getString("matkhau"));	
			ng.setDiachi(resultSet.getString("diachi"));
			ng.setSdt(resultSet.getString("soDienThoai"));
			loaithanhvien.setId(resultSet.getInt("id_loaithanhvien"));
			//------------------------//
			ng.setLoaithanhvien(loaithanhvien);
			list.add(ng);
		}
//		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println("lỗi thực thi" + e.getLocalizedMessage());
	} finally {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("lỗi đóng kết nối " + e.getLocalizedMessage());
			}
	}
	
	return list;
}
public List<CongViecNguoiDung> findbyID(int id) {
	String query = "SELECT  nd.id ,nd.email , nd.fullname ,cv.ten ,cv.ngaybatdau ,cv.ngayketthuc ,cv.id_trangthai,cv.id_duan FROM NguoiDung nd join CongViec_NguoiDung cvnd ON nd.id =cvnd.id_nguoidung JOIN CongViec cv ON cvnd.id_congviec = cv.id WHERE nd.id = ?";
	List<CongViecNguoiDung> list = new ArrayList<CongViecNguoiDung>();
	Connection connection = MysqlConfig.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			CongViecNguoiDung cvnd = new CongViecNguoiDung();
			
			NguoiDung ng = new NguoiDung();
			ng.setFullname(resultSet.getString("fullname"));
			ng.setEmail(resultSet.getString("email"));
			
			CongViec cv = new CongViec();
			cv.setName(resultSet.getString("ten"));
			
			
			
			cv.setNgaybatdau(resultSet.getString("ngaybatdau"));
			cv.setNgayketthuc(resultSet.getString("ngayketthuc"));
			
			
			
			TrangThai trangthai = new TrangThai();
			trangthai.setId(resultSet.getInt("id_trangthai"));
			cv.setTrangthai(trangthai);
			
			GroupWork duan = new GroupWork();
			duan.setId(resultSet.getInt("id_duan"));
			cv.setId_duan(duan);
			
			cvnd.setId_NguoiDung(ng);
			cvnd.setId_CongViec(cv);
			
			list.add(cvnd);
		}
	} catch (SQLException e) {
		System.err.println("lỗi thực thi" + e.getLocalizedMessage());
	} finally {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("lỗi đóng kết nối " + e.getLocalizedMessage());
			}
	}
	return list;
}
public int insertThanhVen(String email, String matkhau, String fullname, String diachi, String soDienThoai,
		int id_loaithanhvien) {
	int count = 0;
	String query = "Insert into NguoiDung (email,matkhau,fullname,diachi,soDienThoai,id_loaithanhvien) values(?,?,?,?,?,?)";
	Connection connection = MysqlConfig.getConnection();
	PreparedStatement statement;
	try {
		statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, matkhau);
		statement.setString(3, fullname);
		statement.setString(4, diachi);
		statement.setString(5, soDienThoai);
		statement.setInt(6, id_loaithanhvien);
		count = statement.executeUpdate();
	} catch (SQLException e) {
		System.out.println("loi them du lieu");
	}

	return count;
}
public int updateThanhVien(int id, String email, String matkhau, String fullname, String diachi, String soDienThoai,
		int id_loaithanhvien) {
	int count = 0;
	String query = "Update NguoiDung set email=?,matkhau=?,fullname=?,diachi=?,soDienThoai=?,id_loaithanhvien=? where id=?";
	Connection connection = MysqlConfig.getConnection();
	PreparedStatement statement;
	try {
		statement = connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, matkhau);
		statement.setString(3, fullname);			
		statement.setString(4, diachi);			
		statement.setString(5, soDienThoai);
		statement.setInt(6, id_loaithanhvien);
		statement.setInt(7, id);
		count = statement.executeUpdate();
	} catch (SQLException e) {
		System.out.println("loi update du lieu");
	}

	return count;
}
public int deleteByID(int id) {
	String query = "DELETE from NguoiDung where id = ?";
	Connection connection = MysqlConfig.getConnection();
	int count = 0;
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		count = statement.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
	return count;
}

}
