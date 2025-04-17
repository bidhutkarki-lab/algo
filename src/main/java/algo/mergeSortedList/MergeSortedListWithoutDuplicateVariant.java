package algo.mergeSortedList;

import algo.common.ListNode;
import algo.common.ListNodeHelper;

/*
Meta variation
21. Merge Three sorted lists without duplicate

Input: listA = [1,2,2], listB = [3,4], listC = [2,6]
output: [1,2,3,4,6]

Divide and conquer approach
Time Complexity: O(n)
*/
public class MergeSortedListWithoutDuplicateVariant {

    public static ListNode mergeThreeSortedList(ListNode list1, ListNode list2, ListNode list3) {
        ListNode mergedList = mergeTwoSortedList(list1, list2);
        return mergeTwoSortedList(mergedList, list3);
    }

    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        Integer lastVal = null;
        while(list1 != null && list2 != null) {
            int val = 0;
            if(list1.val < list2.val) {
                val = list1.val;
                list1 = list1.next;
            } else if(list2.val < list1.val) {
                val = list2.val;
                list2 = list2.next;
            } else { // in case of equal
                val = list1.val;
                list1 = list1.next;
                list2 = list2.next;
            }

            if(lastVal == null || val != lastVal) {
                current.next = new ListNode(val);
                current = current.next;
                lastVal = val;
            }

        }

        while(list1 != null) {
            int val = list1.val;
            list1 = list1.next;
            if(lastVal == null || val != lastVal) {
                current.next = new ListNode(val);
                current = current.next;
                lastVal = val;
            }
        }

        while(list2 != null) {
            int val = list2.val;
            list2 = list2.next;
            if(lastVal == null || val != lastVal) {
                current.next = new ListNode(val);
                current = current.next;
                lastVal = val;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Creating three sorted linked lists
        ListNode listA = ListNodeHelper.createList(new int[]{1, 2, 2});
        ListNode listB = ListNodeHelper.createList(new int[]{3, 4});
        ListNode listC = ListNodeHelper.createList(new int[]{2, 6});

        // Merge using divide and conquer
        ListNode mergedAll = mergeThreeSortedList(listA, listB, listC);

        // Print the result
        ListNodeHelper.printList(mergedAll);
    }


    // Helper to print the linked list
}
