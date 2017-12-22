package action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import vo.CommentVo;

/**
 * Servlet implementation class CommentInsertAction
 */
@WebServlet("/board/comment_insert.do")
public class CommentInsertAction extends HttpServlet {
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
		
		String c_name    = request.getParameter("c_name");
		String c_content = request.getParameter("c_content");
		String c_pwd     = request.getParameter("cc_pwd");
		
		String c_ip      = request.getRemoteAddr();
		
		//CommentVo 포장
		CommentVo vo = new CommentVo(idx, c_name, c_content, c_ip, c_pwd);
		
		//DB insert
		CommentDao.getInstance().insert(vo);
		
		search_text = URLEncoder.encode(search_text, "utf-8"); //검색어 한글 변환
		
		String sendUrl = String.format("view.do?idx=%d&page=%d&search=%s&search_text=%s", idx, page, search, search_text);
		
		response.sendRedirect(sendUrl);

	}

}
