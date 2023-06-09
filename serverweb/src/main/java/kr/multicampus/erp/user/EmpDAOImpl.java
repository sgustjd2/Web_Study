package kr.multicampus.erp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerVO;
import dao.DBUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into myemp values(?,?,?,?,?,1000,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getDeptno());
			ptmt.setString(2, user.getName());
			ptmt.setString(3, user.getId());
			ptmt.setString(4, user.getPass());
			ptmt.setString(5, user.getAddr());
			ptmt.setString(6, user.getGrade());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<EmpDTO> select() {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		EmpDTO emp = null;
		String sql = "select * from myemp";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}

		return list;
	}

	@Override
	public int delete(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from myemp ");
		sql.append("where id= ?");
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public EmpDTO getEmpInfo(String id) {
		String sql = "select * from myemp where id = ?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		EmpDTO emp = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return emp;
	}

	@Override
	public EmpDTO login(String id, String pass) {
		String sql = "select * from myemp where id=? and pass=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		EmpDTO emp = null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs =  ptmt.executeQuery();
			if(rs.next()) {
				System.out.println("로그인 성공");
				//로그인을 성공하면 조회된 로그인 사용자의 레코드를 VO로 만들어서 리턴
				emp = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7));
			} else {
				System.out.println("로그인 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return emp;
	}
}
