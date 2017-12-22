package action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.CommentDao;

/**
 * Servlet implementation class BoardDeleteAction
 */
@WebServlet("/board/delete.do")
public class BoardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		int res = CommentDao.getInstance().delete_all(idx);
		 res = BoardDao.getInstance().delete(idx);
		
		search_text = URLEncoder.encode(search_text, "utf-8");
				
		String sendUrl = String.format("list.do?page=%d&search=%s&search_text=%s", page,  search,search_text);

		response.sendRedirect(sendUrl);
					
	}

}
