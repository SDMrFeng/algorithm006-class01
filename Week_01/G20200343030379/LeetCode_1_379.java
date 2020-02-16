package G20200343030379;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName:
 * @Description: TODO
 * @author linyb3
 * @date
 */
public class LeetCode_1_379 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    //�ݹ鷨
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }

        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    //������
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //1��ʼ��
        ListNode prehdead=new ListNode(-1);
        ListNode prev=prehdead;

        //2����
        while(l1!=null && l2!=null){
            //2.1����ѡ��·��
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;

            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;

        }


        //3���ѡ����β
        prev.next=(l1==null?l2:l1);
        //4��������
        return prehdead.next;
    }
}
