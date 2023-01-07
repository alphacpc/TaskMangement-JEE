<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="divOverlay">

    <form action="taches" method="post">
        <div class="divHeadForm">
            <h2>Ajouter une tache</h2>
            <button class="closeForm">Fermer</button>
        </div>

        <div class="divFormGroup">
            <label for="">Titre</label>
            <input name="title" type="text" placeholder="Mise en relation">
        </div>

        <div class="divFormGroup">
            <label for="">Description</label>
            <textarea name="desc" placeholder="Message..."></textarea>
        </div>

        <div class="divFormGroup">
            <label for="">Etiquette</label>
            <select name="labelid">
                <option >Choisir une étiquette</option>
                <c:forEach var="label" items="${labels}">
                    <option value="${label.id}"><c:out value="${label.title}"/></option>
                </c:forEach>
            </select>
        </div>

        <div class="divFormGroup">
            <label for="">Affecté à</label>
            <select name="userid">
                <option >Choisir un utilisateur</option>
                <c:forEach var="user" items="${users}">
                    <option value="${user.userid}"><c:out value="${user.email}"/> (<c:out value="${user.job}"/>)</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit">Enregistrer</button>

    </form>
</div>