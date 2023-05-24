package e1_onetoone_hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String pannumber;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", name=" + name + ", email=" + email + ", pannumber=" + pannumber + ", phone="
				+ phone + "]";
	}
	public PanCard(String name, String email, String pannumber, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.pannumber = pannumber;
		this.phone = phone;
	}
	public PanCard() {
		super();
	}

	
}
