package com.talkup.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "teacher_profiles")
@Data
public class TeacherProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @Column(name = "qualifications", columnDefinition = "TEXT")
    private String qualifications;
    
    @Column(name = "experience", columnDefinition = "TEXT")
    private String experience;
    
    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography;
    
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    
    public TeacherProfile() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }
}