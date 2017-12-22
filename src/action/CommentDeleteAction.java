package action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

/**
 * Servlet implementation class CommentDeleteAction
 */
@WebServlet("/board/comment_delete.do")
public class CommentDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//�Ķ���� ����
		int idx = Integer.parseInt(request.getParameter("idx"));
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int page = Integer.parseInt(request.getParameter("page"));
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		//��ۻ���
		int res = CommentDao.getInstance().delete(c_idx);
		
		//view.do�� �̵�
		//GET(QueryString)������� �ѱ�/Ư���������۽ÿ���
		//�������� ���õ� ���ڵ����� ��ȯ���Ѽ� ����
		search_text = URLEncoder.encode(search_text, "utf-8");
		
		String sendUrl = String.format("view.do?idx=%d&page=%d&search=%s&search_text=%s", 
				                                   idx,    page,  search,search_text);
		
		response.sendRedirect(sendUrl);
		
		
		
		
		
		
		
		
	}

}
