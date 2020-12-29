package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import model.BO.PictureBO;

/**
 * Servlet implementation class xulianh
 */
@WebServlet("/xulianh")
@MultipartConfig
public class xulianh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xulianh() {
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
						response.sendRedirect("chuyenanh.jsp");
					} else {
						BufferedImage img_old = ImageIO.read(bis);
						BufferedImage img_new = PictureBO.get(img_old);
						ByteArrayOutputStream output = new ByteArrayOutputStream();
						ImageIO.write(img_new, "jpg", output);
						String imageAsBase64 = Base64.getEncoder().encodeToString(output.toByteArray());
						request.setAttribute("imageAsBase64", imageAsBase64);
						RequestDispatcher rd = request.getRequestDispatcher("chuyenanh.jsp");
						rd.forward(request, response);
					}
				}
		} catch (Exception e) {
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
