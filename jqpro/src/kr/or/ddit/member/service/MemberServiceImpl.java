package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

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
	

	// 전체 리스트 가져오기
	@Override
	public List<MemberVo> getAllMember() {
		return dao.getAllMember();
	}

	// 사용자 회원정보 등록(회원가입)
	@Override
	public int insertMember(MemberVo memberVo) {
		return dao.insertMember(memberVo);
	}

	// 아이디 중복검사
	@Override
	public int selectIdChk(String memId) {
		System.out.println("[service] MemberServiceImpl.selectIdChk() 실행");
		return dao.selectIdChk(memId);
	}

	// 우편번호 검색
	@Override
	public List<ZipVo> selectSearchPost(String dong) {
		return dao.selectSearchPost(dong);
	}
	
}
