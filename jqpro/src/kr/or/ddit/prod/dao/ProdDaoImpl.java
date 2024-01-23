package kr.or.ddit.prod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.prod.vo.ProdVo;
import kr.or.ddit.util.JDBCUtil3;

public class ProdDaoImpl implements IProdDao {
	
	// 싱글톤 참조변수 
	private static IProdDao instance;
	
	// 생성자
	private ProdDaoImpl() { }
	
	// 싱글톤 인스턴스 생성 외부접근 메서드
	public static IProdDao getInstance() {
		if(instance == null) instance = new ProdDaoImpl();
		return instance;
	}

	@Override
	public List<ProdVo> selectByLguList(String lprod_lgu) {
		
		// DB 관련 변수 선언
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 반환될 prod 리스트
		List<ProdVo> prodList = null;
		
		String sql = "SELECT PROD_ID, PROD_NAME FROM PROD WHERE PROD_LGU = ?";
		System.out.println("[ProdDaoImpl.selectByLguList.Sql] SELECT PROD_ID, PROD_NAME FROM PROD WHERE PROD_LGU =" + lprod_lgu);
		
		try {
			conn = JDBCUtil3.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, lprod_lgu);
			rs = ps.executeQuery();
			prodList = new ArrayList<ProdVo>();
			
			while(rs.next()) {
				ProdVo vo = new ProdVo();
				
				vo.setProd_id(rs.getString("PROD_ID"));
				vo.setProd_name(rs.getString("PROD_NAME"));
				
				prodList.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
			if(ps != null) try { ps.close(); } catch(SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }
		}
		
		return prodList;
	}

	@Override
	public ProdVo selectByProdId(String prod_id) {
		
		// DB 관련 변수 선언
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 반환될 ProdVo 객체 선언
		ProdVo prodInfo = null;
		
		String sql = "SELECT * FROM PROD WHERE PROD_ID = ? ";
		System.out.println("[ProdDaoImpl.selectByProdId.Sql] SELECT * FROM PROD WHERE PROD_ID = " + prod_id);
		
		try {
			conn = JDBCUtil3.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, prod_id);
			rs = ps.executeQuery();
			prodInfo = new ProdVo();
			
			while(rs.next()) {
				prodInfo.setProd_id(rs.getString("PROD_ID"));
				prodInfo.setProd_name(rs.getString("PROD_NAME"));
				prodInfo.setProd_lgu(rs.getString("PROD_LGU"));
				prodInfo.setProd_buyer(rs.getString("PROD_BUYER"));
				prodInfo.setProd_cost(rs.getInt("PROD_COST"));
				prodInfo.setProd_price(rs.getInt("PROD_PRICE"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
			if(ps != null) try { ps.close(); } catch(SQLException e) { e.printStackTrace(); }
			if(conn != null) try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }
		}
		
		return prodInfo;
	}

}
