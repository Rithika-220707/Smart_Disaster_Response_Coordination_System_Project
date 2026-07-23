package com.sfl.rescue_team_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="RescueTeam_Info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RescueTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String teamName;
    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private int teamSize;

    @ElementCollection
    @CollectionTable(name = "rescue_team_members", joinColumns = @JoinColumn(name = "team_id"))
    @Column(name = "member_name")
    private List<String> members;

    @Column(nullable = false)
    private boolean available;
}
