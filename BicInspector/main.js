function setData(data) {

    var bicView = document.getElementById("bicView");
    var bankView = document.getElementById("bankView");
    var plzView = document.getElementById("plzView");
    var ortView = document.getElementById("ortView");
}


function loadKontoDetails() {
    console.log("Test");
    var blz = document.getElementById("blz").value;
    if(!blz){
        alert("Gib eine BLZ ein.");
        return;
    }

    var request = new XMLHttpRequest();

    request.open("GET", "https://banking.stupig.org/v1/bank/?blz=" + blz, true);
    request.setRequestHeader("Content-type", "application/json");
    request.addEventListener('load', function(event) {
        if (request.status >= 200 && request.status < 300) {
            console.log(request.responseText);
        } else {
            alert("Dat war wohl nichts!\n\n" + request.statusText + request.responseText);
        }
    });
    request.send();

}