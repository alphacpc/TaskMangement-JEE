<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="divPanelMenu">
	<div class="divNavigation">
	
    	<a href="/TasksManagement/utilisateurs">Tous les utilisateurs</a>
        <a href="/TasksManagement/taches">Toutes les taches</a>
        <a href="/TasksManagement/utilisateur/taches">Mes taches</a>
        <a href="/TasksManagement/etiquettes">Listes des Etiquettes</a>
     </div>

     <div class="btns">
        <button class="openForm" id="${ empty input ? 'hide' : 'show'}" >${input}</button>
        <!-- <button class="openForm">Ajouter une tache</button>
        <button class="openForm">Ajouter une etiquette</button> -->
     </div>
</div>