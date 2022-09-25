package com.alidaodao.app.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author bosong
 * @since 2022-09-25
 */
public class BaseVO implements Serializable {

    private Integer id;

    private String name;


    public BaseVO() {
    }

    public BaseVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVO baseVO = (BaseVO) o;
        return Objects.equals(id, baseVO.id) && Objects.equals(name, baseVO.name);
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
