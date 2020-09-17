package com.bij.mymoneymanager.model;

import java.util.Date;
import java.util.List;

public class DayEntry {

    private int id;
    private Date date;
    private List<SingleEntry> inList ;
    private List<SingleEntry> outList ;

    public DayEntry() {
    }

    public DayEntry(int id, Date date, List<SingleEntry> inList, List<SingleEntry> outList) {
        this.id = id;
        this.date = date;
        this.inList = inList;
        this.outList = outList;
    }

    public DayEntry(Date date, List<SingleEntry> inList, List<SingleEntry> outList) {
        this.date = date;
        this.inList = inList;
        this.outList = outList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<SingleEntry> getInList() {
        return inList;
    }

    public void setInList(List<SingleEntry> inList) {
        this.inList = inList;
    }

    public List<SingleEntry> getOutList() {
        return outList;
    }

    public void setOutList(List<SingleEntry> outList) {
        this.outList = outList;
    }
}
