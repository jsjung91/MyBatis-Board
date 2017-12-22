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
 * Servlet implementation class BoardReplyAction
 */
@WebServlet("/board/reply.do")
public class BoardReplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		// Param 값 받기 
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String name 	= request.getParameter("name");
		String subject 	= request.getParameter("subject");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");
		String chk_info    = request.getParameter("chk_info");
		
		String ip 		= request.getRemoteAddr();
		
		BoardDao dao = BoardDao.getInstance();
		
		BoardVo baseVo = dao.selectOne(idx);
		
		int res = dao.update_step(baseVo);
		
		BoardVo vo = new BoardVo(name, subject, content, pwd, chk_info, ip);
		vo.setRef(baseVo.getRef());
		vo.setStep(baseVo.getStep()+1);
		vo.setDepth(baseVo.getDepth()+1);
		
		//6.DB reply
		res = dao.reply(vo);
		
		response.sendRedirect("list.do");

	}

}
