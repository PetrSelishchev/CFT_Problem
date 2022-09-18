package cft.internship.selishchev.filesSorter;




import cft.internship.selishchev.options.Options;
import cft.internship.selishchev.options.dataRole.DataRole;
import cft.internship.selishchev.options.dataRole.DataValidator;
import cft.internship.selishchev.options.dataRole.DataWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileSplitter {
    private Options options;

    public FileSplitter(Options options) {
        this.options = options;
    }

    public ArrayList<File> splitFiles() {
        ArrayList<File> files = new ArrayList<>();

        for (String fileName : options.getFilesNameList()) {
            files.addAll(splitFile(new File(fileName)));
        }

        return files;
    }

    private ArrayList<File> splitFile(File file) {
        ArrayList<File> tempFiles = new ArrayList<>();
        String[] block = new String[options.getBlockMaxSize()];

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int sizeCurrentBlock = 0;
            String currentLine;

            while (true) {
                currentLine = bufferedReader.readLine();
                if (currentLine != null) {
                    block[sizeCurrentBlock] = currentLine;

                    if (sizeCurrentBlock + 1 == options.getBlockMaxSize()) {
                        tempFiles.add(createTempFile(block));
                        sizeCurrentBlock = 0;

                        Arrays.fill(block, null);
                    } else {
                        ++sizeCurrentBlock;
                    }
                } else {
                    if (sizeCurrentBlock > 0) {
                        tempFiles.add(createTempFile(block));
                    }

                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return tempFiles;
    }

    private File createTempFile(String[] block) throws IOException {
        String tempFilePrefix = "sort-temp-file-";

        File newFile = File.createTempFile(tempFilePrefix, null);
        try (FileWriter fileWriter = new FileWriter(newFile);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            String[] correctBlock = DataValidator.deleteNull(block);

            if (options.getDataRole() == DataRole.INTEGER) {
                Integer[] data = DataWrapper.getIntegerData(correctBlock);

                options.getSorter().sort(data, options.getSortComparator());

                for (Integer s : data) {
                    printWriter.println(s);
                }
            } else {
                String[] data = DataWrapper.getStringData(correctBlock);

                options.getSorter().sort(data, options.getSortComparator());

                for (String s : data) {
                    printWriter.println(s);
                }
            }
        }

        return newFile;
    }
}
