# MessengerApp-Server
Server of MessengerApp - Socket programming
This is the server side of the MessengerApp. In order to run the messenger app correctly you need to first run the
server and the run the client to connect to the server. The client side is available in 
https://github.com/szamani20/MessengerApp-Client
If you want to use this app to send message through the Internet to another
computer you need to modify the host name in the constructor of Sockets. Also you may need to a static ip address
to connect to another computer. ISPs provide you with static ip address if you ask them to.
Without static ip address this app can only be used on one computer or computers connected to each other.
If you want to send any data through the socket you can use different streams to do so. I just send String through the
socket in this app.
