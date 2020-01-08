package com.safe.core.utils;

import javax.servlet.http.HttpSession;

import com.safe.core.filter.SessionListener;

public class SessionUtils {
	public static void sessionHandlerByCacheMap(HttpSession session){
		String userid=session.getAttribute("username").toString();
		if(SessionListener.sessionContext.getSessionMap().get(userid)!=null){
			HttpSession userSession=(HttpSession)SessionListener.sessionContext.getSessionMap().get(userid);
			//注销在线用户
			userSession.invalidate();			
			SessionListener.sessionContext.getSessionMap().remove(userid);
			//清除在线用户后，更新map,替换map sessionid
			SessionListener.sessionContext.getSessionMap().remove(session.getId());	
			SessionListener.sessionContext.getSessionMap().put(userid,session);	
		}
		else
		{
			// 根据当前sessionid 取session对象。 更新map key=用户名 value=session对象 删除map
           	SessionListener.sessionContext.getSessionMap().get(session.getId());
			SessionListener.sessionContext.getSessionMap().put(userid,SessionListener.sessionContext.getSessionMap().get(session.getId()));
			SessionListener.sessionContext.getSessionMap().remove(session.getId());
		}
	}
}
