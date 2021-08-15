package com.mc.code;

/**
 * @author macheng
 * @date 2020/11/25 10:20
 * @desc 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        return find(nums1, nums2);
    }


    public double find(int[] nums1, int[] nums2) {

        return findForSameLengthArrays(nums1, nums2);
    }

    public double findForSameLengthArrays(int[] nums1, int[] nums2) {
        double result = 0;


        return result;
    }

    public static void main(String[] args) {
        System.out.println(test(new int[]{4},new int[]{3}));
    }
    public static double test(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length==0) {
            if (nums2 == null || nums2.length==0) {
                return 0;
            }
            if (nums2.length % 2 == 0) {

                return (((double)(nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2])) / 2);
            } else {
                return (nums2[nums2.length / 2]);
            }
        }

        if (nums2 == null || nums2.length==0) {
            if (nums1.length % 2 == 0) {
                return (((double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2])) / 2);
            } else {
                return (nums1[nums1.length / 2]);
            }
        }

        int num = nums1.length + nums2.length;

        if (num % 2 == 0) {

            int index = num / 2;
            int n1 = 0;
            int n2 = 0;

            int[] l = nums1.length >= nums2.length ? nums1 : nums2;
            int[] s = nums1.length >= nums2.length ? nums2 : nums1;


            int cindex = 0;

            int li = -1;
            int si = -1;

            while (cindex <= index) {
                if (si+1 < s.length && li+1 <l.length) {
                    if (l[li + 1] <= s[si + 1]) {
                        li++;
                        if (cindex == (index - 1)) {
                            n1 = l[li];
                        }
                        if (cindex == index) {
                            n2 = l[li];
                        }
                    } else {
                        si++;
                        if (cindex == (index - 1)) {
                            n1 = s[si];
                        }
                        if (cindex == index) {
                            n2 = s[si];
                        }
                    }

                } else if ( li+1 <l.length){
                    li++;
                    if (cindex == (index - 1)) {
                        n1 = l[li];
                    }
                    if (cindex == index) {
                        n2 = l[li];
                    }
                }else{
                    si++;
                    if (cindex == index-1) {
                        n1 = s[si];
                    }
                    if (cindex == index) {
                        n2 = s[si];
                    }
                }
                cindex++;
            }

            return (((double) (n1 + n2) )/ 2);
        } else {

            int index = num / 2;
            int n = 0;

            int[] l = nums1.length >= nums2.length ? nums1 : nums2;
            int[] s = nums1.length >= nums2.length ? nums2 : nums1;


            int cindex = 0;

            int li = -1;
            int si = -1;

            while (cindex <= index) {
                if (si+1 < s.length && li+1 <l.length) {
                    if (l[li + 1] <= s[si + 1]) {
                        li++;
                        if (cindex == index) {
                            n = l[li];
                        }
                    } else {
                        si++;
                        if (cindex == index) {
                            n = s[si];
                        }
                    }

                } else if ( li+1 <l.length){
                    li++;
                    if (cindex == index) {
                        n = l[li];
                    }
                }else {
                    si++;
                    if (cindex == index) {
                        n = s[si];
                    }
                }
                cindex++;
            }
            return n;
        }
    }
}
