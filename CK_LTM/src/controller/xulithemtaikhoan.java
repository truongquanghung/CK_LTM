package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.AccountDAO;

/**
 * Servlet implementation class xulithemtaikhoan
 */
@WebServlet("/xulithemtaikhoan")
public class xulithemtaikhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xulithemtaikhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String passagain = request.getParameter("passagain");
		if (name.isEmpty()||pass.isEmpty()||passagain.isEmpty()) {
			request.getSession().setAttribute("error","Phải nhập đủ dữ liệu!");
			response.sendRedirect("themtaikhoan.jsp");
		} 
		else if (!pass.equals(passagain)) {
			request.getSession().setAttribute("error","Mật khẩu nhập lại chưa khớp!");
			response.sendRedirect("themtaikhoan.jsp");
		} 
		else if(AccountDAO.checkUsername(name)) {
			request.getSession().setAttribute("error","Tên đăng nhập đã tồn tại, chọn tên khác!");
			response.sendRedirect("themtaikhoan.jsp");
		}
		else {
			AccountDAO.setAccount(name,pass);
			response.sendRedirect("xulidanhsach");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
