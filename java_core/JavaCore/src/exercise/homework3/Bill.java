package exercise.homework3;

import exercise.homework2.Date;

public abstract class Bill {
    private String id;
    private String name;
    private Date date;

    public Bill(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public abstract void pay();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
