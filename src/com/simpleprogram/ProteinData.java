package com.simpleprogram;


public class ProteinData extends Object {

    private int id;
    private User user;
    private int total;
    private int goal;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProteinData() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public int getGoal() {
        return goal;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    public void setGoal(int goal) {
        this.goal = goal;
    }
}
