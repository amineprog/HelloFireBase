package com.amine.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author AMINE IT
 */
public class Category {

    private String id;
    private String name;
    private ArrayList<Course> listCourses;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
        this.listCourses = new ArrayList<>();
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        //return "Category{" + "id=" + id + ", name=" + name + '}';
        return getName();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void addCourse(Course c) {
        this.listCourses.add(c);
    }

    public Course getCourse(Course obj) {
        return this.listCourses.get(this.listCourses.indexOf(obj));
    }

    public ArrayList<Course> getListCourses() {
        return listCourses;
    }

    public void setListCourses(ArrayList<Course> listCourses) {
        this.listCourses = listCourses;
    }

}
