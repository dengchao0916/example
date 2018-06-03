package com.dengchao.action;

import java.util.List;

import com.dengchao.dao.GoddessDao;
import com.dengchao.dao.ProduceDao;
import com.dengchao.model.Goddess;

public class GoddessAction {

    public List<Goddess> query() {
        GoddessDao dao = new GoddessDao();
        return dao.query();
    }

    public void add(Goddess goddess) {
        GoddessDao dao = new GoddessDao();
        dao.addGoddess(goddess);
    }

    public List<Goddess> queryByProduce() {
        ProduceDao dao = new ProduceDao();
        return dao.queryByProduce();
    }

    public List<Goddess> queryByProduceWithFilter(String spname) {
        ProduceDao dao = new ProduceDao();
        return dao.queryByProduceWithFilter(spname);
    }

    public Integer queryCount() {
        ProduceDao dao = new ProduceDao();
        return dao.queryCount();
    }

    public Integer queryCountByDbcp() {
        ProduceDao dao = new ProduceDao();
        return dao.queryCountByDbcp();
    }
}
