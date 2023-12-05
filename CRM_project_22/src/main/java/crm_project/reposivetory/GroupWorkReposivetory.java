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
import crm_project.entity.DuAnNguoiDung;
import crm_project.entity.GroupWork;
import crm_project.entity.NguoiDung;
import crm_project.entity.TrangThai;

public class GroupWorkReposivetory {
	public List SelectAllFromDuAn() {
		String query = "SELECT * FROM DuAn da  ";

		Connection connection = MysqlConfig.getConnection();
		List<GroupWork> list = new ArrayList<GroupWork>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				GroupWork gw = new GroupWork();

				gw.setId(resultSet.getInt("id"));
				gw.setName(resultSet.getString("ten"));
				gw.setMota(resultSet.getString("mota"));
				gw.setNgaybatdau(resultSet.getString("ngaybatdau"));
				gw.setNgaykethuc(resultSet.getString("ngayketthuc"));
				list.add(gw);
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

	public List FindDuAnById(int id) {
		String query = "SELECT * FROM DuAn da WHERE id = ? ";

		Connection connection = MysqlConfig.getConnection();
		List<GroupWork> list = new ArrayList<GroupWork>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				GroupWork gw = new GroupWork();

				gw.setId(resultSet.getInt("id"));
				gw.setName(resultSet.getString("ten"));
				gw.setMota(resultSet.getString("mota"));
				gw.setNgaybatdau(resultSet.getString("ngaybatdau"));
				gw.setNgaykethuc(resultSet.getString("ngayketthuc"));
				list.add(gw);
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

	public int InseartGroupWork(String ten, String ngaybatdau, String ngayketthuc, int idnguoidung) {
		String query = "INSERT INTO DuAn (ten,mota,ngaybatdau,ngayketthuc,id_nguoidung,id_trangthai)\r\n"
				+ "VALUES (?,?,?,?,?,?)";

		Connection connection = MysqlConfig.getConnection();
		int count = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ten);
			statement.setString(2, "");
			statement.setString(3, ngaybatdau);
			statement.setString(4, ngayketthuc);
			statement.setInt(5, idnguoidung);
			statement.setInt(6, 3);
			count = statement.executeUpdate();

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
	
	public List<CongViecNguoiDung> Selectmotdongmetbome(int id) {
		String query = " SELECT ch.id , ch.fullname, cv.ten ,cv.ngaybatdau ,cv.ngayketthuc ,cv.id_trangthai \r\n"
				+ " FROM CongViec cv join (SELECT nd.id ,nd.fullname ,cvnd.id_congviec  FROM  NguoiDung nd JOIN DuAn_NguoiDung dand ON dand.id_nguoidung = nd.id \r\n"
				+ "JOIN CongViec_NguoiDung cvnd ON nd.id = cvnd.id_nguoidung \r\n"
				+ "WHERE dand.id_duan =?) ch on cv.id = ch.id_congviec WHERE id_duan =?";

		Connection connection = MysqlConfig.getConnection();
		List<CongViecNguoiDung> list = new ArrayList<CongViecNguoiDung>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setInt(2, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CongViecNguoiDung cvnd = new CongViecNguoiDung();
				NguoiDung nd = new NguoiDung();
				CongViec cv = new CongViec();
				TrangThai tt = new TrangThai();
				tt.setId(resultSet.getInt("id_trangthai"));
				cv.setTrangthai(tt);
				cv.setNgayketthuc(resultSet.getString("ngayketthuc"));
				cv.setNgaybatdau(resultSet.getString("ngaybatdau"));
				cv.setName(resultSet.getString("ten"));
				nd.setFullname(resultSet.getString("fullname"));
				nd.setId(resultSet.getInt("id"));
				cvnd.setId_NguoiDung(nd);
				cvnd.setId_CongViec(cv);
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
	public List FindDuAnByIdNguoiDung(int id) {
		String query = "select dand.id_duan ,dand.id_nguoidung, nd.fullname  FROM DuAn_NguoiDung dand join NguoiDung nd ON dand.id_nguoidung =nd.id \r\n"
				+ "\r\n"
				+ "WHERE dand.id_duan =?";

		Connection connection = MysqlConfig.getConnection();
		List<DuAnNguoiDung> list = new ArrayList<DuAnNguoiDung>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DuAnNguoiDung duAnNguoiDung = new DuAnNguoiDung();
				GroupWork gw = new GroupWork();
				NguoiDung nd = new NguoiDung();
				nd.setId(resultSet.getInt("id_nguoidung"));
				nd.setFullname(resultSet.getString("fullname"));
				gw.setId(resultSet.getInt("id_duan"));
				duAnNguoiDung.setId_duan(gw);
				duAnNguoiDung.setId_nguoidung(nd);
				list.add(duAnNguoiDung);
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
	public int UpdateDuAn(GroupWork gw) {
		String query = "UPDATE DuAn Set ten = ? , "
				+ "ngaybatdau =?, ngayketthuc = ? WHERE id =? ";

		Connection connection = MysqlConfig.getConnection();
		int count = 0;

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, gw.getName());
			statement.setString(2, gw.getNgaybatdau());
			statement.setString(3, gw.getNgaykethuc());
			statement.setInt(4, gw.getId());
			
			count = statement.executeUpdate();

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
	GroupWorkReposivetory groupWorkReposivetory = new GroupWorkReposivetory();
	List<CongViecNguoiDung> li = groupWorkReposivetory.Selectmotdongmetbome(1);
	
	System.out.println(li.get(0));
}
}
