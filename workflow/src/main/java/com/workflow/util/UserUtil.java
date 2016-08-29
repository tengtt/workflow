package com.workflow.util;

import org.activiti.engine.identity.User;

import javax.servlet.http.HttpSession;

 /**
  * 用户工具类
  *
 * Created by teng on 2016/8/4.
 */
public class UserUtil {

    public static final String USER = "user";

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
        session.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static User getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (User) attribute;
    }

     public static String findUserId(HttpSession session){
         User user = UserUtil.getUserFromSession(session);
         if(user == null){
             return "redirect:/main/index";
         }else{
             String userId = user.getId();
             return userId;
         }
     }

}
