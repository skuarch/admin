<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="cons" class="model.logic.Constants" />
<c:choose>
    <c:when test="${fn:length(payments) > 0}">        
        <input type="button" value="pagar" class="btn btn-success btn-lg btn-block" onclick="doPay()"/>        
        <br/>
    </c:when>
</c:choose>
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
                                    #
                                </th>
                                <th>
                                    <spring:message code="text369" />
                                </th>                                
                                <th>
                                    <spring:message code="text375" />
                                </th>
                                <th>
                                    <spring:message code="text385" />                                    
                                </th>
                                <th>
                                    <spring:message code="text383" />

                                </th>
                                <th>
                                    <spring:message code="text389" />
                                </th>
                                <th>
                                    <spring:message code="text390" />
                                </th>
                                <th>

                                    <spring:message code="text382" />
                                </th>
                                <th>

                                    <spring:message code="text384" />                                    
                                </th>
                                <th>
                                    <spring:message code="text374" />
                                </th>
                                <th>
                                    <spring:message code="text380" />
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
                                        ${p.getAmount()}
                                    </td>
                                    <td>
                                        ${p.getDiscountPercentage()}
                                    </td>
                                    <td>
                                        ${p.getProfit()}
                                    </td>
                                    <td>
                                        ${p.getTotalPay()}
                                    </td>
                                    <td>
                                        ${p.getBehalfBrand()}                                        
                                    </td>
                                    <td>
                                        ${p.affiliateType.getName()}
                                    </td>                                    
                                    <td>
                                        ${p.paymentStatus.getName()}
                                    </td>                                    
                                    <td>                                        
                                        <input type="checkbox" name="pay" value="${p.getId()}" class="form-control" <c:out value="${p.paymentStatus.getId() == 1 ? 'disabled': ''}"/>/> 
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
<c:choose>
    <c:when test="${fn:length(payments) > 0}">        
        <input type="button" value="pagar" class="btn btn-success btn-lg btn-block" onclick="doPay()"/>        
    </c:when>
</c:choose>
<br/>
<br/><br/><br/>
<script type="text/javascript">eval("${js}");</script>        
