package cft.internship.selishchev.parserCLI;

import cft.internship.selishchev.options.Options;
import cft.internship.selishchev.options.OptionsImp;
import cft.internship.selishchev.options.SortOrder;
import cft.internship.selishchev.options.blocks.BlockMaxSize;
import cft.internship.selishchev.options.blocks.BlockService;
import cft.internship.selishchev.options.dataRole.DataRole;

import java.util.ArrayList;

public class ParserCLImp implements ParserCLI{

    @Override
    public Options parseCommandLine(String[] commandLine) {
        if (commandLine.length > 0) {
            if (commandLine[0].equals("-help")) {
                Helper.help();

                System.exit(0);
            }
        }

        SortOrder sortOrder = SortOrder.ASCENDING;
        DataRole dataRole = DataRole.NOT_INSTALLED;
        BlockMaxSize blockMaxSize = new BlockMaxSize();
        ArrayList<String> filesList = new ArrayList<>();

        try {
            if (commandLine.length < 3) {
                throw new IllegalArgumentException("Введены не все параметры. Пожалуйста, введите команду заново или воспользуйтесь -help");
            }

            for (String arg : commandLine) {
                if (BlockService.isBlockCommand(arg)) {
                    int size = BlockService.getCount(arg);
                    if (size > 0) {
                        blockMaxSize = BlockService.getSortingBlockMaxSize(size);
                    }

                    continue;
                }

                switch (arg) {
                    case ("-d"):
                        sortOrder = SortOrder.DESCENDING;
                        break;
                    case ("-a"):
                        sortOrder = SortOrder.ASCENDING;
                        break;
                    case ("-i"):
                        dataRole = DataRole.INTEGER;
                        break;
                    case ("-s"):
                        dataRole = DataRole.STRING;
                        break;
                    default:
                        filesList.add(arg);
                        break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            Helper.getHelpCommand();

            System.exit(0);
        }

        return new OptionsImp(sortOrder, dataRole, filesList, blockMaxSize);
    }
}
