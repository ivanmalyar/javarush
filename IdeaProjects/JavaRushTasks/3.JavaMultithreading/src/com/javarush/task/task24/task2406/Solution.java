package com.javarush.task.task24.task2406;
import java.io.BufferedReader;
import java.math.BigDecimal;

public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Building building = solution.new Building();

        Apt3Bedroom apt3Bedroom = solution.new Apt3Bedroom(building);

    }

    public class Apt3Bedroom extends Building.Apartments{
        public Apt3Bedroom(Building building) {
            building.super();
        }
    }
    public class BigHall extends Building.Hall{
        public BigHall(BigDecimal square, Building building) {
            building.super(square);
        }
    }


}
