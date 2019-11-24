package com.domain;

/**
 * @author rosiezhao
 * @date 2019/11/24 9:54
 */
public class Emp {
    private int id;
    private String username;
    private int classname;
    private String sex;
    private int addtime;


    public Emp(int id, String username, int classname, String sex, int addtime) {
        this.id = id;
        this.username = username;
        this.classname = classname;
        this.sex = sex;
        this.addtime = addtime;
    }

    public Emp() {

    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", classname=" + classname +
                ", sex='" + sex + '\'' +
                ", addtime=" + addtime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getClassname() {
        return classname;
    }

    public void setClassname(int classname) {
        this.classname = classname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAddtime() {
        return addtime;
    }

    public void setAddtime(int addtime) {
        this.addtime = addtime;
    }
}
