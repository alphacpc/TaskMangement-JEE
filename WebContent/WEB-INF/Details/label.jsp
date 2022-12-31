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
        
        <title>Etiquette ${label.title}</title>
    </head>
    <body>

		<%@ include file="../banner.jsp" %>

		<%@ include file="../menu.jsp" %>
		

        <div class="divContent">

            <div class="divWrapper">
                <div class="divDelete">
                    <h2>Detail : <c:out value="${label.title.toUpperCase()}"/></h2>
                </div>
            
                <form method="post" class="divDetail">
                    <div class="divDetailItem">
                        <span>Nom de l'etiquette</span>
                        <input type="text" name="title" value="${label.title}">
                    </div>

                    <div class="divDetailItem">
                        <span>Code couleur</span>
                        <input type="text" name="code" value="${label.code}">
                    </div>

                    <div class="btnSave">
                        <button  type="submit">Modifier</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
    