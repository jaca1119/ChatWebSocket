let stompClient = null;

stompClient = Stomp.client("ws://localhost:8080/chat");
    console.log(stompClient);
    stompClient.connect({}, function(frame) {
        console.log("connected: " + frame);
        stompClient.subscribe("/broker/messages", function (message)
        {
            console.log(message.body);
        });
    });

function sendMessage()
{
    let name = document.getElementById("userName").value;
    let message = document.getElementById("message").value;

    let json = 
    {
        userName: name,
        messageContent: message
    };
    // socket.send(JSON.stringify(json));
    stompClient.send("/app/chat", {}, JSON.stringify(json));
}

function showMessage(message)
{
    let response = document.getElementById("response");
    let paragraph = document.createElement("p");
    let textNode = document.createTextNode(message);

    paragraph.appendChild(textNode);

    response.appendChild(paragraph);
}

function processMessage(rawMessage)
{
    let json = JSON.parse(rawMessage.body);
    let outputMessage = json.userName + ': ' + json.messageContent + '( ' + json.outputTime + ' )';

    return outputMessage;
}

// let button = document.getElementById("send");
// button.addEventListener(onclick, sendMessage);


