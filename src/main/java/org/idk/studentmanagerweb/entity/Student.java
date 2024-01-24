package org.idk.studentmanagerweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentid")
    private int id;
    @Column(name="firstname")
    @NotNull(message = "You need enter first name")
    private String firstName;
    @Column(name="lastname")
    @NotNull(message = "you need enter last name")
    private String lastName;
    @Column(name="dateofbirth")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "you need enter DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "you need choose gender")
    private Gender gender;
    @Column(name="address")
    @NotNull(message = "you need enter address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "classid")
    private SchoolClass schoolClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date  getDob() {
        return dob;
    }

    public void setDob(Date  dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", schoolClass=" + schoolClass +
                '}';
    }
}
