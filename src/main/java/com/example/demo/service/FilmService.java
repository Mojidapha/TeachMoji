package com.example.demo.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Film;
import com.example.demo.model.filmBean;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmService {
	@Autowired FilmRepository filmRepos;
	
	@Transactional
	public void addFilm(filmBean filmBean) {
		Film film = new Film();
		// film.setTitle("DINOSAUR"); ถ้าใช้ film จะใช้อันนี้ แต่อาจเกิดการเปลี่ยนแปลงในไฟล์ film จึงใช้ตัวอื่น
		//BeanUtils.copyProperties(filmBean, film);		
		film.setTitle(filmBean.getTitle());
		film.setDescription(filmBean.getDescription());
		film.setReleaseYear(filmBean.getReleaseYear());
		film.setLanguageId(filmBean.getLanguageId());
		film.setOriginalLanguageId(filmBean.getOriginalLanguageId());
		film.setRentalDuration(filmBean.getRentalDuration());
		film.setRentalRate(filmBean.getRentalRate());
		film.setLength(filmBean.getLength());
		film.setReplacementCost(filmBean.getReplacementCost());
		film.setRating(filmBean.getRating());
		film.setSpecialFeatures(filmBean.getSpecialFeatures());
		film.setLastUpdate(new Date());
		
		filmRepos.save(film);
	}
	
	@Transactional
	public void editFilm(filmBean filmBean) {
		Film film = filmRepos.getOne(filmBean.getFilmId());	
		film.setTitle(filmBean.getTitle());
		film.setDescription(filmBean.getDescription());
		film.setReleaseYear(filmBean.getReleaseYear());
		film.setLanguageId(filmBean.getLanguageId());
		film.setOriginalLanguageId(filmBean.getOriginalLanguageId());
		film.setRentalDuration(filmBean.getRentalDuration());
		film.setRentalRate(filmBean.getRentalRate());
		film.setLength(filmBean.getLength());
		film.setReplacementCost(filmBean.getReplacementCost());
		film.setRating(filmBean.getRating());
		film.setSpecialFeatures(filmBean.getSpecialFeatures());
		film.setLastUpdate(new Date());
		
		filmRepos.save(film); //เป็นการบันทึก .save() มีเมธอดนี้อยู่แล้วไม่ต้องสร้างเอง
		
	}
	
	@Transactional
	public void delFilm(Integer filmId) {
		filmRepos.deleteById(filmId); //เป็นการลบ .deleteById(id) มีเมธอดนี้อยู่แล้วไม่ต้องสร้างเอง
		
		
	}
}