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
        <title>Utilisateurs</title>
    </head>
    <body>

		<%@ include file="banner.jsp" %>

		<%@ include file="menu.jsp" %>
		
		<%@ include file="Forms/userForm.jsp" %>

        <div class="divContent">
            <div class="divWrapper">
               
                <div class="divUserItem">
                    <span>NF</span>
                    <div>
                    	<h2>Ndambé Fall</h2>
                    	<p>Fullstack developer</p>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>