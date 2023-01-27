package com.backend.project.DTO.ContactDTOs;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class SendContactDTO {
	@NotEmpty
	@Size(min = 3, max = 250, message="DEVELOPER_BLOG.ERROR.EMAIL")
	private String email;
	
	@NotEmpty
	@Size(min = 3, message="DEVELOPER_BLOG.ERROR.NAME")
	private String name;
	
	@NotEmpty
	@Size(min = 10, max = 250, message="DEVELOPER_BLOG.ERROR.SUBJECT")
	private String subject;
	
	@NotEmpty
	@Size(min = 20, message="DEVELOPER_BLOG.ERROR.CONTENT")
	private String content;

	
	public SendContactDTO(@NotEmpty @Size(min = 3, max = 250, message = "DEVELOPER_BLOG.ERROR.EMAIL") String email,
			@NotEmpty @Size(min = 3, message = "DEVELOPER_BLOG.ERROR.NAME") String name,
			@NotEmpty @Size(min = 10, max = 250, message = "DEVELOPER_BLOG.ERROR.SUBJECT") String subject,
			@NotEmpty @Size(min = 20, message = "DEVELOPER_BLOG.ERROR.CONTENT") String content) {
	
		this.email = email;
		this.name = name;
		this.subject = subject;
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
