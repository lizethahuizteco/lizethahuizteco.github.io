import socket
 
# Creamos un socket UDP
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
 
# Asociamos el socket al puerto
host = socket.gethostname()
port = 12345
server_socket.bind((host, port))
 
print("Servidor UDP iniciado en el puerto", port)
 
while True:
    # Esperamos a recibir datos del cliente
    data, addr = server_socket.recvfrom(1024)
    print("Mensaje recibido desde", addr, ":", data.decode('utf-8'))
 
    # Enviamos una respuesta al cliente
    response = "Mensaje recibido correctamente"
    server_socket.sendto(response.encode('utf-8'), addr)