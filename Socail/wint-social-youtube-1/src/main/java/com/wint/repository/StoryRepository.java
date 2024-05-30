package com.wint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wint.models.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{
	
	//public List<Story> findByUserID(Integer userId);
	@Query("Select p from Story p where p.user.id=:id")
	List<Story>findByUserID(Integer id);
}
