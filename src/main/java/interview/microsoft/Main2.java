package interview.microsoft;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jacob on 14/10/19.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineNum = in.nextInt();
        in.nextLine();
        ArrayList<Log> input = new ArrayList<Log>();
        while (lineNum-- > 0) {
            input.add(new Log(in.nextLine()));
        }
        if (input.size() < 2) {
            System.out.println("Incorrect performance log");
            return;
        }
        Stack<Log> stack = new Stack<Log>();
        stack.push(input.get(0));
        for (int i = 1; i < input.size(); i++) {

            Log log = input.get(i);
            Log old = stack.peek();

            if (!(old.status.equals("START") || old.status.equals("END"))) {
                System.out.println("Incorrect performance log");
                return;
            }
            String usedTime = calTime(log, old);
            if (usedTime.equals("error")) {
                System.out.println("Incorrect performance log");
                return;
            }

            if (!log.funcName.equals(old.funcName)) {
                stack.push(log);
            } else if (log.status.equals("END") && old.status.equals("START")) {
                stack.pop();
                old.usedTime = usedTime;
                if (old.usedTime.equals("error") || old.usedTime.equals("00:00:00")) {
                    System.out.println("Incorrect performance log");
                    return;
                }
            }
        }
        if (stack.size() != 0) {
            System.out.println("Incorrect performance log");
        } else {
            for (Log log : input) {
                if (log.status.equals("START")) {
                    System.out.println(String.format("%s %s", log.funcName, log.usedTime));
                }
            }
        }
    }

    public static String calTime(Log log1, Log log2) {

        int s = 0;
        int m = 0;
        int h = 0;

        if (log1.second >= log2.second) {
            s = log1.second - log2.second;
        } else {
            s = log1.second - log2.second + 60;
            m = -1;
        }

        if (log1.minute + m >= log2.minute) {
            m = log1.minute - log2.minute + m;
        } else {
            m = log1.minute - log2.minute + m + 24;
            h = -1;
        }
        h = h + log1.hour - log2.hour;
        if (h < 0) {
            return "error";
        }
        return String.format("%02d:%02d:%02d", h, m, s);
    }


}

class Log {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    String funcName;
    int hour;
    int minute;
    int second;
    String status;

    String usedTime;


    public Log(String line) {
        String[] split = line.split(" ");
        this.funcName = split[0];
        String[] times = split[1].split(":");
        this.hour = Integer.parseInt(times[0]);
        this.minute = Integer.parseInt(times[1]);
        this.second = Integer.parseInt(times[2]);
        this.status = split[2];
    }

}