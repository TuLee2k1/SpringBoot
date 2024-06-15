package edu.poly.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	
	@NotEmpty(message = "Không được để trống")
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;
	private boolean activated;
	private boolean admin;
	
	
}
