package com.stone.domain;

public class User {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String sex;
    private String version;

    public User() {
    }

    public User(Long id, String name, String email, String address, String sex, String version) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
