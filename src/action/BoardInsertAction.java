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
 * Servlet implementation class BoardInsertAction
 */
@WebServlet("/board/insert.do")
public class BoardInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String name 	= request.getParameter("name");
		String subject 	= request.getParameter("subject");
		String content 	= request.getParameter("content");
		String pwd   	= request.getParameter("pwd");
		String chk_info = request.getParameter("chk_info");
		
		String ip    	= request.getRemoteAddr();
		
		BoardVo  vo = new BoardVo(name, subject, content, pwd, chk_info, ip);
		
		int res = BoardDao.getInstance().insert(vo);
				
		response.sendRedirect("list.do");
		
	}

}
