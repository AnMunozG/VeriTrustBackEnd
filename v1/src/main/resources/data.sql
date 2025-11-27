-- Insert test users
-- Insert test users (columns match the `Usuario` model)
INSERT INTO usuario (id, rut, nombre, email, contrasena, telefono, fecha_nac, fecha_creacion) VALUES
(1, '11.111.111-1', 'Test User', 'test@example.com', 'password123', '+56911111111', '1990-01-01', CURRENT_TIMESTAMP),
(2, '22.222.222-2', 'Admin User', 'admin@example.com', 'admin123', '+56922222222', '1985-06-15', CURRENT_TIMESTAMP);

-- Insert test documents (columns match the `Documento` model)
INSERT INTO documento (id, usuario_id, tipo, nombre_archivo, fecha_firmado, direccion_archivo) VALUES
(1, 1, 'PDF', 'documento_prueba.pdf', CURRENT_TIMESTAMP, '/docs/documento_prueba.pdf');

-- Insert test services (columns match the `Servicio` model)
INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(1, 'Servicio Test', 'Suscripción', 'Descripción de servicio de prueba', 49, CURRENT_TIMESTAMP);