package com.javarush.task.task18.task1825.My;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {

        FileName fileName1 = new FileName("d://jhg.txt.part3");
        FileName fileName2 = new FileName("d://gfg.txt.part66");
        FileName fileName3 = new FileName("d://rtyn.txt.part78");
        FileName fileName4 = new FileName("d://oiyt.txt.part2");
        FileName fileName5 = new FileName("d://erty.txt.part1");


        TreeSet<FileName> treeSet = new TreeSet<>();
        treeSet.add(fileName1);
        treeSet.add(fileName2);
        treeSet.add(fileName3);
        treeSet.add(fileName4);
        treeSet.add(fileName5);

        for (FileName f:treeSet) {
            System.out.println(f.getName());
        }








    }
}
