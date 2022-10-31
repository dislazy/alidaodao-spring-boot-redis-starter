package com.alidaodao.app.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author jack
 * @since 2022-10-31
 */
public class PageDTO<T> implements Serializable {
    private static final long serialVersionUID = -9751525753723746L;

    private List<T> data;

    private Integer total;

    public PageDTO(List<T> data, Integer total) {
        this.data = data;
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageDTO<?> pageDTO = (PageDTO<?>) o;
        return Objects.equals(data, pageDTO.data) && Objects.equals(total, pageDTO.total);
    }


    @Override
    public String toString() {
        return "PageDTO{" +
                "data=" + data +
                ", total=" + total +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, total);
    }
}
