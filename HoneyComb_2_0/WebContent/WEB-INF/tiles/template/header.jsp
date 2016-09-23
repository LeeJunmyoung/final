<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<tiles:importAttribute name="menuList" />

<c:forEach var="menu" items="${menuList}">${menu} </c:forEach>
<br>
환영합니다!
