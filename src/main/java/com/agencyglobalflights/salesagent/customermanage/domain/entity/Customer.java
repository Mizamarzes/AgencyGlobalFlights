package com.agencyglobalflights.salesagent.customermanage.domain.entity;

public class Customer {
    private String id;
    private String name;
    private int age;
    private int doc_type;

    public Customer() {
    }

    public Customer(String id, String name, int age, int doc_type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doc_type = doc_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(int doc_type) {
        this.doc_type = doc_type;
    }   

}
