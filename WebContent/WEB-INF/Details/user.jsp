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
        <link rel="stylesheet" href="./assets/css/form.css">
        <link rel="stylesheet" href="./assets/css/etiquettes.css">
        
        <title>Utilisateur</title>
    </head>
    <body>

		<%@ include file="../banner.jsp" %>

		<%@ include file="../menu.jsp" %>
		

        <div class="divContent">
        
            <div class="divDetail">
                <div class="divDetailItem">
                    <span>Nom de famille</span>
                    <input type="text" value="${user.lname}">
                </div>

                <div class="divDetailItem">
                    <span>Prénom</span>
                    <input type="text" value="${user.fname}">
                </div>

                <div class="divDetailItem">
                    <span>Adresse email</span>
                    <input type="text" value="${user.email}">
                </div>

                <div class="divDetailItem">
                    <span>Profession</span>
                    <input type="text" value="${user.job}">
                </div>

                <div class="btnSave">
                    <button>Modifier</button>
                </div>
            </div>
        </div>
		<script src="./assets/js/app.js"></script>
    </body>
</html>
    