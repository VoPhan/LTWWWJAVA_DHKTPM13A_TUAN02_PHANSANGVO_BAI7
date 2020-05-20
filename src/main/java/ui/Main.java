package ui;

import dao.SinhVienDAO;
import entity.SinhVien;

public class Main {
	public static void main(String[] args) throws Exception {
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		
		SinhVien sinhVien = new SinhVien("002", "Nguyen Van B", "Nam", "1234567890", "Go Vap");
		sinhVienDAO.addSinhVien(sinhVien);
	}
}
