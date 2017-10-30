window.main = function () {
    "use strict";

    var _setData = function (data) {
        var bicView = document.getElementById("bicView");
        var bankView = document.getElementById("bankView");
        var plzView = document.getElementById("plzView");
        var ortView = document.getElementById("ortView");
        bicView.innerHTML = data.bank_code.bic;
        bankView.innerHTML = data.bank_code.description;
        plzView.innerHTML = data.bank_code.postal_code;
        ortView.innerHTML = data.bank_code.city;
    };

    var _loadKontoDetails = function () {
        console.log("Test");
        var bankcode = document.getElementById("blz").value;
        if(!bankcode){
            alert("Gib eine BLZ ein.");
            return;
        }
        window.bicInspector.resolveBicDetails(bankcode);
    };

    return{
        setData: _setData,
        loadKontoDetails: _loadKontoDetails
    }
}();
