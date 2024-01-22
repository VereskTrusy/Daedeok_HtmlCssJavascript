package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVo;

public interface IProdDao {
	List<ProdVo> selectByLguList(String lprod_lgu);
	
	public ProdVo selectByProdId(String prod_id);
}
