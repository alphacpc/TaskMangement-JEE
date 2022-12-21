<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="divOverlay">

    <form action="etiquettes" method="post">
        <div class="divHeadForm">
            <h2>Ajouter une étiquette</h2>
            <button class="closeForm">Fermer</button>
        </div>

        <div class="divFormGroup">
            <label for="">Titre</label>
            <input name="title" type="text" placeholder="Base de donnée">
        </div>

        <div class="divFormGroup">
            <label for="">Code couleur</label>
            <input name="code" type="text" placeholder="F05AAA">
        </div>

        <button type="submit">Enregistrer</button>

    </form>
</div>