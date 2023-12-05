package crm_project.reposivetory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project.confic.MysqlConfig;
import crm_project.entity.LoaiThanhVien;
import crm_project.entity.NguoiDung;

public class LoaiThanhVienReposivetory {
public int InsertLoaiThanhVien(String role,String mota ) {
	String query = "INSERT INTO LoaiThanhVien(ten,mota)\r\n"
			+ "values (?,?)";
	
	Connection connection = MysqlConfig.getConnection();
int count=0;
	try {
		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, role);
		statement.setString(2, mota);
		
		 count = statement.executeUpdate();	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.err.println("lỗi thực thi" + e.getLocalizedMessage());
		return count;
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
public List SelectAllFromLoaiThanhVien() {

	String query =  "SELECT * FROM LoaiThanhVien ltv ";
	
	Connection connection = MysqlConfig.getConnection();
	List <LoaiThanhVien> list = new ArrayList<LoaiThanhVien>();
	try {
		PreparedStatement statement = connection.prepareStatement(query);	
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			LoaiThanhVien ltv = new LoaiThanhVien();

			ltv.setId(resultSet.getInt("id"));
			ltv.setName(resultSet.getString("ten"));
			ltv.setMota(resultSet.getString("mota"));
			list.add(ltv);
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
public int deleteById(int id) {
	int count = 0;
	String query = "DELETE FROM LoaiThanhVien WHERE id = ?";
	Connection connection = MysqlConfig.getConnection();
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		
		count = statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
}

public static void main(String[] args) {
	LoaiThanhVienReposivetory loaiThanhVienReposivetory = new LoaiThanhVienReposivetory();
	System.out.println(loaiThanhVienReposivetory.deleteById(5));
}
}
