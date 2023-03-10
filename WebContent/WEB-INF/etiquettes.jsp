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
        <link rel="stylesheet" href="./assets/css/etiquettes.css">
        
        <title>Taches</title>
    </head>
    <body>

		<%@ include file="banner.jsp" %>

		<%@ include file="menu.jsp" %>
		
		<%@ include file="Forms/labelForm.jsp" %>

        <div class="divContent">
            <div class="divEtiquette">
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Nom</th>
                            <th>Code couleur</th>
                            <th>Aperçu</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="label" items="${labels}">
                        <tr>
                            <td><a href="delete/label?id=${label.id}" class="btn-icon">-</a></td>
                            <td><c:out value="${label.title}"/></td>
                            <td><c:out value="${label.code}"/></td>
                            <td><span class="bg" content="${label.code}"></span></td>
                            <td><a href="etiquette?id=${label.id}" class="btn-edit">Modifier</a></td>
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>
            </div>

        </div>
		<script src="./assets/js/app.js"></script>
		<script src="./assets/js/label.js"></script>
    </body>
</html>
    