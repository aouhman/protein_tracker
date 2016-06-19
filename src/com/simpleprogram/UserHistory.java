package com.simpleprogram;

import javax.persistence.*;
import java.util.Date;

//V1
//@Entity
//@Table(name = "user_history", schema = "protein_tracker", catalog = "")
public class UserHistory {



    private int id;
    private User user;
    private Date entryTime;
    private String entry;

    public UserHistory() {
    }

    public UserHistory(Date entryTime, String entry) {
        this.entryTime = entryTime;
        this.entry = entry;
    }

//    @Id
//    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEntryTime(java.sql.Date entryTime) {
        this.entryTime = entryTime;
    }

//    @Basic
//    @Column(name = "ENTRY_TIME", nullable = true)
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
//
//    @Basic
//    @Column(name = "ENTRY", nullable = true, length = 255)
    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHistory that = (UserHistory) o;

        if (id != that.id) return false;
        if (entryTime != null ? !entryTime.equals(that.entryTime) : that.entryTime != null) return false;
        if (entry != null ? !entry.equals(that.entry) : that.entry != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = entryTime != null ? entryTime.hashCode() : 0;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}


