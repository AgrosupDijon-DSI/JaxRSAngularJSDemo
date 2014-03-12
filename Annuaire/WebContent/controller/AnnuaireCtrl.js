var annuaireApp = angular.module('annuaireApp', []);

// IP Aclor 172.16.15.182
annuaireApp.controller('AnnuaireCtrl', function($scope, $http) {

    var ip = "172.16.15.182";
    var urlAll = "http://" + ip + ":8080/Annuaire/annuaire/all";
    var urlContact = "http://" + ip + ":8080/Annuaire/annuaire/id/";

    // Pour requête Cross Domaine
    $http.defaults.useXDomain = true;

    $scope.formData = {};


    $scope.chargerToutAnnuaire = function() {

        $scope.filtreNom = "";  // reset de la recherche

        $http.get(urlAll)
        .success(function(data) {
            $scope.annuaire = data;

        })
        .error(function(data, status) {
            console.log(data, status);
        });
    }

    /**
     * Lors d'un clic sur un contact de la liste de l'annuaire
     * @param int index
     * @param json contact
     */
    $scope.setFormContact = function(index, contact) {
        $scope.formData.id = index;
        $scope.formData.nom = contact.nom;
        $scope.formData.prenom = contact.prenom;
        $scope.formData.age = contact.age;
    }

    /**
     * Lors du clic sur le bouton validé
     * @param json contact
     */
    $scope.modifierContact = function(contact) {
        
        var urlForPost = urlContact + ($scope.formData.id >= 0  ? $scope.formData.id : "");
        var theMethode = $scope.formData.id >= 0 ? 'POST' : 'PUT';
        
        $http({
            method: theMethode,
            url: urlForPost,
            data: $scope.formData,
            headers: {'Content-Type': 'application/json'}
        })
        .success(function(data) {
            if(data == 1) {
                // Si c'est un ajout on incrémente l'ID
                if(theMethode == 'PUT') {
                    $scope.formData.id = $scope.annuaire.length;
                }

                // angular.copy permet de copier des données pour éviter de garder un lien avec le scope
                $scope.annuaire[$scope.formData.id] = angular.copy($scope.formData);
            }
        });
    }
    
    $scope.supprimerContact = function(indexContact){
        
        var urlForPost = urlContact + indexContact;
       
        $http({
            method: 'DELETE',
            url: urlForPost,
            headers: {'Content-Type': 'application/json'}
        })
        .success(function(data) {
            if(data == 1) {
                // Suppression d'un élément du tableau
                $scope.annuaire.splice(data, 1);
            }
        });
    }

    // Premier chargement de la liste
    $scope.chargerToutAnnuaire();
});