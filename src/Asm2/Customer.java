package Asm2;

public class Customer {
    private String name;
    private String number;
    private Note note;
    public Customer(String name, String number, Note note) {
        this.name = name;
        this.number = number;
        this.note = note;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Note getNote(){
        return this.note;
    }

}


