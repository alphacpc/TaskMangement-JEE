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
            <textarea name=desc"" placeholder="Message..."></textarea>
        </div>

        <div class="divFormGroup">
            <label for="">Etiquettes</label>
            <input name="label" type="text" placeholder="Mise en relation">
        </div>

        <div class="divFormGroup">
            <label for="">Affecté à</label>
            <input type="text" placeholder="Mise en relation">
            <div class="users">
                <span>Ndambé fall</span>
                <span>Awa Diop</span>
            </div>
        </div>

        <button type="submit">Enregistrer</button>

    </form>
</div>