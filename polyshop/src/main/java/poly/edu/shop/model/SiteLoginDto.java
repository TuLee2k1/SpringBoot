package poly.edu.shop.model;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SiteLoginDto {
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	
	private Boolean rememberMe= false;
}
