package com.essri.algorithm;

import java.io.*;
import java.util.*;

public class LineTestQ3 {
    private String field1;
    private String field2;
    private static BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public LineTestQ3(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, LineTestQ3> leftTable = new HashMap<>();
        Map<Integer, LineTestQ3> secondTable = new HashMap<>();
        List<String> leftFields = new ArrayList<>();
        List<String> rightFields = new ArrayList<>();

        int leftRow = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            leftFields.add(st.nextToken());
        }

        setTable(leftTable, leftRow, leftFields);

        int rightRow = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            rightFields.add(st.nextToken());
        }

        setTable(secondTable, rightRow, rightFields);
        Set<Integer> keySet = leftTable.keySet();

        printFields(leftFields);
        printFields(rightFields);
        bw.write("\n");
        bw.flush();

        for (int id : keySet) {
            StringBuilder rowBuilder = new StringBuilder();
            rowBuilder
                    .append(id)
                    .append(" ");
            appendRow(leftTable, leftFields, id, rowBuilder);

            // NULL일 경우 출력
            if (!secondTable.containsKey(id)) {
                rowBuilder.append("NULL")
                        .append(" ");
                if (leftFields.size() == 3) {
                    rowBuilder
                            .append("NULL")
                            .append(" ");
                }
                //존재할 경우
            } else {
                appendRow(secondTable, rightFields, id, rowBuilder);
            }
            System.out.println(rowBuilder.toString().trim());
        }

    }

    private static void appendRow(Map<Integer, LineTestQ3> table, List<String> tableFields, int id, StringBuilder rowBuilder) {
        LineTestQ3 secondRows = table.get(id);
        rowBuilder.append(secondRows.getField1())
                .append(" ");
        if (tableFields.size() == 3) {
            rowBuilder
                    .append(secondRows.getField2())
                    .append(" ");
        }
    }

    public static void setTable(Map<Integer, LineTestQ3> table, int row, List<String> fields) throws IOException {
        StringTokenizer st;
        int id;

        for (int i = 0; i < row - 1; i++) {
            LineTestQ3 field;
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());

            if (fields.size() == 3) {
                field = new LineTestQ3(st.nextToken(), st.nextToken());
            } else {
                field = new LineTestQ3(st.nextToken(), null);
            }
            table.put(id, field);
        }
    }

    public static void printFields(List<String> fields) throws IOException {
        for (int i = 0; i < fields.size(); i++) {
            if(i == fields.size() - 1)
                bw.write(fields.get(i));
            else
                bw.write(fields.get(i) + " ");
        }
        bw.flush();
    }
}
