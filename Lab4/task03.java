
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.out;

public class task03 {
    public static void main(String[] args) {
        
        Scanner input= new Scanner(System.in);
        
        out.println("Please enter the processes ammount: ");
        int n = input.nextInt();

        out.println("Please enter the Time qunatum: ");
        int quantam = input.nextInt();

        int pid[] = new int[n];
        int arrival_time[] = new int[n];
        int burst_time[] = new int[n];
        int new_burst[] = new int[n];
        int f[] = new int[n];
        int list01[] = new int[n];
        int completion_time[]=new int[n];
        int waiting_time[]=new int[n];
        int turnaround_time[]=new int[n];
        
        ArrayList<Integer> Q = new ArrayList<Integer>();;
        int c = 0;
        int st = 0;
        float avg_wt = 0;
        float avg_ta = 0;
        
        for (int i = 0; i < n; i++) {
            pid[i] = i;
            out.println("Please enter Burst Time of Process " + (i + 1) + ": ");
            burst_time[i] = input.nextInt();
            new_burst[i] = burst_time[i];
        }
        
        while (true) {
            if (c == n) {
                break;
            }
            for (int i = 0; i < n; i++) {
                if (arrival_time[i] <= st && f[i] == 0 && list01[pid[i]] == 0) {
                    Q.add(pid[i]);
                    list01[pid[i]] = 1;
                }
            }
            
            if (Q.isEmpty()) {
                    st++;
                } else {
                    list01[Q.get(0)] = 0;

                    if(burst_time[Q.get(0)]<quantam){
                        st += burst_time[Q.get(0)];
                        burst_time[Q.get(0)]=0;

                        c++;
                        f[Q.get(0)] = 1;
                        completion_time[Q.get(0)]=st;
                        turnaround_time[Q.get(0)]=st-arrival_time[Q.get(0)];
                        waiting_time[Q.get(0)]=turnaround_time[Q.get(0)]-new_burst[Q.get(0)];
                        out.println("PID: " + (Q.get(0)+1) + " Completion Time:" + st);
                    }

                    else{
                        st += quantam;

                        burst_time[Q.get(0)] -= quantam;
                        list01[Q.get(0)] = 0;
                    }
                    Q.remove(0);
                }
        }
        out.println(" ");
        for (int i = 0; i < turnaround_time.length; i++) {
            out.println("PID: " + (i+1) + " Turnaround Time:" + turnaround_time[i]);
            avg_ta = turnaround_time[i] + avg_ta;
        }

        out.println(" ");
        for (int i = 0; i < waiting_time.length; i++) {
            out.println("PID: " + (i+1) + " Waiting Time: " + waiting_time[i]);
            avg_wt = waiting_time[i] + avg_wt;
        }
        
        out.println(" ");
        out.println(" ");

        out.println("Average Turnaround Time: "+(avg_ta/n));
        out.println("Average Waiting Time: "+(avg_wt/n));;
    }
}
