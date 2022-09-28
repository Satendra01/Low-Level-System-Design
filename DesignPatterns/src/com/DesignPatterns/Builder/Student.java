package com.DesignPatterns.Builder;


public class Student {
	   private String firstName;
	   private String lastName;
	   private String streetAddress;
	   private String streetAddress2;
	   private String city;
	   private String zipCode;
	   private String state;
	   private String major;
	   private Integer startYear;

	   public Student(String firstName, String lastName, String streetAddress, 
	                  String streetAddress2, String city, String zipCode, 
	                  String state, String major, Integer startYear) {
	       this.firstName = firstName;
	       this.lastName = lastName;
	       this.streetAddress = streetAddress;
	       this.streetAddress2 = streetAddress2;
	       this.city = city;
	       this.state = state;
	       this.zipCode = zipCode;
	       this.major = major;
	       this.startYear = startYear;
	   }

	   public String getFirstName() {
	       return firstName;
	   }

	   public String getLastName() {
	       return lastName;
	   }
	   public String getCity() {
	       return city;
	   }


	//Remaining getters excluded for brevity
	   
	   public static class StudentBuilder {
		   private String firstName;
		   private String lastName;
		   private String streetAddress;
		   private String streetAddress2;
		   private String city;
		   private String zipCode;
		   private String state;
		   private String major;
		   private int startYear;

		   StudentBuilder() {
		   }

		   public StudentBuilder withFirstName(String firstName) {
		       this.firstName = firstName;
		       return this;
		   }

		   public StudentBuilder withLastName(String lastName) {
		       this.lastName = lastName;
		       return this;
		   }

		   //Remaining functions excluded for brevity - Pattern remains the same.

		   public Student build() {
		       return new Student(firstName, lastName, streetAddress, streetAddress2, 
		                          city, zipCode, state, major, startYear);
		   }
		}
	   
	   
	   
	   public static void main(String[]args) {
	      Student student = new Student.StudentBuilder()
	              .withFirstName("Thornton")
	              .withLastName("Melon")
	              .build();
	      System.out.println(student.getFirstName());
	      System.out.println(student.getCity());
	   }
	}