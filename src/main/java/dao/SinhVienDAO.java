package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.SinhVien;

public class SinhVienDAO {
	private EntityManager em;
	
	public SinhVienDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public boolean addSinhVien(SinhVien sv) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
	}
	
	public boolean updateSinhVien(SinhVien sv) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
	}
	
	public boolean deleteSinhVien(SinhVien sv) throws Exception{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(SinhVien.class, sv.getMaSV()));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			throw new Exception(e);
		}
	}
	
	public List<SinhVien> getSinhViens(){
		List<SinhVien> list = new ArrayList<SinhVien>();
		List<?> temp = em.createNativeQuery("db.sinhvien.find({})", SinhVien.class).getResultList();
		temp.forEach(x->{
			SinhVien sinhVien = (SinhVien)x;
			list.add(sinhVien);
		});
		return list;
	}
	
	public SinhVien getSinhVien(String masv) {
		return em.find(SinhVien.class, masv);
	}
}
