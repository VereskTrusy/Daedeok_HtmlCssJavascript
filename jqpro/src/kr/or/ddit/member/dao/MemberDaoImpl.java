package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;
import kr.or.ddit.util.JDBCUtil3;
import kr.or.ddit.util.MyBatisUtil;

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

	// 사용자 회원정보 등록(회원가입)
	@Override
	public int insertMember(MemberVo memberVo) {
		System.out.println(memberVo.toString());
		
		SqlSession session = null;
		int insertMemberCnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			insertMemberCnt = session.insert("member.insertMember", memberVo);
			
			if(insertMemberCnt > 0) {
				session.commit();
				System.out.println("[System] 사용자 정보를 등록 했습니다.");
			} else {
				session.rollback();
				System.out.println("[System] 사용자 정보를 등록에 실패 했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertMemberCnt;
	}

	// 아이디 중복검사
	@Override
	public int selectIdChk(String memId) {
		System.out.println("[dao] MemberDaoImpl.selectIdChk() 실행");
		SqlSession session = null;
		int selectIdChkCnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			selectIdChkCnt = session.selectOne("member.selectIdChk", memId);
			System.out.println("[dao] 조회결과 : " + memId);
			if(selectIdChkCnt > 0) {
				System.out.println("[System] 중복된 아이디가 있습니다.");
			} else {
				System.out.println("[System] 사용 가능한 아이디가 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return selectIdChkCnt;
	}

	// 우편번호 검색
	@Override
	public List<ZipVo> selectSearchPost(String dong) {
		
		SqlSession session = null;
		List<ZipVo> postList = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			postList = session.selectList("member.selectSearchPost", dong);
			
			if(postList == null || postList.isEmpty()) {
				System.out.println("[System] 우편번호 검색에 실패 했습니다.");
			} else {
				System.out.println("[System] 우편번호 검색이 되었습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return postList;
	}
	
	

}
