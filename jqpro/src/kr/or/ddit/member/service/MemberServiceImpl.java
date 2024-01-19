package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements IMemberService {
	
	// dao 객체가 필요 - dao 메소드 호출 - 결과값을 받아서 controller로 넘김
	private IMemberDao dao;
	
	// 싱글톤 자신의 객체
	private static IMemberService service;
	
	// 생성자 
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	// 싱글톤 - 인스턴스 생성 메서드
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	

	@Override
	public List<MemberVo> getAllMember() {
//		List<MemberVo> list = null;
//		list = dao.getAllMember();
//		return list;
		
		return dao.getAllMember();
	}
	
}
