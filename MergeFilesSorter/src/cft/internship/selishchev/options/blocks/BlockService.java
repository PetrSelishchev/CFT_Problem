package cft.internship.selishchev.options.blocks;

import cft.internship.selishchev.options.dataRole.DataValidator;
import cft.internship.selishchev.options.dataRole.DataWrapper;

public class BlockService {
    public static String blockCommand = "-block";

    public static BlockMaxSize getSortingBlockMaxSize(Integer blockSize) {
        return (blockSize > 0) ? new BlockMaxSize(blockSize) : new BlockMaxSize();
    }

    public static boolean isBlockCommand(String command) {
        if (command.contains(blockCommand)) {
            return DataValidator.isDigit(command.substring(blockCommand.length()));
        }

        return false;
    }

    public static Integer getCount(String string) {
        return DataWrapper.getInteger(string.substring(blockCommand.length()));
    }
}
