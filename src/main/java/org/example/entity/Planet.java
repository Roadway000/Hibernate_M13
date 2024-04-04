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
@Table (name = "planet")
public class Planet {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
//    @Column (name="name", nullable = false, unique=true, columnDefinition = "varchar not null check(length(name)>0 and length(name)<501)")
    @Column (name="name", nullable = false, unique=true)
    private String name;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String toString() { return id +", "+ name; }
}
