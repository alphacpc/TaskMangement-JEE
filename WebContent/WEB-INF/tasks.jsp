<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="fr">
    <head>
    	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/taches.css">
        <link rel="stylesheet" href="./assets/css/form.css">
        <script src="./assets/js/app.js" defer></script>
        <title>Taches</title>
    </head>
    <body>

		<%@ include file="banner.jsp" %>

		<%@ include file="menu.jsp" %>

		<%@ include file="Forms/taskForm.jsp" %>

        <div class="divContent">
            <div class="divWrapper">
            	<c:forEach var="task" items="${tasks}">
                <div class="divTaskItem">
                    <div class="divEtiquette">
                        <span style="background:${task.code}"><c:out value="${task.label}"/></span>
                    </div>

                    <div class="divMinDetail">
                        <a href="tache?taskid=${task.taskid}" class="title"><c:out value="${task.title}"/></a>
                        <p><c:out value="${task.desc}"/></p>
                    </div>

                    <div class="divAffected">
                        <div class="divUsers">
                            <span>
                            	<c:out value="${task.fname.toUpperCase().charAt(0)}"/><c:out value="${task.lname.toUpperCase().charAt(0)}"/>
                            </span>
                        </div>
                        <div class="divCreated">
                            <p>Date de création</p>
                            <span><c:out value="${task.createdAt.split(' ')[0].replace('-','/')}"/></span>
                        </div>
                    </div> 
                </div>
                </c:forEach>

            </div>
        </div>

    </body>
</html>
    