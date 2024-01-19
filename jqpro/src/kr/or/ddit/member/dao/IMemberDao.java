package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVo;

public interface IMemberDao {
	
	// 전체 리스트 가져오기
	public List<MemberVo> getAllMember();

}
