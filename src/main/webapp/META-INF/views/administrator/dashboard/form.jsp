<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.label.totalAnnouncements" path="totalAnnouncements"/>
	<acme:form-textbox code="administrator.dashboard.form.label.totalCompanyRecords" path="totalCompanyRecords"/>
	<acme:form-textbox code="administrator.dashboard.form.label.totalInvestorRecords" path="totalInvestorRecords"/>

	<acme:form-money code="administrator.dashboard.form.label.minRewardRequest" path="minRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxRewardRequest" path="maxRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardRequest" path="averageRewardRequest"/>
	<acme:form-textbox code="administrator.dashboard.form.labelsdRewardRequest" path="sdRewardRequest"/>
	
	
	<acme:form-textbox code="administrator.dashboard.form.label.minRewardOffer" path="minRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.label.maxRewardOffer" path="maxRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardOffer" path="averageRewardOffer"/>
	<acme:form-textbox code="administrator.dashboard.form.labelsdMinRewardOffer" path="sdMinRewardOffer"/>	
	<acme:form-textbox code="administrator.dashboard.form.labelsdMaxRewardOffer" path="sdMaxRewardOffer"/>
	
</acme:form>

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels : [{
					data :[
						<jstl:forEach
							var="prueba"
							items="${companySectors}">
						<jstl:out value="${prueba}"/>
						</jstl:forEach>
					]
				}],
				datasets: [
					{
						data : [1.9, 2.0, 3.4]
					}
				]
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data
		});
		
	});
</script>
