package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVo;

public class BoardDao {
	
	SqlSessionFactory factory;
	
	//single-ton pattern 
	static BoardDao single = null;

	public static BoardDao getInstance() {
		if (single == null) 
			single = new BoardDao();
		return single;
	}

	public BoardDao(){
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<BoardVo> selectList(){
		
		List<BoardVo> list=null;
		
		SqlSession sqlSession = factory.openSession();
	
		list = sqlSession.selectList("board_list");
		
		sqlSession.close();
		
		return list;
	}
	
	public List<BoardVo> selectList(Map map) {
        
		List<BoardVo> list=null;
		
		SqlSession sqlSession = factory.openSession();
		                       
		list = sqlSession.selectList("board_condition_list",map);
		
		sqlSession.close();
		
		return list;
	}
	

	public BoardVo selectOne(int idx) {
		// TODO Auto-generated method stub
		
		BoardVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		                        
		vo = sqlSession.selectOne("board_one",idx);
		
		sqlSession.close();
		
		return vo;
	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);                          
		
		res = sqlSession.update("board_readhit",idx);
		
		sqlSession.close();
		 
		return res;
	}

	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("board_insert",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int update_step(BoardVo baseVo) {
		// TODO Auto-generated method stub
		int res = 0;                  
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("board_update_step",baseVo);
		
		sqlSession.close();
		
		return res;
	}

	public int reply(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;                       
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("board_reply",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;                            // true : auto commit
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("board_delete",idx);
		
		sqlSession.close();
		
		return res;
	}

	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;                            // true : auto commit
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("board_update",vo);
		
		sqlSession.close();
		
		return res;
	}

	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		int total = 0;
		
		SqlSession sqlSession = factory.openSession();
		
		total = sqlSession.selectOne("board_row_total",map);
		
		sqlSession.close();
		
		return total;
	}
	
}
