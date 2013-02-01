package com.equalexperts.mybatisimport;

public class MyData {

    private Integer id = null;
    private String name = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("MyData with id: %d, name: %s", id, name);
    }

}
