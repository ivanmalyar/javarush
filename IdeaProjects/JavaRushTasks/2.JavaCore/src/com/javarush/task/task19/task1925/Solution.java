package com.javarush.task.task19.task1925;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        try ( BufferedReader brf = new BufferedReader( new FileReader( args[0] ) );
              BufferedWriter bwf = new BufferedWriter( new FileWriter( args[1] ) ) ) {
            String tmp = brf.lines()
                    .flatMap( s -> Arrays.stream( s.split(" ") ) )
                    .filter( s -> s.length() > 6 )
                    .collect(Collectors.joining(","));
            bwf.write(tmp);
        }

    }
}
