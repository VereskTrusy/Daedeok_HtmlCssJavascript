package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVo;

public class ProdServiceImpl implements IProdService {
	
	// Dao 객체
	private IProdDao dao;
	
	// 싱글톤 참조변수 선언
	private static IProdService instance;
	
	// 생성자
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	// 싱글톤 인스턴스 생성 외부접근 메서드
	public static IProdService getInstance() {
		if(instance == null) instance = new ProdServiceImpl();
		return instance;
	}
	

	@Override
	public List<ProdVo> selectByLguList(String lprod_lgu) {
		return dao.selectByLguList(lprod_lgu);
	}

	@Override
	public ProdVo selectByProdId(String prod_id) {
		return dao.selectByProdId(prod_id);
	}
	
}
