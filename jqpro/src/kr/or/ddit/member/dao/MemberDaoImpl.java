package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImpl implements IMemberDao {
	
	// 싱글톤 - 변수
	private static IMemberDao dao;
	
	// 
	private MemberDaoImpl() {	}
	
	//
	public static IMemberDao getDao() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	// DB접근 실행 설정
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// 전체 리스트 가져오기
	@Override
	public List<MemberVo> getAllMember() {
		
		List<MemberVo> list = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		conn = JDBCUtil3.getConnection(); // 이전에 try-catch 했기때문에 필수는 아님
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			list = new ArrayList<MemberVo>();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				
				memberVo.setMem_id(rs.getString("MEM_ID"));
				memberVo.setMem_pass(rs.getString("MEM_PASS"));
				memberVo.setMem_name(rs.getString("MEM_NAME"));
				memberVo.setMem_bir(rs.getString("MEM_BIR"));
				memberVo.setMem_zip(rs.getString("MEM_ZIP"));
				memberVo.setMem_add1(rs.getString("MEM_ADD1"));
				memberVo.setMem_add2(rs.getString("MEM_ADD2"));
				memberVo.setMem_hp(rs.getString("MEM_HP"));
				memberVo.setMem_mail(rs.getString("MEM_MAIL"));
				
				list.add(memberVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }}
			if(ps != null) { try { ps.close(); } catch(SQLException e) { e.printStackTrace(); }}
			if(conn != null) { try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	

}
