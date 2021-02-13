package com.ldf.arithmetic.other;

/**
 * 子弹打怪
 */
public class BulletFightMonsters {

    /**
     * 射出的子弹会在敌人间跳跃，一发子弹就能对所有敌人造成 2 点伤害，如果该子弹导致了任意敌人死亡（即血量小于等于 0），该子弹还会再次对所有敌人造成2点伤害，直到没有新的敌人死亡为止。
     *
     * 那么，高弗雷需要打出几颗子弹才能消灭所有敌人呢？
     */

    public static void main(String[] args) {
        BulletFightMonsters monsters = new BulletFightMonsters();
        int count = monsters.bulletCount(new int[]{1,4});
        System.out.println(count);
    }

    /**
     *  错误！！！
     * @param monsters 各个怪物血量
     * @return -
     */
    public int bulletCount(int[] monsters){
        //是否存在未被消灭的怪物
        boolean exist = true;
        int res=0;
        while (exist){
            res++;
            int hurt = 2;
            while (hurt > 0 && exist){
                boolean e = false;
                for(int i=0; i<monsters.length; i++){
                    int m = monsters[i];
                    if(m<=0){
                        continue;
                    }
                    monsters[i]=m-hurt;
                    m-=hurt;
                    if(m-hurt>0){
                        e=true;
                    }else {
                        hurt+=2;
                    }
                }
                exist = e;
            }
        }
        return res;
    }

}
