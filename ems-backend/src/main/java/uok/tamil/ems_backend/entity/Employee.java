package uok.tamil.ems_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@NoArgsConstructor

@Entity
@Table(name="empolyees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
    @Column(name="first_name")
 private String firstname;
    @Column(name="last_name")
 private String lastname;
    @Column(name="email",nullable = false,unique = true)
 private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(long id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}
