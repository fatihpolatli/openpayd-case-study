package com.mvc.login.dto;

/**
 * AddressDto
 */
public class AddressDto {

    private Long id;

    private String firstAddressLine;

    private String SecondAddressLine;

    private String city;

    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstAddressLine() {
        return firstAddressLine;
    }

    public void setFirstAddressLine(String firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public String getSecondAddressLine() {
        return SecondAddressLine;
    }

    public void setSecondAddressLine(String secondAddressLine) {
        SecondAddressLine = secondAddressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}