import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.out;

public class task01 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        out.println("Please enter the processes ammount: ");
        int n = input.nextInt();

        int pid[] = new int[n];
        int arrival_time[] = new int[n];
        int burst_time[] = new int[n];
        int new_burst[] = new int[n]; //original burst time
        int f[] = new int[n];
        int list01[] = new int[n];
        int completion_time[] = new int[n];
        int waiting_time[] = new int[n];
        int turnaround_time[] = new int[n];        
        ArrayList<Integer> Q = new ArrayList<Integer>();

        int st = 0;
        int c = 0;
        float avg_wt = 0;
        float avg_ta = 0;
        
        int mini = 9999;
        int minipr = 999;

        for (int i = 0; i < n; i++) {
            pid[i]=i;

            out.println("Please enter the Arrival Time of Process " + (i + 1) + ": ");
            arrival_time[i] = input.nextInt();

            out.println("Please enter Burst Time of Process " + (i + 1) + ": ");
            burst_time[i] = input.nextInt();

            new_burst[i] = burst_time[i];
        }
        
        while (true) {
            if (c == n) {
                break;
            }
            
            for (int i = 0; i < arrival_time.length; i++) {
                if (arrival_time[i] <= st && f[i] == 0 && list01[pid[i]] == 0) {
                    Q.add(pid[i]);
                    list01[pid[i]] = 1;
                }
            }
            
                   
            int min_i = 0;
            for (int i = 0; i < Q.size(); i++) {
                if (!Q.isEmpty()) {
                    if (burst_time[Q.get(i)] < mini) {
                        mini = burst_time[Q.get(i)];
                        minipr = Q.get(i);
                        min_i = i;
                    }

                }
            }
            if (Q.isEmpty()) {
                    st++;
                } else {
                    Q.remove(min_i);
                    list01[pid[minipr]] = 0;
                    st ++;
                    burst_time[minipr]--;
                    mini = burst_time[minipr];

                    if(burst_time[minipr]==0){
                        c++;
                        f[minipr] = 1;

                        completion_time[minipr]=st;
                        turnaround_time[minipr]=st-arrival_time[minipr];
                        waiting_time[minipr]=turnaround_time[minipr]-new_burst[minipr];
                        out.println("PID: " + (minipr+1) + " Completion Time: " + st);
                        
                    }

                    mini = 9999;
                    
                }
        }

        out.println(" ");
        for (int i = 0; i < turnaround_time.length; i++) {
            out.println("PID: " + (i+1) + " Turnaround Time:" + turnaround_time[i]);
            avg_ta = turnaround_time[i]+avg_ta;
        }

        out.println(" ");
        for (int i = 0; i < waiting_time.length; i++) {
            out.println("PID: " + (i+1) + " Waiting Time: " + waiting_time[i]);
            avg_wt = waiting_time[i] + avg_wt;
        }
        
        out.println(" ");
        out.println(" ");

        out.println("Average Turnaround Time: "+(avg_ta/n));
        out.println("Average Waiting Time: "+(avg_wt/n));

    }
    
}
