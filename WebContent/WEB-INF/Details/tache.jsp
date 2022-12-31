<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html lang="fr">
    <head>
    	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/taches.css">
        
        <title>Tache ${task.title}</title>
    </head>
    <body>

		<%@ include file="../banner.jsp" %>

		<%@ include file="../menu.jsp" %>
		

        <div class="divContent">

            <div class="divWrapper">

                <div class="divDelete">
                    <h2>Detail : <c:out value="${task.title.toUpperCase()}"/></h2>
                    <a href="delete/task?taskid=${task.taskid}">Supprimer</a>
                </div>
            
                <form method="post" class="divDetail">
                    <div class="divDetailItem">
                        <span>Titre</span>
                        <input type="text" name="title" value="${task.title}">
                    </div>

                    <div class="divDetailItem">
                        <span>Description</span>
                        <textarea name="desc">${task.desc}</textarea>
                    </div>
                    
                    <div class="divDetailItem">
                        <span>Etiquette</span>
                        <select name="labelid">
                            <c:forEach var="label" items="${labels}">
                                <option value="${label.id}">${label.title}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="divDetailItem">
                        <span>Utilisateur</span>
                        <select name="userid">
                            <c:forEach var="user" items="${users}">
                                <option value="${user.userid}">${user.email}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="btnSave">
                        <button type="submit">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
    