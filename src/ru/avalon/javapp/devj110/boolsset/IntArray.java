package ru.avalon.javapp.devj110.boolsset;

public class IntArray implements BoolsSet{
    private int[] array = new int[SIZE/32];


    @Override
    public boolean check(int index) {
        checkIndex(index);
        int cellNum = getCellNum(index);
        int bitIndx = getbitIndx(index);
        int res = array[cellNum] & 1 << 31 - bitIndx;
        return res > 0;
    }

    @Override
    public void set(int index) {
        checkIndex(index);
        int cellNum = getCellNum(index);
        int bitIndx = getbitIndx(index);
        array[cellNum] |= 1 << 31 - bitIndx;
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        int cellNum = getCellNum(index);
        int bitIndx = getbitIndx(index);
        if(value)
            array[cellNum] |= 1 << 31 - bitIndx;
        else
            array[cellNum] &= ~(1 << 31 - bitIndx);
    }

    @Override
    public void clear(int index) {
        checkIndex(index);
        int cellNum = getCellNum(index);
        int bitIndx = getbitIndx(index);
        array[cellNum] &= ~(1 << 31 - bitIndx);
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        int cellNum = getCellNum(index);
        int bitIndx = getbitIndx(index);
        array[cellNum] ^= 1 << 31 - bitIndx;
    }

    @Override
    public int count() {
        int res = 0;
        for (int el: array) {
            res += Integer.bitCount(el);
        }
        return res;
    }

        @Override
    public String toString() {
            StringBuffer sb = new StringBuffer(SIZE);
            for (int el:array) {
                sb.append(String.format("%32s", Integer.toBinaryString(el)).replace(' ', '0'));
            }
        return sb.toString();
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= SIZE) {
            throw new IllegalArgumentException("index is out of bounds of BoolSet");
        }
    }

    private int getCellNum(int index){
        return index / array.length;
    }

    private int getbitIndx(int index) {
        return index % 32;
    }
}
