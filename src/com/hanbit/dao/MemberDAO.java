package com.hanbit.dao;

import java.util.List;

import com.hanbit.member.domain.MemberBean;

public interface MemberDAO {
	public int insert(MemberBean bean);
	public List<MemberBean> selectAll();
	public List<MemberBean> selectByName(String name);
	public MemberBean selectById(String id);
	public int count();
	public int update(MemberBean bean);
	public int delete(String id);
}
