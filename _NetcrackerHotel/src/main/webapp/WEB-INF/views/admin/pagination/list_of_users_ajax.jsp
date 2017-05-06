<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
   "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="pg" uri="http://pagination/pagination-spring3.tld" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<pg:pagination_ajax pparam="${pparam}" paginationResult="${paginationResult}">
    <jsp:attribute name="columnsContent">
                <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.username}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.authority}"/></span></td>
                    <td class="cell"><span style="white-space:nowrap;"><c:out value="${bo.enabled}"/></span></td>
                    <td class="cell"><span><c:out value="${bo.email}"/></span></td> 
                    <td class="cell"><span><a href="edit_form/${bo.username}">See profile</a> </span></td> 
                </jsp:attribute>
</pg:pagination_ajax>
<script>
    $('#selectall').click(function() {
        if(this.checked) { // check select status
            $('.paginationCheckbox').each(function() {
                this.checked = true;
            });
        }else{
            $('.paginationCheckbox').each(function() {
                this.checked = false;
            });         
        }
    });
</script>