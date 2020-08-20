package com.zy.springboottest.modules.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "h_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createDate;
    @OneToOne(targetEntity = Card.class,cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "card_Id")
    private Card studentCard;
    @ManyToMany(mappedBy = "students",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    private List<Class> classes;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Card getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(Card studentCard) {
        this.studentCard = studentCard;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
