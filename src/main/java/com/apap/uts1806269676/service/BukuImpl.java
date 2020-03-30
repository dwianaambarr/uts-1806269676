package com.apap.uts1806269676.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.uts1806269676.model.BukuModel;
import com.apap.uts1806269676.repository.BukuDb;

@Service
@Transactional
public class BukuImpl implements BukuService{
	@Autowired
	private BukuDb bukudb;
	
	
	@Override
	public void addBuku(BukuModel buku) {
		bukudb.save(buku);
	}

	
	@Override
	public List<BukuModel> getAllBuku() {
		return bukudb.findAll();
	}
	
	
	@Override
	public BukuModel getBukuById(long id) {
		return bukudb.findById(id);
	}
	
	@Override
	public BukuModel getBukuByKode(String kode) {
		return bukudb.findByKode(kode);
	}
	
	@Override
	public void updateBuku(String kode,BukuModel buku) {
		BukuModel old = this.getBukuByKode(kode);
		old.setJudul(buku.getJudul());
		old.setJenis(buku.getJenis());
		old.setTanggal_terbit(buku.getTanggal_terbit());
		old.setPengarang(buku.getPengarang());
		old.setPenerbit(buku.getPenerbit());
		old.setAbstrak(buku.getAbstrak());
		old.setStatus(buku.getStatus());
		bukudb.save(old);
	}
	
}
