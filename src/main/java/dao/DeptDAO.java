package dao;

import org.apache.ibatis.session.SqlSession;

public class DeptDAO {
	//SqlSession
	private SqlSession sqlSession;
	
	//setter
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
