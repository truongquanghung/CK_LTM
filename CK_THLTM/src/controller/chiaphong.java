package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.danhsach;

/**
 * Servlet implementation class chiaphong
 */
@WebServlet("/chiaphong")
public class chiaphong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chiaphong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		danhsach ds = new danhsach();
		ds.setGv((XSSFWorkbook) request.getSession().getAttribute("gv"));
		ds.setPt((XSSFWorkbook) request.getSession().getAttribute("pt"));
		ds.xuly(request.getSession().getAttribute("ca").toString());
		request.getSession().setAttribute("dspc", ds.getDspc());
		request.getSession().setAttribute("dsgs", ds.getDsgs());
		response.sendRedirect("result.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
