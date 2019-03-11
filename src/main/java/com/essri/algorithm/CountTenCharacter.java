package com.essri.algorithm;

public class CountTenCharacter {
    private String input;

    public CountTenCharacter(String input) {
        this.input = input;
    }

    // BOJ 11721번
    public String solve() {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String text = br.readLine();
        String text = input;
        String res = "";

        // charAt() => String은 char의 연속된 배열이기 때문에 time Complexity는 O(1)이다.
        for (int i = 0; i < text.length(); i++) {
//            System.out.print(text.charAt(i));
            res += text.charAt(i);
            if ((i + 1) % 10 == 0) {
                res += "\n";
            }
        }

        return res;
    }
}
