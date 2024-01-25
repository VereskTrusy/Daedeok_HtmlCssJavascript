package kr.or.ddit.lprod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVo;
import kr.or.ddit.util.JDBCUtil3;

public class LprodDaoImpl implements ILprodDao {

	// 싱글톤 자신의 객체
	private static ILprodDao instance = null;
	
	// 생성자
	private LprodDaoImpl() { }
	
	// 자신의 객체를 생성하고 리턴하는 메소드
	public static ILprodDao getInstance() {
		if(instance == null) instance = new LprodDaoImpl();
		return instance;
	}
	
	// DB연결되는 객체들
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@Override
	public List<LprodVo> selectLprod() {
		// 반환될 리스트 객체 
		List<LprodVo> list = new ArrayList<LprodVo>();
		
		// SQL 문
		String sql = "SELECT * FROM LPROD";
		System.out.println("[SQL]     [LprodDaoImpl.selectLprod.Sql] SELECT * FROM LPROD");
		
		// DB 조회 및 데이터 획득
		try {
			conn = JDBCUtil3.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LprodVo lprodVo = new LprodVo();
				
				lprodVo.setLprod_id(rs.getInt("LPROD_ID"));
				lprodVo.setLprod_gu(rs.getString("LPROD_GU"));
				lprodVo.setLprod_nm(rs.getString("LPROD_NM"));
				
				list.add(lprodVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }}
			if(ps != null) { try { ps.close(); } catch(SQLException e) { e.printStackTrace(); }}
			if(conn != null) { try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }}
		}
		
		// 반환
		return list;
	}

}
