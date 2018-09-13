<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-04
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.company.MenuDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.domain.MenuVO" %>
<%
    int sno = Integer.parseInt(request.getParameter("sno"));
    MenuDAO dao = new MenuDAO();
    List<MenuVO> menuVOList = dao.getMenus(sno);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>리뷰를 등록합니다.</h1>
 <h1><%=menuVOList%></h1>
 <select name="mno">
     <% for(MenuVO vo: menuVOList){ %>
     <option value="<%=vo.getMno()%>"><%=vo.getMname()%><%=vo.getPrice()%></option>
     <% }%>
 </select>
</body>
</html>
