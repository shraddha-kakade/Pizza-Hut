package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "admin_id")
	private Long adminId;

	@Column(unique = true,nullable = false)
	private String email;

	@Column(length = 20, nullable = false)
	private String password;

	@Column(length = 20,name = "admin_name",nullable = false)
	private String adminName;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long adminId, String email, String password, String adminName) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
		this.adminName = adminName;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", password=" + password + ", adminName=" + adminName
				+ "]";
	}
	
	

}
