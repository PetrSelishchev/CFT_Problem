package cft.internship.selishchev.sorter.sorters;


import cft.internship.selishchev.sorter.comparators.SortComparator;

public interface Sorter {
    <T extends Comparable<T>> void sort(T[] array, SortComparator sortComparator);
}
