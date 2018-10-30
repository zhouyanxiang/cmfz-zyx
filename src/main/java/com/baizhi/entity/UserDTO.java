package com.baizhi.entity;

/**
 * Created by admin on 2018/10/29.
 */
public class UserDTO {

    private String province;
    private Integer count;

    @Override
    public String toString() {
        return "UserDTO{" +
                "province='" + province + '\'' +
                ", count=" + count +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UserDTO() {

    }

    public UserDTO(String province, Integer count) {

        this.province = province;
        this.count = count;
    }
}
