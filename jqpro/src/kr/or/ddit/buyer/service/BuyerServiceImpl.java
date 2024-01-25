package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVo;

public class BuyerServiceImpl implements IBuyerService {
	private IBuyerDao dao = null;
	
	// 싱글톤 - BuyerServiceImpl 참조변수 선언
	private static IBuyerService instance = null;
	
	// 생성자
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	public static IBuyerService getInstance() {
		
		System.out.println("[Service] IBuyerService.getInstance 실행");
		if(instance == null) {
			System.out.println("[Service] instance is null");
			
			instance = new BuyerServiceImpl();
		}
		System.out.println("return instance 실행");
		return instance;
	}
	

	// 거래처명 목록 조회
	@Override
	public List<BuyerVo> selectBuyerList() {
		System.out.println("[Service] BuyerServiceImpl.selectBuyerList 호출");
		return dao.selectBuyerList();
	}

	// 거래처 상세정보 조회
	@Override
	public BuyerVo selectBuyerInfo(String buyerId) {
		return dao.selectBuyerInfo(buyerId);
	}

}
