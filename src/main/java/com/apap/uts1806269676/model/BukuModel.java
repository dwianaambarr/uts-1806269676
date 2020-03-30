package com.apap.uts1806269676.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	@Table(name = "buku")
	public class BukuModel implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size(max = 5)
		@Column(name = "kode", nullable = false, unique = true)
		private String kode;
		
		@NotNull
		@Size(max = 150)
		@Column(name = "judul", nullable = false)
		private String judul;
		
		@NotNull
		@Column(name = "jenis", nullable = false)
		private int jenis;
		
		@NotNull
		@Column(name = "tanggal_terbit", nullable = false)
		private Date tanggal_terbit;
		
		@NotNull
		@Size(max = 50)
		@Column(name = "pengarang")
		private String pengarang;
		
		@NotNull
		@Size(max = 50)
		@Column(name = "penerbit")
		private String penerbit;
		
		@NotNull
		@Size(max = 500)
		@Column(name = "abstrak")
		private String abstrak;
		
		@NotNull
		@Column(name = "status", nullable = false)
		private int status;
		
//		List<BukuModel> bukuList = new ArrayList<BukuModel>();

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getKode() {
			return kode;
		}

		public void setKode(String kode) {
			this.kode = kode;
		}

		public String getJudul() {
			return judul;
		}

		public void setJudul(String judul) {
			this.judul = judul;
		}

		public int getJenis() {
			return jenis;
		}

		public void setJenis(int jenis) {
			this.jenis = jenis;
		}

		public Date getTanggal_terbit() {
			return tanggal_terbit;
		}

		public void setTanggal_terbit(Date tanggal_terbit) {
			this.tanggal_terbit = tanggal_terbit;
		}

		public String getPengarang() {
			return pengarang;
		}

		public void setPengarang(String pengarang) {
			this.pengarang = pengarang;
		}

		public String getPenerbit() {
			return penerbit;
		}

		public void setPenerbit(String penerbit) {
			this.penerbit = penerbit;
		}

		public String getAbstrak() {
			return abstrak;
		}

		public void setAbstrak(String abstrak) {
			this.abstrak = abstrak;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

//		public List<BukuModel> getBukuList() {
//			return bukuList;
//		}
//
//		public void setBukuList(List<BukuModel> bukuList) {
//			this.bukuList = bukuList;
//		}	  
		
		
	}
