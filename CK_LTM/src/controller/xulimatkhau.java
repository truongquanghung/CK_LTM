package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.AccountBO;
import model.DAO.AccountDAO;
import model.bean.Account;

/**
 * Servlet implementation class xulimatkhau
 */
@WebServlet("/xulimatkhau")
public class xulimatkhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xulimatkhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String passagain = request.getParameter("passagain");
		if (oldpass.isEmpty()||newpass.isEmpty()||passagain.isEmpty()) {
			request.getSession().setAttribute("error","Phải nhập đủ dữ liệu!");
			response.sendRedirect("doimatkhau.jsp");
		}
		else if (!newpass.equals(passagain)) {
			request.getSession().setAttribute("error","Mật khẩu mới nhập lại chưa khớp!");
			response.sendRedirect("doimatkhau.jsp");
		}
		else {
			Account account =  (Account) AccountBO.getAccount(request.getSession().getAttribute("login").toString(),oldpass);
			if (account==null) {
				request.getSession().setAttribute("error","Mật khẩu cũ không chính xác!");
				response.sendRedirect("doimatkhau.jsp");
			}
			else {
				AccountDAO.editAccount(request.getSession().getAttribute("login").toString(),newpass);
				response.sendRedirect("doimatkhauthanhcong.jsp");
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
