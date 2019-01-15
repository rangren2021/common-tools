package com.study.common.server.exec;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.TreeSet;

/**
 * @ClassName CalFee
 * @Description TODO
 * @Author xinbang
 * @Date 2019/1/3 10:35
 * @Version 1.0
 **/

public class CalFee {

    private static final TreeSet<Level> calLevel = new TreeSet<Level>((a, b) -> a.getLevel() - b.getLevel());

    static {
        calLevel.add(new Level(1, 0, 36000, 3));
        calLevel.add(new Level(2, 36000, 144000, 10));
        calLevel.add(new Level(3, 144000, 300000, 20));
        calLevel.add(new Level(4, 300000, 420000, 25));
        calLevel.add(new Level(5, 420000, 660000, 30));
        calLevel.add(new Level(6, 660000, 960000, 35));
        calLevel.add(new Level(7, 960000, -1, 45));
    }

    private double cal(double amount, int level) {
        return amount * level * 0.01;
    }

    public static Level getLevel(double amount) {
        int origin = 0;
        Level res = null;
        for (Level level : calLevel) {
            if (amount > level.getFirst() && level.getLevel() > origin) {
                res = level;
            }
        }
        return res;
    }


    public double calFee(double amount) {
        Level level = getLevel(amount);
        int ordinal = level.getLevel();
        int times = ordinal;
        double totalFee = 0;
        while (times > 0) {
            if (ordinal == times) {
                double extra = amount - level.getFirst();
                totalFee += cal(extra, level.getFee());
            } else {
                level = calLevel.ceiling(level);
                totalFee += cal((level.getEnd() - level.getFirst()), level.getFee());
            }
            times--;
        }
        return totalFee;
    }

    @Data
    @AllArgsConstructor
    static class Level {
        private int level;
        private int first;
        private int end;
        private int fee;

    }

    public static void main(String[] args) {
        CalFee test13 = new CalFee();
        System.out.println("res:" + test13.calFee(144000));
    }

}
