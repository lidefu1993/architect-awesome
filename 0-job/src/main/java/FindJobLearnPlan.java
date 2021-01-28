import com.ldf.architect.collect.ListTest;
import com.ldf.architect.collect.MapTest;
import com.ldf.arithmetic.leetcode.*;
import com.ldf.arithmetic.other.LinkReset;

import java.util.List;

/**
 * @author ldf
 * @date 2021/1/7 22:07
 **/
public enum  FindJobLearnPlan {

    /**
     *  学习计划
     */
    PLAN_20210108("算法：链表重置, 知识点：List", new Class[]{LinkReset.class, ListTest.class}),
    PLAN_20210113("算法：冗余连接(leetcode), 知识点：Map", new Class[]{RedundantConnection.class, MapTest.class}),
    PLAN_20210114("算法：可被 5 整除的二进制前缀", new Class[]{PrefixesDivBy5.class}),
    PLAN_20210116("算法：打砖块（未解决）", new Class[]{HitBricks.class}),
    PLAN_20210121("算法：并查集", new Class[]{RedundantConnection.class}),
    PLAN_20210125("动态规划", new Class[]{StockMaxProfit.class, MaxSubArray.class,
            IsSubsequence.class, ClimbingStairs.class, MinCostClimbingStairs.class, Masseur.class, NumArray.class
    })

    ;


    /**
     * 备注
     */
    private String remark;

    /**
     * 涉及类FF
     */
    private Class[] classes;

    FindJobLearnPlan(String remark, Class[] classes){
        this.remark = remark;
        this.classes = classes;
    }

}
