package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.ddit.buyer.vo.BuyerVo;
import kr.or.ddit.util.MyBatisUtil;

public class BuyerDaoImpl implements IBuyerDao {
	//static Logger logger = Logger.getLogger(BuyerDaoImpl.class);
	
	// 싱글톤 - BuyerDaoImpl 참조변수 선언
	private static IBuyerDao instance = null;
	
	// 생성자 명시
	private BuyerDaoImpl() { }

	// 싱글톤 - 외부에서 인스턴스 생성토록 접근 가능한 메서드
	public static IBuyerDao getInstance() {
		System.out.println("[Dao] BuyerDaoImpl.getInstance() 호출");
		if(instance == null) instance = new BuyerDaoImpl();
		return instance;
	}
	
	
	// 거래처명 목록 조회
	@Override
	public List<BuyerVo> selectBuyerList() {
		System.out.println("[Dao] BuyerDaoImpl.selectBuyerList() 호출");
		SqlSession session = null;
		List<BuyerVo> list = null;
		try {
			
			System.out.println("[Dao] MyBatisUtil.getSqlSession() 호출");
			session = MyBatisUtil.getSqlSession();
			
			System.out.println("세션과 맵사이");
			
			list = session.selectList("buyer.selectBuyerList");
			
			if(list.isEmpty() || list == null) {
				System.out.println("조회 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

	// 거래처 상세정보 조회
	@Override
	public BuyerVo selectBuyerInfo(String buyerId) {
		SqlSession session = null;
		BuyerVo vo = null;
		
		try {
			
			session = MyBatisUtil.getSqlSession();
			vo = session.selectOne("buyer.selectBuyerInfo", buyerId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return vo;
	}

}
