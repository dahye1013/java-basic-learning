package guestbook.bean;

import java.util.Date;

import lombok.Data;

@Data //getter , setter를 자동으로 생성해준다.
public class GuestbookDTO {
	private String name= "이름없음" ;
			String email, homepage, subject, content;
	private Date date;
	private int seq;
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getHomepage() {
//		return homepage;
//	}
//	public void setHomepage(String homepage) {
//		this.homepage = homepage;
//	}
//	public String getSubject() {
//		return subject;
//	}
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	public int getSeq() {
//		return seq;
//	}
//	public void setSeq(int seq) {
//		this.seq = seq;
//	}
	
	
	
}
