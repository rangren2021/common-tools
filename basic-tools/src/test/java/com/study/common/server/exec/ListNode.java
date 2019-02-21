package com.study.common.server.exec;

import lombok.Data;

@Data
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }