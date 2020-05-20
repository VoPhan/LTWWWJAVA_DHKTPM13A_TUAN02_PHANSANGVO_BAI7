package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SinhVien
 *
 */
@Entity
@Table(name = "sinhvien")
public class SinhVien implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String maSV;
	private String hoTen;
	private String gioiTinh;
	private String soDienThoai;
	private String diaChi;
	
	public SinhVien() {
		super();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public SinhVien(String maSV, String hoTen, String gioiTinh, String soDienThoai, String diaChi) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + "]";
	}
	
}
