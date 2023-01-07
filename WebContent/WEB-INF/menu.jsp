<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="divPanelMenu">
	<div class="divNavigation">
	
	
		<c:if test='${profil.equals("admin")}'>
			<a href="/TasksManagement/utilisateurs">Tous les utilisateurs</a>
		</c:if>
		
        <a href="/TasksManagement/taches">Toutes les taches</a>
        
        <c:if test='${profil.equals("visiteur")}'>
        	<a href="/TasksManagement/taches/utilisateurs">Mes taches</a>
        </c:if>
        
        <c:if test="${profil.equals('admin')}">
			<a href="/TasksManagement/etiquettes">Listes des Etiquettes</a>
		</c:if>
        
     </div>

     <div class="btns">
     	<c:if test='${profil.equals("admin")}'>
        	<button class="openForm" id="${ empty input ? 'hide' : 'show'}" >${input}</button>
        </c:if>
        <a id="logout" href="deconnexion" >Déconnexion</a>
     </div>
</div>