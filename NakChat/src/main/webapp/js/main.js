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
    var message = document.getElementById("messageInput").value;
    var username = window.username;

    if(message === "" || username === ""){
        console.log("Message or User not defined");
        return;
    }
    window.chatserver.sendMessage(username, message);

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
                contentMessages += window.utils.createHtml(html, {
                        username: messages[i].user.username,
                        message: messages[i].message
                    });
            }

            document.getElementById("chat").innerHTML = contentMessages;
        }
    };
    client.send();
}

toggleLogin();
setInterval(window.chatserver.getMessages, 5000);