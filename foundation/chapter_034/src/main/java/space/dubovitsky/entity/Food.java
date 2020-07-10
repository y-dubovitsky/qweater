package space.dubovitsky.entity;


import java.util.Date;

public class Food {

    private int id;
    private String name;
    private String producer;
    private Date date; //! Класс java.util.Date хранит значение даты и времени в миллисекундах с начала эпохи. java.sql.Date хранит значение только для даты и обычно используется в JDBC.

    public Food() {
    }

    public Food(String name, String producer, Date date) {
        this.name = name;
        this.producer = producer;
        this.date = date;
    }

    public Food(int id, String name, String producer, Date date) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.date = date;
    }

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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " " + this.name + " " + this.producer + " " + this.date;
    }
}
