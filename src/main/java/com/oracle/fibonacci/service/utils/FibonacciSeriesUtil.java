package com.oracle.fibonacci.service.utils;

import com.oracle.fibonacci.service.response.FibonacciSeriesResponse;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSeriesUtil {

    //private static List<Integer> sequence = new ArrayList<Integer>();

    public static FibonacciSeriesResponse calculateFibonacciSeries(int givenNumber)
    {
        List<Integer> sequence = new ArrayList<Integer>();

        if(givenNumber != 0){
            int a = 0, b = 1, c;
            for (int i = 2; i <= givenNumber; i++)
            {
                c = a + b;
                a = b;
                b = c;
                //System.out.println ("a :"+ a + "    b :"+b);
                sequence.add (b);
            }
        }
        return new FibonacciSeriesResponse (sequence.size (), (ArrayList<Integer>) sequence,sequence.stream ().mapToInt (x -> x.intValue ()).sum ());
    }

   /* public static void main (String args[])
    {
        int n = 7;
        calculateFibonacciSeries (n);
        System.out.println ("sequence.toArray () : " +sequence.toArray ());
        System.out.println ("sequence : " +sequence);
        System.out.println("sequence.size () : " +sequence.size ());
        System.out.println ("sequence.stream ().mapToInt (x -> x.intValue ()).sum () : "+ sequence.stream ().mapToInt (x -> x.intValue ()).sum ());

    }*/

}
