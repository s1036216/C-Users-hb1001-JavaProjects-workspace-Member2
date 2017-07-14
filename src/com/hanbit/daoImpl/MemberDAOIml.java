package com.hanbit.daoImpl;

//sql연결할때
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.dao.MemberDAO;
import com.hanbit.member.constants.DB;
import com.hanbit.member.domain.MemberBean;
public class MemberDAOIml implements MemberDAO {
	
	public MemberDAOIml(){
		
		try {
			Class.forName(DB.DRIVER);    //공유되서 생성자로 위에만둠  //호출
			
		} catch (Exception e) {
			System.out.println("로드실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int insert(MemberBean bean) {
		int rs=0;
		try {
			//rs=DriverManager.getConnection 손오공이 카피해서 보내는문법
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD)//너무빠르다 담자마자 결국 객체가된다 호출하자마자
				.createStatement()
				.executeUpdate(
				String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES('%s','%s','%s','%s',SYSDATE)",
					DB.TABLE_MEMBER,
					DB.MEMBER_ID,DB.MEMBER_NAME,DB.MEMBER_PASS,DB.MEMBER_SSN,DB.MEMBER_REGDATE,
					bean.getId(),bean.getName(),bean.getPassword(),bean.getSsn())
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list=new ArrayList<>(); //이거때문에 와일문
		
		try {
			
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD)
							.createStatement().executeQuery(String.format("SELECT *FROM %s",DB.TABLE_MEMBER));
			MemberBean member=null; //아파트대지땅구입
		while(rs.next()){ //rs.next 무조건
			member=new MemberBean(); //건물올림 살사람들 들어오게
			member.setId(rs.getString(DB.MEMBER_ID)); //입주
			member.setName(rs.getString(DB.MEMBER_NAME));
			member.setPassword(rs.getString(DB.MEMBER_PASS));
			member.setSsn(rs.getString(DB.MEMBER_SSN));
			member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
			
			list.add(member); //분양완료
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> temp=new ArrayList<>();
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format
					("SELECT *FROM %s WHERE %s = '%s'",DB.TABLE_MEMBER,DB.MEMBER_NAME,name));
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				temp.add(member);
			System.out.println(temp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}

	@Override
	public MemberBean selectById(String id) {
		// TODO Auto-generated method stub
		MemberBean member=new MemberBean();
				try {
					Connection conn=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(String.format("SELECT *FROM %s WHERE id= '%s'",DB.TABLE_MEMBER,id));
																							//'%s'넣는값은 싱글쿼터
				if(rs.next()){
						
						member.setId(rs.getString(DB.MEMBER_ID));
						member.setName(rs.getString(DB.MEMBER_NAME));
						member.setPassword(rs.getString(DB.MEMBER_PASS));
						member.setSsn(rs.getString(DB.MEMBER_SSN));
						member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return member;
	}
	@Override
	public int count() {
	 
		int count=0;
		try {
				Connection conn=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(String.format("SELECT COUNT(*) AS %s FROM %s","count", DB.TABLE_MEMBER));
			
				if(rs.next()){
					count=Integer.parseInt(rs.getString("count"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return count;
	}

	@Override
	public int update(MemberBean bean) {
		int rs=0;
	
		try {
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD)
				.createStatement()
				.executeUpdate(
				String.format("%s","")
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;// TODO Auto-generated method stub
	
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD)
				.createStatement()
				.executeUpdate(
				String.format("INSERT INTO Member VALUES('%s','%s','%s','%s',SYSDATE)","")
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}
