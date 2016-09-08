<%@ page import="java.util.ArrayList" %>
<%@ page import="org.seckill.entity.Loginer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer userNumber = (Integer)request.getSession().getServletContext().getAttribute("userNumber");
    System.out.println(request.getSession());
    System.out.println(request.getSession().getAttributeNames());
%>

<html>
<body>
<h2>Hello World!</h2>

<form name="form" action="my/viewAll" method="post">
    用户名：<input type="text" name="name"><br/>
    密码：<input type="text" name="password"><br/>
    <input type="submit" value="登录"><br/>
</form>


当前在线人数：<%=userNumber%>;<br/>

<%
    ArrayList<org.seckill.entity.Loginer> loginerList =  (ArrayList<org.seckill.entity.Loginer>)request.getServletContext().getAttribute("loginList");

    if(loginerList != null){
        for(int i = 0; i < loginerList.size(); i++){
            org.seckill.entity.Loginer loginer = loginerList.get(i);

%>
        IP:<%=loginer.getIpString()%>,<br/>
        FirstTime:<%=loginer.getFirstTimesString()%>,<br/>
        sessionId:<%=loginer.getSessionIdString()%><br/>
    <%
    }
        }

    %>


<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>
