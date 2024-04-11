package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;
}
