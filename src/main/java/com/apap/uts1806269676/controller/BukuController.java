package com.apap.uts1806269676.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.uts1806269676.model.BukuModel;
import com.apap.uts1806269676.service.BukuService;

/**
 * PustakawanController
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

@Controller
public class BukuController {
	
	@Autowired
	private BukuService bukuService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String viewPustakawan(Model model) {
		List<BukuModel> buku = bukuService.getAllBuku();
		String navigation = "UTS APAP 2020";
		model.addAttribute("navigation", navigation);
		model.addAttribute("buku", buku);
		return "home";
	}
	
	@RequestMapping(value = "/buku/{kode}", method = RequestMethod.GET)
	private String detail(@PathVariable(value = "kode") String kode, Model model) {
		BukuModel buku = bukuService.getBukuByKode(kode);
		String navigation = "Detail Buku";
		model.addAttribute("navigation", navigation);
		model.addAttribute("buku", buku);
		return "detail-buku";
	}
	
	@RequestMapping(value = "/buku/add", method = RequestMethod.GET)
	private String add(Model model) {
		String navigation = "Tambah Buku";
		BukuModel buku = new BukuModel();
		buku.setId(buku.getId());
		model.addAttribute("navigation", navigation);
		model.addAttribute("buku", buku);
		model.addAttribute("kode", buku.getKode());
		return "add-buku";	
	}

	@RequestMapping(value = "/buku/add", method = RequestMethod.POST)
	private String addBukuSubmit(@RequestParam(value = "kode", required = true) String kode,
			@ModelAttribute BukuModel buku, Model model) {
		bukuService.addBuku(buku);
		BukuModel bukuAdded = bukuService.getBukuByKode(kode);
		model.addAttribute("isAdded", true);
		model.addAttribute("buku", bukuAdded);
		return "view-buku";
	}
	
	@RequestMapping(value = "/buku/add", method = RequestMethod.POST, params={"submit"})
	private String addBukuSubmit(@ModelAttribute BukuModel buku, 
			@RequestParam(value = "kode", required = true) String kode, Model model) {
		String navigation = "Berhasil";
		bukuService.addBuku(buku);
		BukuModel tambahbuku = bukuService.getBukuByKode(kode);
		model.addAttribute("buku", tambahbuku);
		model.addAttribute("navigation", navigation);
		return "add-success";
	} 

	
	@RequestMapping(value = "/buku/update/{kode}", method = RequestMethod.GET)
	private String updateBuku(@PathVariable(value = "kode") String kode, Model model) {
		BukuModel old = bukuService.getBukuByKode(kode);
		String navigation = "Ubah Buku";
		model.addAttribute("navigation", navigation);
		model.addAttribute("old", old);
		model.addAttribute("new", new BukuModel());
		return "update-buku";
	}
	
	@RequestMapping(value = "/buku/update/{kode}", method = RequestMethod.POST)
	private String updateBuku(@ModelAttribute BukuModel newBuku, 
			@PathVariable(value = "kode") String kode, Model model) {
		bukuService.updateBuku(kode, newBuku);
		BukuModel buku = bukuService.getBukuByKode(kode);
		String navigation = "Berhasil";
		model.addAttribute("navigation", navigation);
		model.addAttribute("isUpdated", true);
		model.addAttribute("buku", buku);
		return "update-success";
	}
}
