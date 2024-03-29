package com.akabynga.multithreading.forkjoin;

import java.util.concurrent.RecursiveAction;

public class MergeSortAction extends RecursiveAction {

    private final int[] array;

    public MergeSortAction(int[] array) {
        this.array = array;
    }

    @Override
    protected void compute() {
        if (array.length < 2) return;
        int mid = array.length / 2;

        int[] left = new int[mid];
        System.arraycopy(array, 0, left, 0, mid);

        int[] right = new int[array.length - mid];
        System.arraycopy(array, mid, right, 0, array.length - mid);

        invokeAll(new MergeSortAction(left), new MergeSortAction(right));
        merge(left, right);
    }

    private void merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}