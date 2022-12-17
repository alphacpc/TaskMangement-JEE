<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
    <head>
    	<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/taches.css">
        <title>Accueil</title>
    </head>
    <body>

        <div class="banner">
            <h1>Gestionnaire des taches</h1>
        </div>

        <div class="divPanelMenu">
            <div class="divNavigation">
                <a href="">Tous les utilisateurs</a>
                <a href="">Toutes les taches</a>
                <a href="">Mes taches</a>
                <a href="">Listes des Etiquettes</a>
            </div>

            <div class="btns">
                <button>Ajouter un utilisateur</button>
                <button>Ajouter une tache</button>
                <button>Ajouter une etiquette</button>
            </div>
        </div>


        <div class="divContent">
            <div class="divWrapper">
                <div class="divTaskItem">
                    <div class="divEtiquette">
                        <span>Website</span>
                        <span>Design</span>
                    </div>

                    <div class="divMinDetail">
                        <a href="#" class="title">Pages "About" and "Carrer"</a>
                        <p>Lorem ipsum tango nan minsu alphacpc ipsum suki sanu maxo ...</p>
                    </div>

                    <div class="divAffected">
                        <div class="divUsers">
                            <img src="./assets/images/logo.png" alt="logo">
                            <img src="./assets/images/logo.png" alt="logo">
                        </div>
                        <div class="divCreated">
                            <p>Date de création</p>
                            <span>12/12/2022</span>
                        </div>
                    </div> 
                </div>
                
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
    