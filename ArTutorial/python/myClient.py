import socket

clientSocket = socket.socket()
host = socket.gethostname()
port = 12345 
clientSocket.connect((host, port))
clientSocket.recv(1024)
clientSocket.close()