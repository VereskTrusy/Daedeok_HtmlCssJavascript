package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVo;

public interface IBuyerService {

	// 거래처명 목록 조회
	public List<BuyerVo> selectBuyerList();
	
	// 거래처 상세정보 조회
	public BuyerVo selectBuyerInfo(String buyerId);
}	
