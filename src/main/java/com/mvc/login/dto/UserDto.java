package com.mvc.login.dto;

import java.util.List;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.mvc.login.validation.ValidEmail;
import com.mvc.login.validation.ValidPassword;

import org.hibernate.validator.constraints.Length;

public class UserDto {

	private Long id;

	private String username;

	@NotNull
	@NotEmpty
	@Length(min = 3, message = "username have to be more than 3 characters")
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	@ValidPassword
	private String password;
	private String matchingPassword;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;

	@Nullable
	private List<UserAccountDto> accounts;

	private AddressDto primaryAddress;

	private AddressDto secondaryAddress;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccounts(List<UserAccountDto> accounts) {
		this.accounts = accounts;
	}


	public AddressDto getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(AddressDto primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public AddressDto getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(AddressDto secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public List<UserAccountDto> getAccounts() {
		return accounts;
	}

	public UserDto(Long id, String username,
			@NotNull @NotEmpty @Length(min = 3, message = "username have to be more than 3 characters") String firstName,
			@NotEmpty String lastName, @NotNull @NotEmpty String password, String matchingPassword,
			@NotNull @NotEmpty String email, List<UserAccountDto> accounts, AddressDto primaryAddress,
			AddressDto secondaryAddress) {
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.email = email;
		this.accounts = accounts;
		this.primaryAddress = primaryAddress;
		this.secondaryAddress = secondaryAddress;
	}

	public UserDto() {
	}

	// standard getters and setters
}