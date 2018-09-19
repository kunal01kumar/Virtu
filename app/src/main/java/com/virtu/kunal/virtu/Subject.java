package com.virtu.kunal.virtu;

public class Subject {
    private String name;
    private String code;
    private String batch;
    private boolean exam;
    private String employee;

    public Subject(String name, String code, String batch, boolean exam, String employee) {
        this.name = name;
        this.code = code;
        this.batch = batch;
        this.exam = exam;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getBatch() {
        return batch;
    }

    public boolean isExam() {
        return exam;
    }

    public String getEmployee() {
        return employee;
    }
}
