package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVo;

public interface IProdService {
	// 
	List<ProdVo> selectByLguList(String lprod_lgu);
	
	// 
	public ProdVo selectByProdId(String prod_id);
}
