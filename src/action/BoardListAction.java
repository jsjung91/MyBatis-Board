package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import util.Paging;
import vo.BoardVo;

/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/board/list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final int BLOCK_LIST = 10;//1 Page당 게시물 갯수
	final int BLOCK_PAGE = 3;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
						
		int current_page=1;
		String strPage = request.getParameter("page");
		if(strPage!=null && !strPage.isEmpty())
		  current_page = Integer.parseInt(strPage);
		
		int start  = (current_page-1)*BLOCK_LIST + 1;
		int end    = start + BLOCK_LIST -1;
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		if(search!=null && !search.isEmpty()){
			if(search.equals("subject_content_name")){
				map.put("subject", search_text);
				map.put("content", search_text);
				map.put("name", search_text);
			}else if(search.equals("name")){
				map.put("name", search_text);
			}else if(search.equals("subject")){
				map.put("subject", search_text);
			}else if(search.equals("content")){
				map.put("content", search_text);
			}
		}		
		
		BoardDao dao = BoardDao.getInstance();
		
		int rowTotal = dao.selectRowTotal(map);
		
		//System.out.println(rowTotal);
	
		String search_param 
		      = String.format("search=%s&search_text=%s", search,search_text);
		
		String menuPage = Paging.getPaging(
						"list.do", 
						search_param, 
						current_page, 
						rowTotal,    
						BLOCK_LIST, 
						BLOCK_PAGE);

		//System.out.println(menuPage);
		
		List<BoardVo> list = dao.selectList(map); 
		
		request.getSession().removeAttribute("view_idx");
				
		//request binding
		request.setAttribute("list", list);
		request.setAttribute("menuPage", menuPage);
		
		//board_list.jsp  forward
		request.getRequestDispatcher("board_list.jsp")
		       .forward(request, response);
	}

}
