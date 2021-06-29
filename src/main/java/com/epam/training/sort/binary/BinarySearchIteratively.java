package com.epam.training.sort.binary;

public class BinarySearchIteratively {

    static int count = 0;

    static int BinarySearchIterative(int a[], int x) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
