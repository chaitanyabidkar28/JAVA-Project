package com.cb;

import java.util.ArrayList;


class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0;
    }

    int getHighest() {
        int max = grades.get(0);
        for (int g : grades) {
            if (g > max) max = g;
        }
        return max;
    }

    int getLowest() {
        int min = grades.get(0);
        for (int g : grades) {
            if (g < min) min = g;
        }
        return min;
    }
}


