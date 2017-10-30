window.bicInspector = function () {
    "use strict";

    var _resolveBicDetails = function (bankCode) {

        var url = "https://fintechtoolbox.com/bankcodes/" + bankCode + ".json";

        var request = new XMLHttpRequest();
        request.open("GET",url, true);
        request.onreadystatechange = function(){
            if(this.readyState === 4 && this.status === 200){
                window.main.setData(JSON.parse(request.responseText));
            }
        };
        request.send(null);
    };

    return {
        resolveBicDetails: _resolveBicDetails
    };
}();