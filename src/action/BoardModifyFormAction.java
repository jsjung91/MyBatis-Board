package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

/**
 * Servlet implementation class BoardReplyFormAction
 */
@WebServlet("/board/modify_form.do")
public class BoardModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardVo vo = BoardDao.getInstance().selectOne(idx);
		
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("board_modify.jsp")
		       .forward(request, response);
		
		
	}

}
