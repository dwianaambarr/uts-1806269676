package com.apap.uts1806269676.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.uts1806269676.model.BukuModel;

public interface BukuDb extends JpaRepository<BukuModel, Long>{
	BukuModel findById(long id);
	BukuModel findByKode(String kode);
}
