package com.dengchao.main;

import com.dengchao.action.GoddessAction;

public class Main {

    /**
     * @Decription:
     * @param args
     * @return:void
     */
    public static void main(String[] args) {

        // Goddess g = new Goddess();
        // g.setUser_name("小禾");
        // g.setAge(25);
        // g.setSex(1);
        // g.setBirthday(new Date());

        // GoddessAction action = new GoddessAction();
        // List<Goddess> list = action.query();
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        //
        // List<Goddess> list = action.queryByProduce();
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        GoddessAction action = new GoddessAction();
        // String spname = "儿";
        // List<Goddess> list = action.queryByProduceWithFilter(spname);
        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        System.out.println(action.queryCount());
        System.out.println(action.queryCountByDbcp());
    }
}
