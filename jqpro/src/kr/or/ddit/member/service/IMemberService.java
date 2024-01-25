package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.member.vo.ZipVo;

public interface IMemberService {
	
	// 전체 리스트 가져오기
	public List<MemberVo> getAllMember();
	
	// 아이디 중복검사
	public int selectIdChk(String memId);
	
	
	// 우편번호 검색
	public List<ZipVo> selectSearchPost(String dong);
	
	
	// 사용자 회원정보 등록(회원가입)
	public int insertMember(MemberVo memberVo);
	
}
