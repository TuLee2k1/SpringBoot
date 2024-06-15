package poly.com.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {

	private int productId;

	private String name;

	private int quantity;

	private double unitPrice;

	private String image;

	private String description;

	private double discount;

	private Date enteredDate;
	@Column(nullable = false)
	private short status;
	@Column(nullable = false)
	private int categoryId;
}
