package com.epam.training.sort.binary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.epam.training.sort.binary.BinarySearchIteratively.BinarySearchIterative;
import static com.epam.training.sort.binary.BinarySearchRecursively.BinarySearchRecursive;

public class Running {

    private static final Logger LOGGER = LoggerFactory.getLogger(Running.class);

    public static void main(String[] args) {
        int count = 0;
        int a[] = {-15, -6, 0, 7, 9, 23, 54, 82, 101, 112, 125, 131, 142, 151};
        int x = 8;
        int l = 0;
        int h = a.length - 1;
        LOGGER.debug("x is found in index:" + BinarySearchIterative(a, x));
        LOGGER.debug("x is found in index:" + BinarySearchRecursive(a, l, h, x));
        LOGGER.debug("Number of comparison=" + count);
    }
}
