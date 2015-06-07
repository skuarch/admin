<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="cons" class="model.logic.Constants" />
<c:choose>
    <c:when test="${fn:length(payments) <= 0}">
        <div class="alert alert-warning">
            <spring:message code="text226"/>
        </div>
    </c:when>
    <c:otherwise>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                            <tr>
                                <th>
                                    <spring:message code="text367" />
                                </th>
                                <th>
                                    <spring:message code="text369" />
                                </th>                                
                                <th>
                                    <spring:message code="text375" />
                                </th>
                                <th>
                                    <spring:message code="text373" />
                                </th>
                                <th>
                                    <spring:message code="text372" />
                                </th>
                                <th>
                                    <spring:message code="text370" />
                                </th>
                                <th>
                                    <spring:message code="text368" />
                                </th>
                                <th>
                                    <spring:message code="text374" />
                                </th>
                            </tr>
                        </thead>
                        <tbody>  
                            <c:forEach var="p" items="${payments}">
                                <tr>
                                    <td>
                                        ${p.getId()}
                                    </td>
                                    <td>
                                        ${p.getCreationDate()}
                                    </td>                                    
                                    <td>
                                        ${p.getLastUpdate()}
                                    </td>        
                                    <td>
                                        ${p.cashier.person.getEmail()}
                                    </td>
                                    <td>
                                        ${p.recipient.getEmail()}
                                    </td>
                                    <td>
                                        ${p.secret.getSecretAlphanumeric()}
                                    </td>
                                    <td>
                                        ${p.getAmount()}
                                    </td>
                                    <td>
                                        ${p.paymentStatus.getName()}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<script type="text/javascript">eval("${js}");</script>        
