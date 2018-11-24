import socket

serverSocket = socket.socket()
host = socket.gethostname()
port = 12345
serverSocket.bind((host, port))
serverSocket.listen(5)
while True:
	print("Waiting for connection from client")
	connection, addr = serverSocket.accept()
	print("Got Connection from ", addr)
	connection.sendall(b'Thanks for connecting.')
	connection.close()