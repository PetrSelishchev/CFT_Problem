package cft.internship.selishchev.filesSorter;


import cft.internship.selishchev.options.Options;
import cft.internship.selishchev.parserCLI.Helper;

import java.io.IOException;


public class FilesSorter {
    private Options options;

    public FilesSorter(Options options) {
        this.options = options;
    }

    public void mergeSortFiles() {
        FileSplitter fileSplitter = new FileSplitter(options);

        FilesMerger filesMerger = new FilesMerger(options);

        try {
            filesMerger.mergeFiles(fileSplitter.splitFiles());
        } catch (IOException e) {
            System.out.println(e.getMessage());

            Helper.getHelpCommand();
        }
    }


}
