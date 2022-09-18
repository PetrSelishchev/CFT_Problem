package cft.internship.selishchev.main;

import cft.internship.selishchev.filesSorter.FilesSorter;
import cft.internship.selishchev.parserCLI.ParserCLI;
import cft.internship.selishchev.options.Options;
import cft.internship.selishchev.parserCLI.ParserCLImp;


public class   Main {
    public static void main(String[] args) {

        ParserCLI parserCLI = new ParserCLImp();
        Options options = parserCLI.parseCommandLine(args);
        FilesSorter filesSorter = new FilesSorter(options);

        filesSorter.mergeSortFiles();
    }
}
