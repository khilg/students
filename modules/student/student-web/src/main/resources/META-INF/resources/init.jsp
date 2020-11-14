<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="com.docs.assignment.student.service.StudentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.docs.assignment.student.model.Student"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.model.PersistedModel" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption" %>
<%@ page import="java.util.ArrayList" %>

<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption" %>

<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@page import="internal.security.permission.resource.StudentPermissionHelper"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/combine/npm/fullcalendar@5.3.2/main.min.css,npm/fullcalendar@5.3.2/main.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.2/main.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.2/main.min.css">
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.2/main.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.2/locales-all.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.3.2/main.min.js" ></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />



<%
String curPortletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
%>