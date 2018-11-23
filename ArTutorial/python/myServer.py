import socket

serverSocket = socket.socket()
host = socket.gethostname()
port = 12345
serverSocket.bind((host, port))
serverSocket.listen(5)
while True:
	serverSocket.accept()
	serverSocket.send()
	serverSocket.close()