package com.edityj.chapter2.EnumType;

public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    private int id;
    private String sex;

    public int getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    SexEnum(int i, String sex) {
        this.id = i;
        this.sex = sex;
    }

    public static SexEnum getSexById(int id){
        for(SexEnum sex : SexEnum.values()){
            if (sex.getId() ==id) {
               return sex;
            }
        }
        return null;
    }
}
