import java.util.Scanner;
import static java.lang.System.out;
import java.util.ArrayList;

class MyThread extends Thread {
    ArrayList<Long> Mean;
    int count = 0;
    long sum = 0;    
    
    long Fibo[];

    public MyThread(String name, long li[], ArrayList<Long> num) {
        super(name);
        Mean = num;
        Fibo = li;        
    }    
   @Override
    public void run() {
        int start = 0;
        if(getName() == "first") {            
            for(int i = start; i<start+25; i++) {
                if(Fibo[i] % 2 == 1) {
                    sum = sum+Fibo[i];
                    count++;
                }
            }
        }
        else if(getName() == "second") {            
            for(int i = start; i < start + 25; i++) {
                if(Fibo[i] % 2 == 0) {
                    sum = sum + Fibo[i];
                    count++;
                }
            }           
            
        }
        else if(getName() == "third") {
            start = 25;
            for(int i = start; i < start + 25; i++) {
                if(Fibo[i] % 2 == 1) {
                    sum = sum + Fibo[i];
                    count++;
                }
            }           
                        
        }
       else if(getName() == "then") {
            start = 25;
            for(int i = start; i < start + 25; i++) {
                if(Fibo[i] % 2 == 0) {
                    sum = sum + Fibo[i];
                    count++;
                }
            }            
            
        }        
        else if(getName() == "last") {            
            for(int i = start; i < Mean.size(); i++) {
                sum += Mean.get(i);
            }
           out.println(sum / 4);
           return;
        }
        Mean.add(sum / count);
    }
}

public class task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long li0 = 0;
        long li1 = 1;

        long Fibo[] = new long[50];

        Fibo[0] = li0;
        Fibo[1] = li1;

        for(int i = 2; i < 50; i++) {
            long temp = li0 + li1;
            li0 = li1;
            li1 = temp;
            Fibo[i] = li1;
        }

        ArrayList<Long> Mean  =  new ArrayList<Long>();
        
        MyThread first = new MyThread("first", Fibo, Mean);
        MyThread second = new MyThread("second", Fibo, Mean);
        MyThread third = new MyThread("third", Fibo, Mean);
        MyThread then = new MyThread("then", Fibo, Mean);

        first.start();
        try {
            first.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        second.start();
        try {
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        third.start();
        try {
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        then.start();        
        try {
            then.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyThread last = new MyThread("last", null, Mean);
        last.start();
    }
}
