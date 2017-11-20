window.chatserver = function () {

    var _getMessages = function () {
        var url = "./nakchat/message";

        var request = new XMLHttpRequest();
        request.open("GET",url, true);
        request.onreadystatechange = function(){
            if(this.readyState === 4 && this.status === 200){
                window.messages = JSON.parse(request.responseText);
                console.log(window.messages);
                setMessages();
            }
        };
        request.send(null);
    };

    var _getUsers = function () {
        var url = "./nakchat/user";

        var request = new XMLHttpRequest();
        request.open("GET",url, true);
        request.onreadystatechange = function(){
            if(this.readyState === 4 && this.status === 200){
                window.users = JSON.parse(request.responseText);
            }
        };
        request.send(null);
    };

    var _sendMessage = function (username, message) {
        var messageObj = {
            message: message,
            user: {
                username: username
            }
        };

        var url = "./nakchat/message";

        var request = new XMLHttpRequest();
        request.open("POST",url, true);
        request.setRequestHeader("Content-type", "application/json");
        request.onreadystatechange = function(){
            console.log("Hallo");
            console.log(this.status);
            if(this.readyState === 4 && this.status === 204){
                console.log("Send successful message");
                window.chatserver.getMessages();
            }
        };
        request.send(JSON.stringify(messageObj));
    };

    return {
        getMessages: _getMessages,
        getUsers: _getUsers,
        sendMessage: _sendMessage
    }

}();