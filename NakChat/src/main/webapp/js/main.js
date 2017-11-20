window.username = "";
window.messages = [];
window.users = [];

function toggleLogin() {
    if(username !== ""){
        document.getElementById("login").style.display = "none";
        document.getElementById("chatroom").style.display = "block";
        window.chatserver.getMessages();
    } else{
        document.getElementById("login").style.display = "block";
        document.getElementById("chatroom").style.display = "none";
    }
}

function login() {
    var username = document.getElementById("username").value;
    if(username === ""){
        console.log("Please specified username");
        return;
    }
    window.username = username;
    toggleLogin();
}

function sendMessage() {
    var elm = document.getElementById("messageInput")
    var message = elm.value;
    var username = window.username;

    if(message === "" || username === ""){
        console.log("Message or User not defined");
        return;
    }
    window.chatserver.sendMessage(username, message);
    elm.value = "";
}

function setMessages() {
    var client = new XMLHttpRequest();
    client.open('GET', './html/message.html');
    client.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200){
            var contentMessages = "";

            var html = client.responseText;

            var messages = window.messages;
            for(var i = 0; i < messages.length; i++){
                var styleUser = "";
                var styleDiv = "";
                if(messages[i].user.username === window.username){
                    styleUser = "display: none";
                    styleDiv = "text-align: right";
                }
                contentMessages += window.utils.createHtml(html, {
                        username: messages[i].user.username,
                        message: messages[i].message,
                        styleUser: styleUser,
                        styleMessage: "",
                        styleDiv: styleDiv
                    });
            }

            document.getElementById("chat").innerHTML = contentMessages;
        }
    };
    client.send();
}

toggleLogin();
setInterval(window.chatserver.getMessages, 1000);

document.getElementById("username")
    .addEventListener("keyup", function(event) {
        event.preventDefault();
        if (event.keyCode === 13) {
            document.getElementById("loginBtn").click();
        }
    });


document.getElementById("messageInput")
    .addEventListener("keyup", function(event) {
        event.preventDefault();
        if (event.keyCode === 13) {
            document.getElementById("sendBtn").click();
        }
    });