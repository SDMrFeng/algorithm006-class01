package G20200343030379;/**
 * @ClassName:
 * @Description: TODO
 * @author linyb3
 * @date
 */

/**
 * @ClassName:
 * @Description: TODO
 * @author linyb3
 * @date
 *
 */
public class LeetCode_26_379 {
    public int removeDuplicates(int[] nums) {
        int head=0;
        int tail=1;
        int count=1;
        if(nums.length==0) return 0;
        // if(nums.length>1){
        //     head=0;
        //     tail=1;
        // }else{
        //     //ֻ��һ��ԭ������
        //     return count;
        // }
        int c=0;
        for(;tail<nums.length;){
            //System.out.print("�ﵽ");

            //��ͬ���ƶ�tail
            if(nums[head]==nums[tail]){
                tail++;
            }

            //�߽紦��
            if(tail>nums.length-1){
                return count;
            }

            //��ͬ�����ƶ�head��������
            if(nums[head]!=nums[tail]){  //System.out.print("����");
                head++;
                nums[head]=nums[tail];
                count++;
                tail++;
            }
            //c++;
        }
        //System.out.print("����");
        //System.out.print(c);
        return count;
    }
}
