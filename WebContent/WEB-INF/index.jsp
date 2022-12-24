
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
               <c:forEach var="user" items="${result}">
                <div class="divUserItem">
                    <span>
                    	<c:out value="${user.fname.toUpperCase().charAt(0)}"/><c:out value="${user.lname.toUpperCase().charAt(0)}"/>
                    </span>
                    <div>
                    	<h2>${user.fname} ${user.lname.toUpperCase()}</h2>
                    	<p>${user.job}</p>
                    </div>
                </div>
				</c:forEach>
            </div>
            
        </div>

    </body>
</html>