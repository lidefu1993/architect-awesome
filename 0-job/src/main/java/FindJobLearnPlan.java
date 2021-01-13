import com.ldf.architect.collect.ListTest;
import com.ldf.arithmetic.leetcode.RedundantConnection;
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
    PLAN_20210113("算法：冗余连接(leetcode), 知识点：Map", new Class[]{RedundantConnection.class, ListTest.class}),

    ;


    /**
     * 备注
     */
    private String remark;

    /**
     * 涉及类
     */
    private Class[] classes;

    FindJobLearnPlan(String remark, Class[] classes){
        this.remark = remark;
        this.classes = classes;
    }

}