<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="divOverlay">

    <form action="" method="post">
        <div class="divHeadForm">
            <h2>Ajouter un utilisateur</h2>
            <button class="closeForm">Fermer</button>
        </div>

        <div class="divFormWrapper">
            <div class="divFormGroup">
                <label for="">Prénom</label>
                <input type="text" placeholder="alpha amadou">
            </div>
        
            <div class="divFormGroup">
                <label for="">Nom de famille</label>
                <input type="text" placeholder="Diallo">
            </div>
        </div>

        <div class="divFormGroup">
            <label for="">Adresse electronique</label>
            <input type="text" placeholder="alpha@contact.sn">
        </div>

        <div class="divFormGroup">
            <label for="">Profession</label>
            <input type="text" placeholder="fullstack developer">
        </div>

        <div class="divFormWrapper">
            <div class="divFormGroup">
                <label for="">Mot de passe</label>
                <input type="password" value="passer123">
            </div>
        
            <div class="divFormGroup">
                <label for="">Confirmer le mot de passe</label>
                <input type="password" value="passer123">
            </div>
        </div>

        <button type="submit">Enregistrer</button>

    </form>
</div>