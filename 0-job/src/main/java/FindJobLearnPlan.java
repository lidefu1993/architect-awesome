import com.ldf.architect.collect.ListTest;
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
    PLAN_20210108("链表重置&&List集合", new Class[]{LinkReset.class, ListTest.class}),
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
