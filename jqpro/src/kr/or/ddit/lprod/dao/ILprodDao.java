package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVo;

public interface ILprodDao {
	
	public List<LprodVo> selectLprod();
}
