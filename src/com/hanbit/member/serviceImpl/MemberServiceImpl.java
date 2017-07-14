package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.dao.MemberDAO;
import com.hanbit.daoImpl.MemberDAOIml;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	List<MemberBean> list;// 1순위 큰놈\
	// 4번째 (인스턴스변수)
	Map<String,MemberBean> map;
	MemberBean member;
	public MemberServiceImpl() { // 2번 생성자 만들고
		member = new MemberBean();
		map=new HashMap<>();
		list = new ArrayList<MemberBean>(); // 3리스트를 초기화
	}
	@Override
	public String addMember(MemberBean bean) {
		return new MemberDAOIml().insert(bean)==1?"가입성공":"실패";
	}
	@Override
	public List<MemberBean> list() {
		return new MemberDAOIml().selectAll();
	}
	@Override
	public List<MemberBean> findByName(String name) {
	return new  MemberDAOIml().selectByName(name);
	}
	@Override
	public MemberBean findById(String id) {
		MemberDAO dao=new  MemberDAOIml();
		MemberBean member=new MemberBean();
		member=dao.selectById(id);
		return member;
	}
	@Override
	public int count() {
		return new  MemberDAOIml().count();
	}
	@Override
	public String modify(MemberBean bean) {
		String msg="";
	findById(bean.getId()).setName(bean.getName());
	findById(bean.getId()).setSsn(bean.getSsn());
	findById(bean.getId()).setPassword(bean.getPassword());
	return msg;
	}
	@Override
	public String remove(String id) {
		String msg="";
		for (MemberBean m:list){
			if(id.equals(m.getId())){
				list.remove(m);
			}	
		}
		return msg;
	}
}
