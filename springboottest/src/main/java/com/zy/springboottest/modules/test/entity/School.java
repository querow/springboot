package com.zy.springboottest.modules.test.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="h_school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolId;
    private String schoolName;
    @Transient
    private String region;
    @OneToMany(mappedBy = "school",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    private List<Class> classes;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
