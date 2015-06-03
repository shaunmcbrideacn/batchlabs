/**
 * 
 */
package com.batchdemo.data;

import org.hibernate.validator.constraints.Email;

/**
 * @author shaun.mcbride
 *
 */
public class MailingListStageDto {
	
	private String firstName;
	
	private String lastName;
	
	@Email
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
