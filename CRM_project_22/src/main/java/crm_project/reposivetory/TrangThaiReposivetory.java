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
import crm_project.entity.NguoiDung;
import crm_project.entity.TrangThai;

public class TrangThaiReposivetory {
	public List SelectAllFromTrangThai() {
		String query =  "SELECT * FROM TrangThai tt ";
		
		Connection connection = MysqlConfig.getConnection();
		List <TrangThai> list = new ArrayList<TrangThai>();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(query);	
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TrangThai tt = new TrangThai();
				tt.setId(resultSet.getInt("id"));
				tt.setMota(resultSet.getString("mota"));
				tt.setTen(resultSet.getString("ten"));
				list.add(tt);
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
	public List FindFromTrangThai(int id) {
		String query =  "SELECT * FROM TrangThai tt WHERE id = ?;";
		
		Connection connection = MysqlConfig.getConnection();
		List <TrangThai> list = new ArrayList<TrangThai>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1,id );
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TrangThai tt = new TrangThai();
				tt.setId(resultSet.getInt("id"));
				tt.setMota(resultSet.getString("mota"));
				tt.setTen(resultSet.getString("ten"));
				list.add(tt);
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
	
	public static void main(String[] args) {
		TrangThaiReposivetory reposivetory = new TrangThaiReposivetory();
		List<TrangThai> list = reposivetory.FindFromTrangThai(1);
		System.out.println(list.get(0).getTen());
	}
}
