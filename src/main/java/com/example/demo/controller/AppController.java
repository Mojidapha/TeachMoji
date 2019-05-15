package com.example.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Film;
import com.example.demo.repository.FilmRepository;


@Controller
public class AppController {
	
	@Autowired FilmRepository filmRepos;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String Index(Model model,@RequestParam(required=false) Integer rentalDuration,@RequestParam(required=false) String rating) {
		Integer pRentalDuration = 3;  //เซ็ทค่าเป็น default ไว้
		String pRating = "G"; //เซ็ทค่าเป็น default ไว้
		
		if(!StringUtils.isBlank(rating)) { //เช็คว่ามีพารามิเตอร์ไหม
			pRating = rating;
		}
		if(null != rentalDuration) { //เช็คว่ามีพารามิเตอร์ไหม
			pRentalDuration = rentalDuration;
		}
		
		List<Film> result = filmRepos.findByRentalDurationAndRating(pRentalDuration, pRating); //สร้าง list 
		
		
		String words = "Hello my name is moji";
		
		model.addAttribute("greeting",words); //เพื่อเตรียมไว้ในการเรียกใช้ โดยจะเรียกใช้ในชื่อ greeting ที่เก็บค่าของ words
		model.addAttribute("filmList",result);
		
		return "index";
	}
	
	@RequestMapping(value="/rest",method=RequestMethod.GET)
	public String rest(Model model) {
		return "rest"; //ไปเรียกไฟล์ rest.html จะได้ข้อมูลตารางออกมา
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model, @RequestParam Integer filmId) {
		model.addAttribute("filmId",filmId);
		
		return "edit"; 
	}

}
