package com.simpleprogram;


import java.util.*;

public class User extends Object {
    private int id;
    private String name;

    private ProteinData proteinData = new ProteinData();
    private GoalAlert goalAlert;

    public GoalAlert getGoalAlert() {
        return goalAlert;
    }

    public void setGoalAlert(GoalAlert goalAlert) {
        this.goalAlert = goalAlert;
    }

    public User(){
        setProteinData(new ProteinData());
    }

//V4    private Collection<UserHistory> history = new ArrayList<UserHistory>() ;
//V2    private List<UserHistory> history = new ArrayList<UserHistory>() ;
//V3    private Map<String,UserHistory> history = new HashMap<String,UserHistory>() ;

    private List<UserHistory> history = new ArrayList<UserHistory>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProteinData getProteinData() {
        return proteinData;
    }


    public void setProteinData(ProteinData proteinData) {
        this.proteinData = proteinData;
        proteinData.setUser(this);
    }

//V2    public List<UserHistory> getHistory() {
//V3    public Map<String,UserHistory> getHistory() {
//V4    public Collection<UserHistory> getHistory() {
    public List<UserHistory> getHistory() {
        return history;
    }

//V2    public void setHistory(List<UserHistory> history) {
//V3    public void setHistory(Map<String,UserHistory> history) {
//V4    public void setHistory(Collection<UserHistory> history) {
    public void setHistory(List<UserHistory> history) {
        this.history = history;
    }

    public void addHistory(UserHistory historyItem){
        historyItem.setUser(this);
        history .add(historyItem);
    }
}
