INSERT INTO usuario (rut, nombre, email, contrasena, telefono, rol, fecha_nac, fecha_creacion) VALUES
('11.111.111-1', 'Test User', 'test@example.com', 'password123', '+56911111111', 'usuario', '1990-01-01', CURRENT_TIMESTAMP),
('22.222.222-2', 'Admin User', 'admin@example.com', 'admin123', '+56922222222', 'admin', '1985-06-15', CURRENT_TIMESTAMP);

INSERT INTO documento (usuario_id, tipo, nombre_archivo, fecha_firmado, direccion_archivo) VALUES
(1, 'PDF', 'documento_prueba.pdf', CURRENT_TIMESTAMP, '/docs/documento_prueba.pdf');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio) VALUES
(1, 'Servicio Test', 'Suscripción', 'Descripción de servicio de prueba', 49)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(1, 'detalle1'),
(1, 'detalle2');
