package com.dengchao.recursion;

/*汉诺塔问题：一次只能移动一个盘子；
 不能把大盘子放在小盘子上；除去盘子在两个柱子之间移动的瞬间，
 盘子必须都在柱子上。
 （在这三点要求下把盘子从起始柱子A全部移动到目标柱子C上）*/
public class HanNuoTower {

    public static void main(String[] args) {
        HanNuoTower hnt = new HanNuoTower();
        hnt.tower(4, 'A', 'B', 'C');
    }

    // n个塔从s经过m最终全部移动到e
    public void tower(int n, char s, char m, char e)
    {
        if (n == 1)
            move(s, e);
        else
        {
            tower(n - 1, s, e, m);
            move(s, e);
            tower(n - 1, m, s, e);
        }
    }

    public void move(char s, char e) {
        System.out.println("move " + s + " to " + e);
    }
}
