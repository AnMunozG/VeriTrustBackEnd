INSERT INTO usuario (rut, nombre, email, contrasena, telefono, fecha_nac, fecha_creacion) VALUES
('11.111.111-1', 'Test User', 'test@example.com', 'password123', '+56911111111', '1990-01-01', CURRENT_TIMESTAMP),
('22.222.222-2', 'Admin User', 'admin@example.com', 'admin123', '+56922222222', '1985-06-15', CURRENT_TIMESTAMP);

INSERT INTO documento (usuario_id, tipo, nombre_archivo, fecha_firmado, direccion_archivo) VALUES
(1, 'PDF', 'documento_prueba.pdf', CURRENT_TIMESTAMP, '/docs/documento_prueba.pdf');

INSERT INTO servicio (nombre, tipo, descripcion, precio, fecha_creacion) VALUES
('Servicio Test', 'Suscripción', 'Descripción de servicio de prueba', 49, CURRENT_TIMESTAMP);
