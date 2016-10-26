package csc171.workshop;

/*
 * 04212015.java
 * Version 1.0
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015
 * Assignment: LAB 01
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen
 * Last Revised: 4/27/15
 */

public class GenericTest<K, V> {
    K k;
    V v;

    public GenericTest(K k, V v) {
        this.k = k;
        this.v = v;
    }
}
