import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.out;

public class task02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        out.println("Please enter the processes ammount: ");
        int n = input.nextInt();

        int pid[] = new int[n];
        int priority[] = new int[n];
        int burst_time[] = new int[n];
        int arrival_time[] = new int[n];

        int f[] = new int[n];
        int list01[] = new int[n];
        int completion_time[] = new int[n];
        int waiting_time[] = new int[n];
        int turnaround_time[] = new int[n];
        
        int c = 0;
        int st = 0;
        float avg_wt = 0;
        float avg_ta = 0;

        ArrayList<Integer> Q = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            pid[i] = i;
            

            out.println("Please enter Burst Time of Process " + (i + 1) + ": ");
            burst_time[i] = input.nextInt();

            out.println("Please enter Priority of Process " + (i + 1) + ": ");
            priority[i] = input.nextInt();
        }
        while (c != n) {
            for (int i = 0; i < arrival_time.length; i++) {
                if (arrival_time[i] <= st && f[i] == 0 && list01[pid[i]] == 0) {
                    Q.add(pid[i]);
                    list01[pid[i]] = 1;
                }
            }
            int maxp = 999;
            int maxppr = 999;
            int idx = -999;
            for (int i = 0; i < Q.size(); i++) {
                if (!Q.isEmpty()) {

                    if (priority[Q.get(i)] < maxp) {
                        maxp = priority[Q.get(i)];
                        maxppr = Q.get(i);
                        idx=i;
                    }
                }
            }
            if (Q.isEmpty()) {
                st++;
            } else {
                Q.remove(idx);
                c++;
                st += burst_time[maxppr];
                f[maxppr] = 1;
                turnaround_time[maxppr] = st-arrival_time[maxppr];
                waiting_time[maxppr] = turnaround_time[maxppr] - burst_time[maxppr];
                out.println("PID: " + (maxppr + 1) + " Completion Time: " + st);
                completion_time[maxppr] = st;
            }

        }
        
        out.println(" ");
        for (int i = 0; i < turnaround_time.length; i++) {
            out.println("PID: " + (i+1) + " Turnaround Time: " + turnaround_time[i]);
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
