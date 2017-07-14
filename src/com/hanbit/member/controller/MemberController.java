package com.hanbit.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberService service=new MemberServiceImpl();
		MemberBean bean=null;
		List<MemberBean> temp =new ArrayList<MemberBean>();
		Butt[] buttons ={Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN", // frame title
					"SELECT MENU",  //order
					JOptionPane.QUESTION_MESSAGE,//type
					null, // icon
					buttons,//	Array of choices
					buttons[1] //default
					))	{
			case EXIT:
				return;
			case ADD:
				bean=new MemberBean();
				String[] arr=JOptionPane.showInputDialog("ID/NAME/PASSWOD/SSN").split("/");
				bean.setId(arr[0]);
				bean.setName(arr[1]);
				bean.setPassword(arr[2]);
				bean.setSsn(arr[3]);
				service.addMember(bean);
				JOptionPane.showMessageDialog(null,"가입완료");
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null,service.findByName(JOptionPane.showInputDialog("NAME")));
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("ID")).toString());
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null,"count"+service.count());
				break flag;
			case UPDATE:
				bean=new MemberBean();
				String[] arr4=JOptionPane.showInputDialog("ID/변경할이름/주민번호/패스워드").split("/");
				bean.setId(arr4[0]);
				bean.setName(arr4[1]);
				bean.setSsn(arr4[2]);		
				bean.setPassword(arr4[3]);
				
				service.modify(bean);
				JOptionPane.showMessageDialog(null,"update");
				break flag;
			case DEL:
				service.remove(JOptionPane.showInputDialog("삭제할ID"));
				JOptionPane.showMessageDialog(null,"삭제완료");
				break flag;
			
			}
		}while(true);
	}
}
