package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.CommentDao;
import vo.BoardVo;
import vo.CommentVo;

/**
 * Servlet implementation class BoardViewAction
 */
@WebServlet("/board/view.do")
public class BoardViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
		List<CommentVo> c_list = CommentDao.getInstance().selectList(idx);
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("view_idx")==null){
			BoardDao.getInstance().update_readhit(idx);
			session.setAttribute("view_idx", idx);
		}
		
		//Data binding
		request.setAttribute("vo", vo);
		request.setAttribute("c_list", c_list);
		
		//Forward
		request.getRequestDispatcher("board_view.jsp")
		       .forward(request, response);
		
	}

}
