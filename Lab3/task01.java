import java.util.Scanner;
import static java.lang.System.out;

class MyThread extends Thread {
    int num01;
    int num02;
    public MyThread(String name, int a, int b) {
        super(name);
        num01 = a;
        num02 = b;        
    } 
    public void run() {
        if(getName() == "add") {
            out.println("Add: " + (num01 + num02));
        }
        else if (getName() == "sub") {
            out.println("Subtract: " + (num01 - num02));
        }
        else if (getName() == "mul") {
            out.println("Multiply: " + (num01 * num02));
        }
        else if (getName() == "div") {
            out.println("Divide: " + (num01 / num02));
        }
        else{
            out.println("No valid operation.");
        }        
    }
}

public class task01 {
    public static void main(String[] args) {                
        Scanner input = new Scanner(System.in);
        out.println("Please enter an integer: ");
        int num01 = input.nextInt();
        out.println("Please enter another integer: ");
        int num02 = input.nextInt();
        MyThread add = new MyThread("add", num01, num02);
        MyThread sub = new MyThread("sub", num01, num02);
        MyThread mul = new MyThread("mul", num01, num02);
        MyThread div = new MyThread("div", num01, num02);
        MyThread oth = new MyThread("oth", num01, num02);
        add.start();
        sub.start();
        mul.start();
        div.start();
        oth.start();    
    }
    
}
