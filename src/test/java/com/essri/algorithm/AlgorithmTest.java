package com.essri.algorithm;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AlgorithmTest {
    private BigNumber bigNumber;
    private Camouflage camouflage;
    private GiveupMath giveupMath;
    private NotCompletePerson notCompletePerson;
    private NumberBook numberBook;
    private PrinterVersion printerVersion;
    private Printer printer;
    private SteelStick steelStick;
    private MakeOne makeOne;
    private InsertionSort insertionSort;
    private CountTenCharacter countTenCharacter;
    private MakeMaze makeMaze;
    private Woowa woowa;
    private Bridge bridge;

    @Test
    public void bigNumberTest() {
        bigNumber = new BigNumber();
        int[] num1 = {6,10,2};
        int[] num2 = {3,30,34,5,9};
//        assertEquals("6210",b.solution(num1));
        assertEquals("9534330",bigNumber.solution(num2));
    }

    @Test
    public void camouflageTest() {
        camouflage = new Camouflage();
        String[][] camou = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        assertEquals(5,camouflage.solution(camou));
    }

    @Test
    public void giveUpMathTest() {
        giveupMath = new GiveupMath();
        int[] input = {1,3,2,4,2};
        int[] answer = {1,2,3};
        assertEquals(Arrays.toString(giveupMath.solution(input)),Arrays.toString(answer));
    }

    @Test
    public void notCompletePersonTest() {
        notCompletePerson = new NotCompletePerson();
        String[] a = {"leo", "kiki", "eden"};
        String[] b = {"eden", "kiki"};
        assertEquals("leo", notCompletePerson.solution(a,b));
    }

    @Test
    public void numberBookTest() {
        numberBook = new NumberBook();
        String[] input = {"119", "97674223", "1195524421"};
        assertEquals(false,numberBook.solution(input));
    }

    @Test
    public void printerTest() {
        int[] priorities = {2,1,3,2};
        int location = 2;
        printerVersion = new PrinterVersion();
        printer = new Printer();
        assertEquals("1",String.valueOf(printer.solution(priorities,location)));
        assertEquals("1",String.valueOf(printerVersion.solution(priorities,location)));
    }


    @Test
    public void steelStickTest() {
        steelStick = new SteelStick();
        String input = "()(((()())(())()))(())";
        assertEquals("17",String.valueOf(steelStick.solution(input)));
    }

    @Test
    public void makeOneTest() {
        makeOne = new MakeOne(10);
        assertEquals(makeOne.solution(),3);
    }

    @Test
    public void insertionSort() {
        int[] arr = {1,2,2,3,5};
        insertionSort = new InsertionSort(new int[] {3,2,5,1,2});
        assertEquals(Arrays.toString(insertionSort.sort()),Arrays.toString(arr));
    }

    @Test
    public void countTenCharacter() {
        String input = "BaekjoonOnlineJudge";
        countTenCharacter = new CountTenCharacter(input);
        assertEquals(countTenCharacter.solve(), "BaekjoonOn\nlineJudge");
    }

    @Test
    public void makeMazeTest() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        makeMaze = new MakeMaze(5,"RRFRF");
        makeMaze.solve();
        assertEquals("..\n.#\n", outputStream.toString());
    }

    @Test
    public void clapTest() {
        assertEquals(4, woowa.solution(13));
    }

    @Test
    public void bridgeTest() {
        bridge = new Bridge(2,10,new int[]{7,4,5,6});
        System.out.println(bridge.solution());
    }

}
