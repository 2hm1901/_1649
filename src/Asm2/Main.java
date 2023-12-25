package Asm2;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean isConnect = false;
        Customer c1 = new Customer("A", "111", new Note("Test1234"));
        Customer c2 = new Customer("B", "222", new Note("Test"));
        Customer c3 = new Customer("C", "333", new Note("Test12345"));
//        Customer c4 = new Customer("D", "444");

        SeatContainer seats = new SeatContainer();

        Request r1 = new Request(c1, seats.getSeat(1));
        Request r2 = new Request(c2, seats.getSeat(1));
        Request r3 = new Request(c3, seats.getSeat(3));

//        System.out.println("Data send:");
//        r1.getMessage();
//        r2.getMessage();
//        r3.getMessage();

        Systemm A = new Systemm();
        Systemm B = new Systemm();

        A.enqueueToOutQueue(r1);
        A.enqueueToOutQueue(r2);
        A.enqueueToOutQueue(r3);

//        A.enqueueToOutQueue(r4);
        //Connect
        if(A.isOutQueueEmpty() == false && B.isInQueueEmpty() == true){
            isConnect = true;
        }
        else{
            System.out.println("Can't connect!!!");
        }

        if(isConnect) {
            //A-->B
            System.out.println("Number of request be send: " + A.getOutQueueSize());
            while (A.getOutQueueSize() > 0) {
                B.enqueueToInQueue(A.dequeueFromOutQueue());
            }


            //B-->StackB
            while (B.getInQueueSize() > 0) {
                B.pushToTicketStack(B.dequeueFromInQueue());
            }
            long startTime = System.nanoTime();

            //processing
            while (!B.isTicketStackEmpty()) {
                B.popFromTicketStack();
            }
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.println("Time cost: " + elapsedTime);

            //B-->A
            while (B.getOutQueueSize() > 0) {
                A.enqueueToInQueue(B.dequeueFromOutQueue());
            }
        }

        //display
//        System.out.println("Data get:");
//        while (A.getInQueueSize() > 0){
//            A.dequeueFromInQueue().getMessage();
//        }
    }
}
