package com.wint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wint.models.Reel;


public interface ReelRepository extends JpaRepository<Reel, Integer>{
	

		//@Query("Select p from Post p where p.user.id=:id")
		List<Reel>findRByuserId(Integer id);
		}
