package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CommentVo;

public class CommentDao {
	//Mybatis
	SqlSessionFactory factory;
	
	//single-ton pattern 
	static CommentDao single = null;

	public static CommentDao getInstance() {
		if (single == null) 
			single = new CommentDao();
		return single;
	}
	
	public CommentDao(){
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<CommentVo> selectList(int idx){
		
		List<CommentVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("comment_list", idx);
		
		sqlSession.close();
		
		return list;
	}

	public CommentVo selectOne(int c_idx){
		
		CommentVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("comment_one", c_idx);
		
		sqlSession.close();
		
		return vo;
	}

	public int insert(CommentVo vo){
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("comment_insert", vo);
		
		sqlSession.close();
		
		return res;
		
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("comment_delete", c_idx);
		
		sqlSession.close();
		
		return res;
	}

	public int delete_all(int idx) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("comment_delete_all", idx);
		
		sqlSession.close();
		
		return res;
	}

}
