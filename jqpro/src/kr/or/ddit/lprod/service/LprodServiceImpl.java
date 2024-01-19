package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVo;

public class LprodServiceImpl implements ILprodService {
	// dao 객체 선언
	private ILprodDao dao;
	
	// 싱글톤 - 서비스 객체 선언
	private static ILprodService instance;
	
	// 생성자
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getInstance();
	}
	
	// 인스턴스 생성
	public static ILprodService getInstance() {
		if(instance == null) instance = new LprodServiceImpl();
		return instance;
	}
	
	
	
	
	public List<LprodVo> selectLprod() {
		return dao.selectLprod();
	}
	
}
