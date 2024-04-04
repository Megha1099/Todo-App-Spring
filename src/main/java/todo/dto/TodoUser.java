package todo.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import todo.helper.AES;

@Entity
@Data
public class TodoUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private long mobile;
	private LocalDate dob;
	private String gender;
	
	/*cuz in spring 5 version date will not be converted to string internally, so we are overriding the set method and converting it to string . if u did'nt follow this will get the 400 error.
	we can do it in other way that, like by changing the name in form as date and then setting it using the @reqparam annotation. 
	*/
	public void setDob(String dob)
	{
		this.dob=LocalDate.parse(dob);
	}

	public String getPassword() {
		return AES.decrypt(password, "123");
	}

	public void setPassword(String password) {
		this.password = AES.encrypt(password, "123");
	}

}
