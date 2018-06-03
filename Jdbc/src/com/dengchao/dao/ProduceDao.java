package com.dengchao.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dengchao.db.DBCPUtil;
import com.dengchao.db.DBUtil;
import com.dengchao.model.Goddess;

public class ProduceDao {
    public Integer queryCount() {
        Date a = new Date();
        Integer count = 0;
        Connection con = DBUtil.getConnection();
        try {
            con.setAutoCommit(false);// 关闭事务自动提交
            CallableStatement cs = con.prepareCall("call sp_select_count(?)");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            count = cs.getInt(1);
            con.commit();// 提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Date b = new Date();
        System.out.println(b.getTime() - a.getTime());
        return count;
    }

    public Integer queryCountByDbcp() {
        Date a = new Date();

        Integer count = 0;
        DBCPUtil db = new DBCPUtil();
        Connection con = db.getConn();
        try {
            con.setAutoCommit(false);// 关闭事务自动提交
            CallableStatement cs = con.prepareCall("call sp_select_count(?)");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            count = cs.getInt(1);
            con.commit();// 提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Date b = new Date();
        System.out.println(b.getTime() - a.getTime());
        return count;
    }

    public List<Goddess> queryByProduceWithFilter(String spname) {
        List<Goddess> list = new ArrayList<Goddess>();
        Goddess g = null;
        Connection con = DBUtil.getConnection();
        try {
            con.setAutoCommit(false);// 关闭事务自动提交
            CallableStatement cs = con.prepareCall("call sp_select_filter(?)");
            cs.setString(1, spname);
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                g = new Goddess();
                g.setId(rs.getInt("id"));
                g.setUser_name(rs.getString("user_name"));
                g.setAge(rs.getInt("age"));
                g.setAge(rs.getInt("sex"));
                g.setBirthday(rs.getDate("birthday"));
                g.setEmail(rs.getString("email"));
                g.setMobile(rs.getString("mobile"));
                g.setCreate_user(rs.getString("create_user"));
                g.setCreate_date(rs.getDate("create_date"));
                g.setUpdate_user(rs.getString("update_user"));
                g.setUpdate_date(rs.getDate("update_date"));
                list.add(g);
            }
            con.commit();// 提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    public List<Goddess> queryByProduce() {
        List<Goddess> list = new ArrayList<Goddess>();
        Goddess g = null;
        Connection con = DBUtil.getConnection();
        try {
            con.setAutoCommit(false);// 关闭事务自动提交
            CallableStatement cs = con.prepareCall("call sp_select_nofilter()");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                g = new Goddess();
                g.setId(rs.getInt("id"));
                g.setUser_name(rs.getString("user_name"));
                g.setAge(rs.getInt("age"));
                g.setAge(rs.getInt("sex"));
                g.setBirthday(rs.getDate("birthday"));
                g.setEmail(rs.getString("email"));
                g.setMobile(rs.getString("mobile"));
                g.setCreate_user(rs.getString("create_user"));
                g.setCreate_date(rs.getDate("create_date"));
                g.setUpdate_user(rs.getString("update_user"));
                g.setUpdate_date(rs.getDate("update_date"));
                list.add(g);
            }
            con.commit();// 提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

}
