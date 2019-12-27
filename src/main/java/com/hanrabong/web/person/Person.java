package com.hanrabong.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PERSON",
uniqueConstraints={
@UniqueConstraint(
       columnNames={"USERID"}
)
})
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "Id", nullable=false) private Long id;
	@Column(name = "USERId", length = 64, nullable=false) private String userid;
	@Column(name = "PASSWD", length = 64, nullable=false) private String passwd;
	@Column(name = "NAME", length = 64, nullable=false) private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", nullable=false) private Date birthday;
	@Column(name = "MALE", nullable=false) private boolean male;
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}

	@Column(name = "HAK", nullable=false) private int hak;
	@Column(name = "BAN", nullable=false) private int ban;
	@Column(name = "SCORE", nullable=false) private int score;
	
	@Column(name = "ROLE", nullable=false) private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setHak(int hak) {
		this.hak = hak;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getHak() {
		return hak;
	}
	public int getBan() {
		return ban;
	}
	public int getScore() {
		return score;
	}
	
	enum Level {
		HIGH, MID, LOW
	}
	
}
