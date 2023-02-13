<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Register Form</title>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
	<link rel="stylesheet" type="text/scss" href="css/styles.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	<link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Passion+One'>
	<link rel='stylesheet' type='text/css' href='https://fonts.googleapis.com/css?family=Oxygen'>

</head>
<body>
    <div class="container" style="margin-top: 20px;  display: flex; justify-content: center;">
        <div class="col-md-4">

            <form:form action="${action}" method="POST" modelAttribute="student">
                <fieldset class="scheduler-border">
                    <legend class="scheduler-border">
                    </legend>
                    <c:if test="${type.equals('Update Student')}">
                        <div class="form-group">
                            <label class="control-label">ID</label>
                            <form:input path="id" type="text" class="form-control" id="id" placeholder="ID"
                                disabled="true" />
                            <form:hidden path="id" />
                            <form:hidden path="studentDetail.id" />
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label class="control-label">Name (*)</label>
                        <form:input path="name" type="text" class="form-control" placeholder="Name" />
                        <small style="color: red;">
                            <form:errors path="name" class="text-error" />
                        </small>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Address (*)</label>
                        <form:input path="studentDetail.address" type="text" class="form-control" placeholder="Address" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Gender (*)</label>
                        <form:select path="studentDetail.gender" class="form-control">
                            <form:option value="Male" label="Male" />
                            <form:option value="Female" label="Female" />
                        </form:select>
                    </div>
                        <small style="color: red;">
                            <form:errors path="studentDetail.gender" class="text-error" />
                        </small>
                    <div class="form-group">
                        <label class="control-label">Class (*)</label>
                        <form:select path="classEntity.id" class="form-control">
                            <form:option value="0" label="--- Select ---" />
                            <form:options items="${classList}" />
                        </form:select>
                        <small style="color: red;">
                            <c:out value="${message}" />
                        </small>
                    </div>
                    <br>
                    <button class="btn btn-primary btn-sm" type="submit"
                        style="width: 100%; height: 38px; font-size: 110%;">Save</button>
                </fieldset>
            </form:form>
        </div>
    </div>
</body>

</html>