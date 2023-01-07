<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="divFormLogin">

    <form action="connexion" method="post">
        <div class="divHeadForm">
            <h2>Formulaire de connexion</h2>
        </div>

        <div class="divFormGroup">
            <label for="">Adresse email</label>
            <input name="email" autocomplete="off" type="text">
        </div>

        <div class="divFormGroup">
            <label for="">Mot de passe</label>
            <input name="pwd" type="password">
        </div>

        <button type="submit">Enregistrer</button>

    </form>
</div>