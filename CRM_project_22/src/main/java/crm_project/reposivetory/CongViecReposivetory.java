package crm_project.reposivetory;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import crm_project.confic.MysqlConfig;
import crm_project.entity.CongViec;
import crm_project.entity.CongViecNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.entity.LoaiThanhVien;
import crm_project.entity.NguoiDung;
import crm_project.entity.TrangThai;

public class CongViecReposivetory {
	public List SelectAllFromCongViecNguoiDung() {
		String query =  "SELECT * FROM CongViec_NguoiDung cvnd ";
		
		Connection connection = MysqlConfig.getConnection();
		List <CongViecNguoiDung> list = new ArrayList<CongViecNguoiDung>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);	
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NguoiDung nd = new NguoiDung();
				CongViec cv = new CongViec();
				CongViecNguoiDung cvnd = new CongViecNguoiDung();
				
				nd.setId(resultSet.getInt("id_nguoidung"));
				cv.setId(resultSet.getInt("id_congviec"));
				cvnd.setId_CongViec(cv);
				cvnd.setId_NguoiDung(nd);
				list.add(cvnd);
			}
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
	public List GetFromCongViecNguoiDung() {
		String query =  "SELECT cv.ten,cv.id as id_congviec ,cv.id_duan ,nd.id ,nd.fullname ,cv.ngaybatdau ,cv.ngayketthuc, cv.id_trangthai  FROM NguoiDung nd \r\n"
				+ "join CongViec_NguoiDung cvnd ON nd.id =cvnd.id_nguoidung \r\n"
				+ "JOIN CongViec cv ON cvnd.id_congviec = cv.id ";
		
		Connection connection = MysqlConfig.getConnection();
		List <CongViecNguoiDung> list = new ArrayList<CongViecNguoiDung>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);	
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				NguoiDung nd = new NguoiDung();
				CongViec cv = new CongViec();
				TrangThai tt = new TrangThai();
				GroupWork gw = new GroupWork();
				
				CongViecNguoiDung cvnd = new CongViecNguoiDung();
				//
				nd.setId(resultSet.getInt("id"));
				nd.setFullname(resultSet.getString("fullname"));
				//
				cv.setId(resultSet.getInt("id_congviec"));
				cv.setName(resultSet.getString("ten"));
				
				cv.setNgaybatdau(resultSet.getString("ngaybatdau"));
				cv.setNgayketthuc(resultSet.getString("ngayketthuc"));
				//
				gw.setId(resultSet.getInt("id_duan"));				
				tt.setId(resultSet.getInt("id_trangthai"));
				//
				cv.setTrangthai(tt);
				cv.setId_duan(gw);
				cvnd.setId_CongViec(cv);
				cvnd.setId_NguoiDung(nd);
				list.add(cvnd);
			}
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
	
	public int InsertCongViec(String tencv, String ngaybatdau, String ngaykethuc, int id_duan) {
		
		 String query = "INSERT INTO CongViec (ten,mota,ngaybatdau,ngayketthuc,id_duan,id_trangthai)\r\n"
		 		+ "VALUES (?,?,?,?,?,3)";

		Connection connection = MysqlConfig.getConnection();
        int count=0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);

			/*
			 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
			 * trả dữ liệu
			 * 
			 */
			
			statement.setString(1, tencv);
			statement.setString(2, tencv);
			statement.setString(3, ngaybatdau);
			statement.setString(4, ngaykethuc);
			statement.setInt(5, id_duan);
			count = statement.executeUpdate();
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
		
		
	return count;
	}
	
	public List<CongViec> getLastInsert(String tencv, String ngaybatdau, String ngaykethuc, int id_duan) {
		
		 List<CongViec> list = new ArrayList<CongViec>();
		 String query = "SELECT * FROM CongViec cv WHERE cv.ten=? "
		 		+ "AND cv.ngayketthuc  =? "
		 		+ "AND  cv.ngaybatdau =? "
		 		+ "AND cv.id_duan =?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			/*
			 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
			 * trả dữ liệu
			 * 
			 */
			
			statement.setString(1, tencv);
			statement.setString(3, ngaybatdau);
			statement.setString(2, ngaykethuc);
			statement.setInt(4, id_duan);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CongViec cv = new CongViec();
				GroupWork gw = new GroupWork();
				//-------------------//
				
				
				cv.setId(resultSet.getInt("id"));
				cv.setName(resultSet.getString("ten"));
				cv.setNgaybatdau(resultSet.getString("ngaybatdau"));
				cv.setNgaybatdau(resultSet.getString("ngayketthuc"));
				gw.setId(resultSet.getInt("id_duan"));
				cv.setId_duan(gw);
				//------------------------//
			
				list.add(cv);
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
	
	public int InsertCongViecNguoiDung(int id_congviec,int id_nguoidung) {
		
		
		String query = "INSERT INTO CongViec_NguoiDung (id_nguoidung,id_congviec)\r\n"
				+ "VALUES (?,?)";

		Connection connection = MysqlConfig.getConnection();
        int count=0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);

			/*
			 * excuteQuery; dùng khi câu truy vấn trả ra dữ liệu excuteUpdate; truy vấn ko
			 * trả dữ liệu
			 * 
			 */
			
			
			statement.setInt(1, id_nguoidung);
			statement.setInt(2, id_congviec);
			count = statement.executeUpdate();
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
		
		
	return count;
	}
	public static void main(String[] args) {
		CongViecReposivetory congViecReposivetory = new CongViecReposivetory();
		System.out.println(congViecReposivetory.InsertCongViec("ahuu","2022-12-12","2022-12-12", 1));
	}
}
