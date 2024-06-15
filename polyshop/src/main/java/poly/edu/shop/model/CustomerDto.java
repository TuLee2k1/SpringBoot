package poly.edu.shop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto implements Serializable{

	private int customerId;
	@NotEmpty
	@Length(min = 6)
	private String name;
	@NotEmpty
	@Length(max = 50)
	private String email;
	@NotEmpty
	@Length(min = 6)
	private String password;
	@NotEmpty
	@Length(min = 10, max = 11)
	private String phone;

	private Date registeredDate;

	private short status;
	
	private Boolean isEdit = false;

	
}
