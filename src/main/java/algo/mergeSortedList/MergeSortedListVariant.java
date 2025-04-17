package algo.mergeSortedList;

import algo.common.ListNode;
import algo.common.ListNodeHelper;

/*
Meta variation
21. Merge Three sorted lists

Input: listA = [1,2,2], listB = [3,4], listC = [2,6]
output: [1,2,2,2,3,4,6]

Divide and conquer approach
Time Complexity: O(n)
*/
public class MergeSortedListVariant {

    public static ListNode mergeThreeSortedList(ListNode list1, ListNode list2, ListNode list3) {
        ListNode mergedList = mergeTwoSortedList(list1, list2);
        return mergeTwoSortedList(mergedList, list3);
    }

    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 != null ? list1 : list2;

        return dummy.next;
    }



    public static void main(String[] args) {
        // Creating three sorted linked lists
        ListNode listA = ListNodeHelper.createList(new int[]{1, 2});
        ListNode listB = ListNodeHelper.createList(new int[]{3, 4});
        ListNode listC = ListNodeHelper.createList(new int[]{2, 6});

        // Merge using divide and conquer
        ListNode mergedAll = mergeThreeSortedList(listA, listB, listC);

        // Print the result
        ListNodeHelper.printList(mergedAll);
    }


}
