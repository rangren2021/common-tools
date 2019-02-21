package com.study.common.server.exec;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test13
 * @Description TODO
 * @Author xinbang
 * @Date 2019/2/19 16:06
 * @Version 1.0
 **/

public class Test13 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode last = new ListNode(0);
        ListNode n1 = l1, n2 = l2, temp = last;
        boolean hasNext = true;
        while (hasNext) {
            int val1 = 0;
            int val2 = 0;
            if (n1 != null) {
                val1 = n1.val;
            }
            if (n2 != null) {
                val2 = n2.val;
            }
            int curr = temp.val;
            int value = val1 + val2;
            if (value + curr >= 10) {
                temp.val = (value + curr) % 10;
                curr = 1;
            } else {
                temp.val = value + curr;
                curr = 0;
            }
            n1 = n1 != null ? n1.next : null;
            n2 = n2 != null ? n2.next : null;
            hasNext = (n1 != null || n2 != null);
            if (hasNext || curr > 0) {
                temp = temp.next = new ListNode(curr);
            }
        }
        return last;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLength = 0;
        for(int i = 0;i<len;i++){
            List<Character> value = new ArrayList<Character>();
            for(int j = i;j<len;j++){
                char item = s.charAt(j);
                if(!value.contains(item)){
                    value.add(item);
                }else{
                    break;
                }
                if(maxLength < value.size()){
                    maxLength = value.size();
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
//        [2,4,3]
//        [5,6,4]
//        ListNode l1, ListNode l2
//        ListNode l1 = new ListNode(2);
//        ListNode nextl1 = new ListNode(4);
//        ListNode nextl2 = new ListNode(5);
//        l1.next = nextl1;
//        nextl1.next = nextl2;
//        ListNode l2 = new ListNode(5);
//        ListNode nextl3 = new ListNode(6);
//        ListNode nextl4 = new ListNode(4);
//        l2.next = nextl3;
//        nextl3.next = nextl4;
//
//        ListNode res = new Test13().addTwoNumbers(l1, l2);
//        System.out.println(res);

        int length = test13.lengthOfLongestSubstring(" ");
        System.out.println(length);
    }
}
