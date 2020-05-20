package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SinhVienDAO;
import entity.SinhVien;

/**
 * Servlet implementation class SinhVienServlet
 */
@WebServlet("/SinhVienServlet")
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienDAO sinhvienDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienServlet() {
        sinhvienDAO = new SinhVienDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String command = request.getParameter("command");
		if(command == null)
			command = "LIST";
		
		switch (command) {
		case "LIST":
			listSinhvien(request, response);
			break;
		case "ADD":
			addSinhvien(request, response);
			break;
		case "DELETE":
			deleteSinhvien(request, response);
			break;
		case "LOAD":
			loadSinhvien(request, response);
		case "UPDATE":
			updateSinhvien(request, response);
		default:
			break;
		}
	}

	private void updateSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			String masv = request.getParameter("id");
			String hoTen = request.getParameter("txtHoTen");
			String gioiTinh = request.getParameter("gioitinh");
			String soDienThoai = request.getParameter("txtSoDienThoai");
			String diaChi = request.getParameter("txtDiaChi");
			
			SinhVien sinhVien = sinhvienDAO.getSinhVien(masv);
			sinhVien.setDiaChi(diaChi);
			sinhVien.setGioiTinh(gioiTinh);
			sinhVien.setHoTen(hoTen);
			sinhVien.setSoDienThoai(soDienThoai);
			
			boolean kq = sinhvienDAO.updateSinhVien(sinhVien);
			
			if(kq)
				response.sendRedirect("SinhVienServlet");
		} catch (Exception e) {
			new ServletException(e);
		}
	}

	private void loadSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			out.println("<h1>Cap nhat sinh vien</h1>");
			String id=request.getParameter("id");
			
			SinhVien sinhVien = sinhvienDAO.getSinhVien(id);
			
			out.print("<form action='SinhVienServlet?id=" + sinhVien.getMaSV() + "&command=UPDATE'" +" method='post'>");
			out.print(	"<html><body><table>"+
							"<tr><td></td><td><input type='hidden' name='id' value='"+sinhVien.getMaSV()+"'/></td></tr>" +
							"<tr><td>Ho ten:</td><td><input type='text' name='txtHoTen' value='"+sinhVien.getHoTen()+"'/></td></tr>");
							
			if(sinhVien.getGioiTinh().equalsIgnoreCase("Nam"))
				out.print("<tr>"
						+ "<td>Gioi tinh</td>"
						+ "<td><label><input type='radio' name='gioitinh' checked='checked' value='Nam'/>Nam</label></td>" 
						+ "<td><label><input type='radio' name='gioitinh' value='Nu'/>Nu</label></td>"
						+ "</tr>");
			else
				out.print("<tr>"
						+ "<td>Gioi tinh</td>"
						+ "<td><label><input type='radio' name='gioitinh' value='Nam'/>Nam</label></td>"
						+ "<td><label><input type='radio' checked='checked' name='gioitinh' value='Nu'/>Nu</label></td>"
						+ "</tr>");
			
			out.print("<tr><td>So dien thoai:</td><td><input type='text' name='txtSoDienThoai' value='"+sinhVien.getSoDienThoai()+"'/></td></tr>" +
							"<tr><td>Dia chi:</td><td><input type='text' name='txtDiaChi' value='"+sinhVien.getDiaChi()+"'/></td></tr>" +
							"<tr><td colspan='2'><input type='submit' value='Save'/></td></tr>" +
							"</table>" + 
							"</form></body></html>");
			
			out.close();
		} catch (Exception e) {
			new ServletException(e);
		}
	}

	private void deleteSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			String masv = request.getParameter("id");
			SinhVien sv = sinhvienDAO.getSinhVien(masv);
			boolean kq = sinhvienDAO.deleteSinhVien(sv);
			if(kq)
				response.sendRedirect("SinhVienServlet");
		}catch (Exception e) {
			new ServletException(e);
		}
	}

	private void listSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<SinhVien> list = sinhvienDAO.getSinhViens();
			PrintWriter out = response.getWriter();
			out.print("<a href='addSinhVien.jsp' style='text-decoration: none;'>Them moi sinh vien</a><br><br>");
			out.println("<table border='1' cellspacing='0' cellpadding='10px'><tr><th>Ma SV</th><th>Ho ten</th><th>Gioi tinh</th><th>So dien thoai</th><th>Dia chi</th><th>Action</th></tr>");
			for(SinhVien sv : list) {
				out.println("<tr><td>"+sv.getMaSV()+"</td><td>"+sv.getHoTen() +"</td><td>" + sv.getGioiTinh() +"</td><td>" + 
			sv.getSoDienThoai() +"</td><td>" + sv.getDiaChi() +
			"</td><td><a href='SinhVienServlet?id="+sv.getMaSV()+"&command=DELETE"+"'>Delete</a><br><a href='SinhVienServlet?id="+sv.getMaSV()+"&command=LOAD"+"'>Edit</a>"+"</td></tr>");
			}
			out.println("</table>");
		}catch (Exception e) {
			new ServletException(e);
		}
	}

	private void addSinhvien(HttpServletRequest request, HttpServletResponse response) {
		try {
			String masv = request.getParameter("masv");
			String hoten = request.getParameter("hoten");
			String gioitinh = request.getParameter("gioitinh");
			String phone = request.getParameter("phone");
			String diachi = request.getParameter("diachi");
			
			SinhVien sv = new SinhVien(masv, hoten, gioitinh, phone, diachi);
			
			boolean kq = sinhvienDAO.addSinhVien(sv);
			if(kq)
				response.sendRedirect("SinhVienServlet");
			}catch (Exception e) {
				new ServletException(e);
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
