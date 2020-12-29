package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class xulifile
 */
@WebServlet("/xulifile")
public class xulifile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xulifile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
					.parseRequest(new ServletRequestContext(request));
			for (FileItem item : items)
				if (!item.isFormField()) {
					BufferedInputStream bis = new BufferedInputStream(item.getInputStream());
					if (item.getName().isEmpty()) {
						break;
					} else {
						XSSFWorkbook workbook = new XSSFWorkbook(bis);
						if (item.getFieldName().equals("gv"))
							request.getSession().setAttribute("gv", workbook);
						else
							request.getSession().setAttribute("pt", workbook);
					}
				} else {
					request.getSession().setAttribute("ca", item.getString());
				}
		} catch (Exception e) {
		}
		System.out.println(request.getSession().getAttribute("ca"));
		if (request.getSession().getAttribute("gv") == null || request.getSession().getAttribute("pt") == null
				|| request.getSession().getAttribute("ca").toString().isEmpty())
			response.sendRedirect("index.jsp");
		else
			response.sendRedirect("chiaphong");
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
