import socket
 
# Creamos un socket UDP
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
 
# Definimos el servidor y el puerto al que nos conectamos
host = socket.gethostname()
port = 12345
 
# Enviamos datos al servidor
message = "Hola, servidor UDP!"
client_socket.sendto(message.encode('utf-8'), (host, port))
 
# Esperamos recibir la respuesta del servidor
response, addr = client_socket.recvfrom(1024)
print("Respuesta del servidor:", response.decode('utf-8'))
 
# Cerramos el socket
client_socket.close()