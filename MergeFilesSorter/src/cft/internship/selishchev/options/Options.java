package cft.internship.selishchev.options;

import cft.internship.selishchev.options.dataRole.DataRole;
import cft.internship.selishchev.sorter.comparators.SortComparator;
import cft.internship.selishchev.sorter.sorters.Sorter;

import java.util.List;

public interface Options {

    DataRole getDataRole();

    SortComparator getSortComparator();

    Sorter getSorter();

    String getOutputFileName();

    List<String> getFilesNameList();

    int getBlockMaxSize();

}
