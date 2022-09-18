package cft.internship.selishchev.options.blocks;

public class BlockMaxSize {
    public static final int defaultSize = 100000;

    private int size;

    public BlockMaxSize(int size) {
        this.size = size;
    }

    public BlockMaxSize() {
        size = BlockMaxSize.defaultSize;
    }

    public int getSize() {
        return size;
    }
}
