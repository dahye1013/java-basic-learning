package com.jstl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor 
@AllArgsConstructor
public class PersonDTO {
	@NonNull
	private String name;
	private int age;
	
}
