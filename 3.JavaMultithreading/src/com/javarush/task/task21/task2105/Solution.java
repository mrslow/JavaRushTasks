package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {

        if (o == this) return true;

        if (!(o instanceof Solution)) return false;

        Solution n = (Solution) o;

        if (!Objects.equals(first, n.first)) return false;
        if (!Objects.equals(last, n.last)) return false;

        return true;
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        return 31 * result + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}

