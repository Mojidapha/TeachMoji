package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Film;

@Repository //ใช้เพื่อการเชื่อมต่อ DB
public interface FilmRepository extends JpaRepository<Film, Integer>{ //ตัวที่ extends มานั้นเป็นชุดคำสั่งที่มีอยู่แล้วโดยใน <จะใส่ชื่อจาก class Film, Integer เพราะเราจะ return filmId เพราะใน DB เก็บ id เป็น int>

	List<Film> findByRentalDurationAndRating(Integer rentalDuration,String rating); 
}
