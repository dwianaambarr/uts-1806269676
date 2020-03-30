package com.apap.uts1806269676.service;

import java.util.List;

import com.apap.uts1806269676.model.BukuModel;

public interface BukuService {
	
	void addBuku(BukuModel buku);
	List<BukuModel> getAllBuku();
	void updateBuku(String kode, BukuModel buku);
	BukuModel getBukuById(long id);
	BukuModel getBukuByKode(String kode);

}
