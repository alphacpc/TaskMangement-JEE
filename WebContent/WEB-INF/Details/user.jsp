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

            <div class="divWrapper">
                <div class="divDelete">
                    <h2>Detail : <c:out value="${user.fname.toUpperCase()}"/> <c:out value="${user.lname.toUpperCase()}"/></h2>
                    <a href="delete/utilisateur?userid=${user.userid}">Supprimer</a>
                </div>
            
                <form method="post" class="divDetail">
                    <div class="divDetailItem">
                        <span>Nom de famille</span>
                        <input type="text" name="lname" value="${user.lname}">
                    </div>

                    <div class="divDetailItem">
                        <span>Prénom</span>
                        <input type="text" name="fname" value="${user.fname}">
                    </div>

                    <div class="divDetailItem">
                        <span>Adresse email</span>
                        <input type="text" name="email" value="${user.email}">
                    </div>

                    <div class="divDetailItem">
                        <span>Profession</span>
                        <input type="text" name="profession" value="${user.job}">
                    </div>

                    <div class="btnSave">
                        <button  type="submit">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
		<script src="./assets/js/detail.js"></script>
    </body>
</html>
    