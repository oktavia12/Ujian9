package com.juaracoding.ujianapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.ujianapi.Repository.BiodataRepository;
import com.juaracoding.ujianapi.entity.Biodata;

@RestController
@RequestMapping("/biodata")

public class BiodataController {
	@Autowired
	BiodataRepository biodataRepo;


@GetMapping("/")
public List<Biodata> getAll() {
	return (List<Biodata>) biodataRepo.findAll();
	
}

@GetMapping("/{title}")
public List<Biodata> getAllByName(@PathVariable String title) {
	return biodataRepo.findByName(title);
}

@PostMapping("/add")
public String addBuku(@RequestBody Biodata biodata) {
	biodataRepo.save(biodata);
	return "Insert Berhasil";
}

@DeleteMapping("/delete/{id}")
public String deleteBiodata(@PathVariable String id) {
	biodataRepo.deleteById(Long.parseLong(id));
	return "Delete Berhasil";
}

@PutMapping("/update/{id}")
public String updateBiodata(@PathVariable String id, @RequestBody Biodata biodata) {
	biodata.setId(Long.parseLong(id));
	biodataRepo.save(biodata);
	return "Update Berhasil";
}

}

