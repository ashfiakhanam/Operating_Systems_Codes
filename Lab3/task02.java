import java.util.Scanner;
import static java.lang.System.out;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        out.println("The house is : " + getName());        
        if(getName() == "House Stark" || getName() == "House Targaryen") {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(getName() == "House Lannister" || getName() == "House Bolton") {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if(getName() == "House Tyrell") {
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
}

public class task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyThread stark = new MyThread("House Stark");
        MyThread targaryen = new MyThread("House Targaryen");
        MyThread lannister = new MyThread("House Lannister");
        MyThread bolton = new MyThread("House Bolton");
        MyThread tyrell = new MyThread("House Tyrell");
        stark.setPriority(Thread.MAX_PRIORITY);
        bolton.setPriority(Thread.MIN_PRIORITY);
        
        stark.run();
        targaryen.run();
        lannister.run();
        bolton.run();

        stark.start();
        tyrell.start();
        lannister.start();
        bolton.start();        
        try{
            stark.join();
            lannister.join();
            bolton.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
        if(stark.isAlive() == true) {
            out.println("Not Today!");
        }
        if(bolton.isAlive() == false) {
            out.println("You know nothing!");
        }
    }       
}
    

