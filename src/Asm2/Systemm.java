package Asm2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Systemm {
    private Queue<Request> inQueue;
    private Queue<Request> outQueue;
    private Stack<Request> ticketStack;
    public Systemm() {
        this.inQueue = new LinkedList<>();
        this.outQueue = new LinkedList<>();
        this.ticketStack = new Stack<>();
    }
    public void enqueueToInQueue(Request request) {
        if (request.getCustomer().getNote().isNull()){
            request.setMessage("Note can't empty!");
            inQueue.add(request);
        }
        else if(request.getCustomer().getNote().getLenghtNote() > 10){
            Request tmp = request;
            request.getCustomer().getNote().trunkCate();
            inQueue.add(request);
        }
        else {
            inQueue.add(request);
        }
    }
    public Request dequeueFromInQueue() {
        return inQueue.poll();
    }
    public void enqueueToOutQueue(Request request) {

        outQueue.add(request);
    }
    public Request dequeueFromOutQueue() {
        return outQueue.poll();
    }
    public void pushToTicketStack(Request request) {
        if(getTicketStackSize() < 5) {
            ticketStack.push(request);
        }
        else{
            request.setMessage("Server busy! Try after!");
            outQueue.add(request);
        }
    }
    public void popFromTicketStack() {
        Request tmp = ticketStack.pop();
        if(tmp.getSeat().isBooked()){
            tmp.setMessage("Your seat already booked by another!");
            enqueueToOutQueue(tmp);
        }
        else{
            tmp.setMessage("Successfully!");
            tmp.getSeat().bookSeat();

            enqueueToOutQueue(tmp);

        }
    }
    public boolean isInQueueEmpty() {
        return inQueue.isEmpty();
    }
    public boolean isOutQueueEmpty() {
        return outQueue.isEmpty();
    }
    public boolean isTicketStackEmpty() {
        return ticketStack.isEmpty();
    }
    public int getInQueueSize() {
        return inQueue.size();
    }
    public int getOutQueueSize() {
        return outQueue.size();
    }
    public int getTicketStackSize() {
        return ticketStack.size();
    }
}


