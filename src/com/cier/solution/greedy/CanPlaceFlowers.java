package com.cier.solution.greedy;

/**
 * @program: Leetcode
 * @description: 种花问题
 * @author: liuenci
 * @create: 2021-12-21 22:49
 **/
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0) {
                break;
            }
            if (flowerbed[i] == 1 || (i != 0 && flowerbed[i - 1] == 1) || (flowerbed.length > 2 && i != flowerbed.length - 1 && flowerbed[i + 1] == 1) ) {
                continue;
            } else {
                n--;
                flowerbed[i] = 1;
                continue;
            }
        }
        return n <= 0 ? true : false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1,0,0};
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        canPlaceFlowers.canPlaceFlowers(a, 2);
    }
}
