package com.talkup.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "language", nullable = false)
    private String language;
    
    @Column(name = "level", nullable = false)
    private String level;
    
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    
    @OneToMany(mappedBy = "group")
    private List<GroupMembership> members;
    
    @OneToMany(mappedBy = "group")
    private List<TimeSlot> timeSlots;
    
    public Group() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }
}