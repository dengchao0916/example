package com.dengchao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.dengchao.db.DBUtil;
import com.dengchao.model.Goddess;

public class GoddessDao {
	public void addGoddess(Goddess g) {
		String sql = "insert into imooc_goddess"
				+ "(user_name,sex,age,birthday,email,"
				+ "mobile,create_user,create_date,update_user,update_date)"
				+ "values(?,?,?,?,?,?,?,current_date(),?,current_date())";
		DBUtil.prepareStatement(sql);
		try {
			DBUtil.stmt.setString(1, g.getUser_name());
			DBUtil.stmt.setInt(2, g.getSex());
			DBUtil.stmt.setInt(3, g.getAge());
			DBUtil.stmt.setDate(4, new Date(g.getBirthday().getTime()));
			DBUtil.stmt.setString(5, g.getEmail());
			DBUtil.stmt.setString(6, g.getMobile());
			DBUtil.stmt.setString(7, g.getCreate_user());
			DBUtil.stmt.setString(8, g.getUpdate_user());
			DBUtil.executeInsert();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
		}

	}

	public void delGoddess() {

	}

	public void updateGoddess() {

	}

	public List<Goddess> query() {
		String sql = "select * from imooc_goddess";
		DBUtil.prepareStatement(sql);
		ResultSet rs = DBUtil.getResultSetQuery();
		List<Goddess> gList = new ArrayList<Goddess>();
		Goddess g = null;
		try {
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
				gList.add(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close();
		}
		return gList;
	}

	public Goddess get(int id) {
		return null;
	}
}
