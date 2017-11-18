package niit.projectbackend.projectbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@NotNull(message = "Name should not be null")
	@NotBlank(message = "Name should not be Blank")
	@Pattern(regexp = "[a-zA-Z]{4,}", message = "Name should contain only Alphabet")
	private String firstName;

	@NotNull(message = "Name should not be null")
	@NotBlank(message = "Name should not be Blank")
	@Pattern(regexp = "[a-zA-Z]{4,}", message = "Name should contain only Alphabet")
	private String lastName;

	@NotNull(message = "Password should not be null")
	@NotBlank(message = "Password should not be Blank")
	@Pattern(regexp="^.*(?=.{6,8})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$",message="Follow Instructions 1.Password length must be 6-8 characters 2.Password must have 1 Uppercase letter,1 Lowercase letter,1 Number,1 Special Character")
	private String password;

	@Transient
	private String confirmPassword;

	@Email(message = "Enter valid email Id")
	private String emailId;

	@Pattern(regexp = "[0-9]{10,10}", message = "Name should contain only Alphabet")
	private String mobileNo;

	private boolean is_Active;

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	private String role = "ROLE_CUSTOMER";
	@OneToOne
	private Cart cart;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}
