package com.wint.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	//@Column(name="my_name")
    private String FirstName;
	private String lastName; 
	private  String email;
	private String password;
	private  String gender;
	
	
	private List<Integer> followers = new ArrayList<>();;
	
	private List<Integer> followings = new ArrayList<>();
	
	@ManyToMany
	private List<Post>savedPost= new ArrayList<>();
	

	



	
}
	