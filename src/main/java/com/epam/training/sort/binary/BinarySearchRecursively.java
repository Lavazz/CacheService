package com.epam.training.sort.binary;

public class BinarySearchRecursively {

    static int count = 0;

    static int BinarySearchRecursive(int a[], int l, int h, int x) {
        if (l == h) {
            count++;
            if (a[l] == x) {
                return l;
            } else {
                return -1;
            }
        } else {
            int mid = (l + h) / 2;
            if (a[mid] == x) {
                count++;
                return mid;
            } else if (a[mid] < x) {
                count++;
                return BinarySearchRecursive(a, mid + 1, h, x);
            } else {
                count++;
                return BinarySearchRecursive(a, l, mid - 1, x);
            }
        }

    }
}
