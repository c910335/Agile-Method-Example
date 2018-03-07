package tw.tatsujin.sort;

import java.util.Arrays;

public class SortImpl implements Sort {

    private int[] array;
    private Comp comp;

    @Override
    public void sort(int[] array) {
        sort(array, true);
    }

    @Override
    public void sort(int[] array, boolean asc) {
        this.array = array;
        if (asc)
            comp = newAscComp();
        else
            comp = newDescComp();
        sort(0, array.length);
    }

    private void sort(int a, int n) {
        while (n > 1) {
            centerMedian(a, n);
            int c = partition(a, n);
            sort(c, n - c + a);
            n = c - a;
        }
    }

    private void centerMedian(int a, int n) {
        int b = a + n / 2, c = a + n - 1;

        if (comp.call(a, b) <= 0) {
            if (comp.call(b, c) <= 0)
                return;
            else if (comp.call(a, c) <= 0)
                swap(b, c);
            else {
                swap(a, c);
                swap(b, c);
            }
        } else if (comp.call(a, c) <= 0)
            swap(a, b);
        else if (comp.call(b, c) <= 0) {
            swap(a, b);
            swap(b, c);
        } else
            swap(a, c);
    }

    private int partition(int a, int n) {
        int v = n / 2, l = a + 1, r = a + n - 1;
        while(true) {
            while (comp.call(l, v) < 0)
                l++;
            r--;
            while (comp.call(v, r) < 0)
                r--;
            if (l >= r)
                return l;
            swap(l, r);
            l++;
        }
    }

    private Comp newAscComp() {
        return (x, y) -> {
            if (array[x] < array[y])
                return -1;
            else if (array[x] == array[y])
                return 0;
            return 1;
        };
    }

    private Comp newDescComp() {
        return (x, y) -> {
            if (array[x] > array[y])
                return -1;
            else if(array[x] == array[y])
                return 0;
            return 1;
        };
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    private interface Comp {
        int call(int x, int y);
    }
}
