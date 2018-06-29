package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Hobby {
    private Long id;
    private String name;
    private Set<Sawon> sawons;
    public Hobby() {}
    public Hobby(String name) {
        this.name = name;
    }
    public Hobby(Long id, String name) {
        this.id = id; this.name = name;
    }
    public Hobby(Long id, String name, Set<Sawon> sawons) {
        this.id = id;
        this.name = name;
        this.sawons = sawons;
    }
    @Id
    @GeneratedValue
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name)
    {
        this.name = name;

    }
    @ManyToMany(mappedBy = "hobbies")
    public Set<Sawon> getSawons() {
        return sawons;
    }
    public void setSawons(Set<Sawon> sawons) {
        this.sawons = sawons;
    }
}
