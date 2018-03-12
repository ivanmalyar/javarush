package com.javarush.task.task18.task1825.My;

public class FileName implements Comparable<FileName> {
    private String name;

    public FileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(FileName f) {
        String name1 = this.name;
        String name2 = f.getName();

        String[] arr1 = name1.split(".part");
        String idStr1 = arr1[arr1.length-1];
        int id1 = Integer.parseInt(idStr1);

        String[] arr2 = name2.split(".part");
        String idStr2 = arr2[arr2.length-1];
        int id2 = Integer.parseInt(idStr2);

        if(id1 > id2) return 1;
        else if (id2 > id1) return -1;
        else return 0;
    }
}
