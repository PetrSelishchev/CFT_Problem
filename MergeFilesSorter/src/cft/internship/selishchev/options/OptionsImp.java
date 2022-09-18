package cft.internship.selishchev.options;

import cft.internship.selishchev.options.blocks.BlockMaxSize;
import cft.internship.selishchev.options.dataRole.DataRole;
import cft.internship.selishchev.parserCLI.Helper;
import cft.internship.selishchev.sorter.comparators.AscendingSortComparator;
import cft.internship.selishchev.sorter.comparators.DescendingSortComparator;
import cft.internship.selishchev.sorter.comparators.SortComparator;
import cft.internship.selishchev.sorter.sorters.MergeSortGeneric;
import cft.internship.selishchev.sorter.sorters.Sorter;

import java.util.List;

public class OptionsImp implements Options {

    private DataRole dataRole;
    private SortComparator sortComparator;
    private Sorter sorter;
    private String outputFileName;
    private List<String> sortableFilesNameList;
    private BlockMaxSize blockMaxSize;

    public OptionsImp(SortOrder sortOrder, DataRole dataRole, List<String> filesList, BlockMaxSize blockMaxSize) {
        OptionsImp.validateSettings(dataRole, filesList);

        this.dataRole = dataRole;
        this.sortComparator = sortOrder.equals(SortOrder.ASCENDING) ? new AscendingSortComparator() : new DescendingSortComparator();
        this.sorter = new MergeSortGeneric();
        this.outputFileName = filesList.get(0);
        this.sortableFilesNameList = filesList.subList(1, filesList.size());
        this.blockMaxSize = blockMaxSize;
    }

    public static void validateSettings(DataRole dataType, List<String> filesList) {
        try {
            if (dataType.equals(DataRole.NOT_INSTALLED)) {
                throw new IllegalArgumentException("Необходимо задать тип данных: \"-i\" для чисел или \"-s\" для строк (или воспользуйтесь \"-help\")");
            }

            if (filesList.size() < 1) {
                throw new IllegalArgumentException("Необходимо задать название выходного файла (или воспользуйтесь \"-help\")");
            }

            if (filesList.size() < 2) {
                throw new IllegalArgumentException("Необходимо задать название файла для сортировки (или воспользуйтесь \"-help\")");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            Helper.getHelpCommand();

            System.exit(0);
        }
    }

    @Override
    public DataRole getDataRole() {
        return dataRole;
    }



    @Override
    public SortComparator getSortComparator() {
        return sortComparator;
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }

    @Override
    public String getOutputFileName() {
        return outputFileName;
    }

    @Override
    public List<String> getFilesNameList() {
        return sortableFilesNameList;
    }

    @Override
    public int getBlockMaxSize() {
        return blockMaxSize.getSize();
    }
}

