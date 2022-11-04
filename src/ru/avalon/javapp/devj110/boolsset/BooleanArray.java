package ru.avalon.javapp.devj110.boolsset;

public class BooleanArray implements BoolsSet{
    private boolean[] bools = new boolean[SIZE];

    @Override
    public boolean check(int index) {
        checkIndex(index);
        return bools[index];
    }

    @Override
    public void  set(int index) {
        check(index);
        bools[index] = true;
    }

    @Override
    public void  set(int index, boolean value) {
        checkIndex(index);
        bools[index] = value;
    }

    @Override
    public void  clear(int index) {
        checkIndex(index);
        bools[index] = false;
    }

    @Override
    public void flip(int index) {
        checkIndex(index);
        bools[index] = !bools[index];
    }

    @Override
    public int count() {
        int res = 0;
        for(boolean el : bools) {
            if(el) res++;
        }
        return res;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= bools.length) {
            throw new IllegalArgumentException("index is out of bounds of BoolSet");
        }
    }

    @Override
    public String toString() {
//        не эффективно
//        String res = "";
//        for(boolean b : bools) {
//            res += b ? '1' : '0';
//        }
//        return res;

        /* уже хорошо
        StringBuffer sb = new StringBuffer();
        // можно сразу задать емкость будет еще быстрее
        // StringBuffer sb = new StringBuffer(SIZE);
        for(boolean b : bools) {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();*/

        // быстрее всего
        char[] ac = new char[SIZE];
        for(int i = 0; i < bools.length; i++) {
            ac[i] = bools[i] ? '1' : '0';
        }
        return new String(ac);
    }
}
