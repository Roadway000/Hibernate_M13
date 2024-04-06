package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table (name = "planet")
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z]*[0-9]*$", message = "Planet.id {} can be only in upper case and digitas characters. For example MWA123")
    private String id;

    @Column (name="name", nullable = false, unique=true)
    @Size(min = 1, max = 500, message = "Planet.name {} must be between 1 and 500 characters")
    private String name;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String toString() { return id +", "+ name; }
}
