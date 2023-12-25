package Asm2;

public class Request{
    private Customer customer;
    private Seat seat;
    private String message;

    public Request(Customer customer, Seat seat) {
        this.customer = customer;
        this.seat = seat;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Seat getSeat() {
        return seat;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void getMessage(){
        if(this.customer.getNote().getRemain() != null){
            this.message = "The note was too long so its got splited! ";
        }
        System.out.println(this.customer.getName() + " get the message: " + this.message);
        System.out.print(this.customer.getNote().getNote());
        if(this.customer.getNote().getRemain() != null){
            System.out.println(this.customer.getNote().getRemain());
        }
        System.out.println();
    }
}
