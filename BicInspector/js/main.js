window.main = function () {
    "use strict";

    var _successCallback = function (data) {
        var bicView = document.getElementById("bicView");
        var bankView = document.getElementById("bankView");
        var plzView = document.getElementById("plzView");
        bicView.innerHTML = data.bank_code.bic;
        bankView.innerHTML = data.bank_code.description;
        plzView.innerHTML = data.bank_code.postal_code + " " + data.bank_code.city;
    };

    var _failureCallback = function (bankCode) {
        (function() {
            'use strict';
            var snackbarContainer = document.querySelector('#demo-toast-example');
            var data = {message: 'Cannot find data for bank code ' + bankCode};
            snackbarContainer.MaterialSnackbar.showSnackbar(data);
        }());
    };

    var _loadKontoDetails = function () {
        console.log("Test");
        var bankcode = document.getElementById("blz").value;
        if(!bankcode){
            alert("Gib eine BLZ ein.");
            return;
        }
        window.bicInspector.resolveBicDetails(bankcode, _successCallback, _failureCallback);
    };

    return{
        loadKontoDetails: _loadKontoDetails
    }
}();
