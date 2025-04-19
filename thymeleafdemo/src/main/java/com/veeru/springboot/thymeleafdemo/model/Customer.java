package com.veeru.springboot.thymeleafdemo.model;

import com.veeru.springboot.thymeleafdemo.validations.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "Is Required")
    @Size(min=1, message="Is Required")
    private String lastName;

    @NotNull(message = "Is Required")
    @Min(value=0, message = "must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to ten")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    private String postalCode;

    @CourseCode(value="LUV", message = "must Start with LUV")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
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
}
