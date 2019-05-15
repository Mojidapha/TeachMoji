package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Film;
import com.example.demo.model.GreetingModel;
import com.example.demo.model.Status;
import com.example.demo.model.filmBean;
import com.example.demo.repository.FilmRepository;
import com.example.demo.service.FilmService;

@RestController
@RequestMapping("/api")
public class AppRestController {
	
	@Autowired FilmRepository filmRepos;
	
	@Autowired FilmService filmService;
	
	@RequestMapping(value="/greetingWord",method=RequestMethod.GET)
	public GreetingModel getGreetingWord() {
		
		GreetingModel model = new GreetingModel();
		
		String words = "Hello my name is moji";
		
		model.setWords(words);
		
		return model;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/allFilms",method=RequestMethod.GET)
	public List<Film> allFilm() { //เราต้องกำหนด returntype ตามที่เราจะส่งค่ากลับ จากอันนี้เราส่ง returntype List<Film> เพราะค่า result เป็น list
		
		List<Film> result = filmRepos.findAll();
		
		return result;
	}
	
	@RequestMapping(value="/addFilm",method=RequestMethod.POST)
	public Status addFilm(@RequestBody filmBean filmBean) { 
		
		filmService.addFilm(filmBean);
		Status status = new Status();
		status.setStatus("OK");
		
		return status;
	}
	
	@RequestMapping(value="/getFilmById",method=RequestMethod.GET)
	public filmBean editFilm(@RequestParam Integer filmId) { //@RequestParam ใช้กับ get
		Film film = filmRepos.getOne(filmId);	
		filmBean filmBean = new filmBean();
		filmBean.setFilmId(film.getFilmId());
		filmBean.setTitle(film.getTitle());
		filmBean.setDescription(film.getDescription());
		filmBean.setReleaseYear(film.getReleaseYear());
		filmBean.setLanguageId(film.getLanguageId());
		filmBean.setOriginalLanguageId(film.getOriginalLanguageId());
		filmBean.setRentalDuration(film.getRentalDuration());
		filmBean.setRentalRate(film.getRentalRate());
		filmBean.setLength(film.getLength());
		filmBean.setReplacementCost(film.getReplacementCost());
		filmBean.setRating(film.getRating());
		filmBean.setSpecialFeatures(film.getSpecialFeatures());
		filmBean.setLastUpdate(new Date());
		return filmBean;
	}
	
	@RequestMapping(value="/delFilm",method=RequestMethod.POST)
	public Status delFilm(@RequestBody Integer filmId) { 
		
		filmService.delFilm(filmId);
		Status status = new Status();
		status.setStatus("OK");
		
		return status;
	}
	
	
	@RequestMapping(value="/editFilm",method=RequestMethod.POST)
	public Status editFilm(@RequestBody filmBean filmBean) { //@RequestBody ใช้กับ post
		filmService.editFilm(filmBean);
		Status status = new Status();
		status.setStatus("OK");
		
		return status;
	}
	
}
