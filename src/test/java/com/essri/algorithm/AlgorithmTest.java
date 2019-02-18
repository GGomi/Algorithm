package com.essri.algorithm;

import org.junit.Test;

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
    private NumericalBaseball numericalBaseball;
    private MakeOne makeOne;

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
    public void numericalBaseballTest() {
        int[][] arr = {{123, 0, 0},{356, 1, 0},{327, 2, 0},{489, 0, 1}};

        numericalBaseball = new NumericalBaseball(arr);
        numericalBaseball.solution(arr);
    }

    @Test
    public void makeOneTest() {
        makeOne = new MakeOne(10);
        assertEquals(makeOne.solution(),3);
    }

}
