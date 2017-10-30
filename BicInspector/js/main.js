window.main = function () {
    "use strict";

    var _setData = function (data) {
        var bicView = document.getElementById("bicView");
        var bankView = document.getElementById("bankView");
        var plzView = document.getElementById("plzView");
        bicView.innerHTML = data.bank_code.bic;
        bankView.innerHTML = data.bank_code.description;
        plzView.innerHTML = data.bank_code.postal_code + " " + data.bank_code.city;
    };

    var _loadKontoDetails = function () {
        console.log("Test");
        var bankcode = document.getElementById("blz").value;
        if(!bankcode){
            alert("Gib eine BLZ ein.");
            return;
        }
        window.bicInspector.resolveBicDetails(bankcode, _setData);
    };

    return{
        loadKontoDetails: _loadKontoDetails
    }
}();
