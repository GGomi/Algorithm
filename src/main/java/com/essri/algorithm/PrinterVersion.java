package com.essri.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class PrinterVersion {

    static int[] priority = new int[10];

    public boolean check(File temp) {
        int pri = temp.pri;

        for(int i = pri+1; i < 10; i++) {
            if(priority[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<File> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            priority[priorities[i]]++;
            queue.add(new File(i,priorities[i]));
        }

        while(!queue.isEmpty()) {
            File t = queue.remove();
            boolean checked = check(t);

            if(checked) {
                answer++;
                if(t.id == location) {
                    return answer;
                }
                priority[t.pri]--;
            } else {
                queue.add(t);
            }
        }
        return answer;
    }
}

class File {
    int id;
    int pri;
    File (int id, int pri){
        this.id = id;
        this.pri = pri;
    }
}
