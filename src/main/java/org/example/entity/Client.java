package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column (name="name", nullable = false, unique=true, columnDefinition = "varchar not null check(length(name)>2 and length(name)<201)")
    @Column
    private String name;

    public void setName(String name) { this.name = name; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String toString() { return id +", "+ name; }

    public void setId(Long id) { this.id=id; }
}
