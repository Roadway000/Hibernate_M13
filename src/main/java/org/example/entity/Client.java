package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, unique=true)
    @Size(min = 3, max = 200, message = "Client.name {} must be between 3 and 200 characters")
    private String name;

    public void setName(String name) { this.name = name; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String toString() { return id +", "+ name; }

    public void setId(Long id) { this.id=id; }
}
