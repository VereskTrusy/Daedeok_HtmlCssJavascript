package kr.or.ddit.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("kr/or/ddit/config/mybatis-config.xml");
			
			System.out.println("[MyBatisUtil] 리소스 획득");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			
			System.out.println("[MyBatisUtil] 빌드완료");
			
		} catch (Exception e) {
			System.out.println("[MyBatisUtil] 초기화 실패");
			e.printStackTrace();
		} finally {
			System.out.println("[MyBatisUtil] 자원 반납 실행");
			
			if(in != null){ try { in.close(); }catch(IOException e) {} }
		}		
	} // static 초기화 블럭 끝.
	
	
	// SqlSession객체를 반환하는 메서드 - DaoImpl에서 사용
	public static SqlSession getSqlSession() {     
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
