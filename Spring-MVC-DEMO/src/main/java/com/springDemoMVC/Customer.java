package com.springDemoMVC;


import com.springDemoMVC.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotEmpty(message = "is required")
    @Size(min=1)
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "minimum value is equal to 0 or greater")
    @Max(value = 10,message = "should not exceed 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message="only  characters/digits of length 5")
    private String postalCode;

    @CourseCode(value="zemoso",message="please enter ")
    private String courseCode;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
