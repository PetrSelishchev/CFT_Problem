package cft.internship.selishchev.sorter.comparators;

public interface SortComparator {
    <T extends Comparable<T>> int compare(T o1, T o2);
}
