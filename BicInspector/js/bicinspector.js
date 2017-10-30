window.bicInspector = function () {
    "use strict";

    var _resolveBicDetails = function (bankCode, successCallback, failureCallback) {

        var url = "https://fintechtoolbox.com/bankcodes/" + bankCode + ".json";

        var request = new XMLHttpRequest();
        request.open("GET",url, true);
        request.onreadystatechange = function(){
            if(this.readyState === 4 && this.status === 200){
                var data = JSON.parse(request.responseText);
                if(data.msg === "Bankcode unknown"){
                    failureCallback(bankCode);
                } else{
                    successCallback(data);
                }

            }
        };
        request.send(null);
    };

    return {
        resolveBicDetails: _resolveBicDetails
    };
}();