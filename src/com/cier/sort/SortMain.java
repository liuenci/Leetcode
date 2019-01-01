package com.cier.sort;

public class SortMain {

    public static void main(String[] args) {
        Integer[] nums = new Integer[10];
        random(nums);
        Selection<Integer> selection = new Selection<>();
        selection.sort(nums);
        print("Selection", nums);

        random(nums);
        Bubble<Integer> bubble = new Bubble<>();
        bubble.sort(nums);
        print("Bubble", nums);

        random(nums);
        Insertion<Integer> insertion = new Insertion<>();
        insertion.sort(nums);
        print("Insertion", nums);

        random(nums);
        Shell<Integer> shell = new Shell<>();
        shell.sort(nums);
        print("Shell", nums);

        random(nums);
        Up2DownMergeSort<Integer> up2DownMergeSort = new Up2DownMergeSort<>();
        up2DownMergeSort.sort(nums);
        print("Up2DownMergeSort", nums);

        random(nums);
        Down2UpMergeSort<Integer> down2UpMergeSort = new Down2UpMergeSort<>();
        down2UpMergeSort.sort(nums);
        print("Down2UpMergeSort", nums);

      }

    // random
    public static void random(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100) + 1;
        }
    }

    // print
    public static void print(String name, Integer[] nums) {
        System.out.print(name + ": ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
