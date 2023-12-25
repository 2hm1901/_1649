package Asm2;

public class Note {
    private String note;
    private String remain;
    public Note(){

    }
    public Note(String note){
        this.note = note;
    }
    public String getNote(){
        return this.note;
    }
    public void setNote(String a){
        this.note = a;
    }
    public int getLenghtNote(){
        return this.note.length();
    }
    public boolean isNull() {
        return note == null;
    }
    public void trunkCate(){
        String firstNote;
        String remainNote = "";
        if(!isNull() && this.note.length() > 10){
            firstNote = note.substring(0, 10);
            remainNote = note.substring(10);
            setNote(firstNote);
            setRemain(remainNote);
        }
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }
    public String getRemain(){
        return this.remain;
    }
}
