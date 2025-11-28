INSERT INTO usuario (rut, nombre, email, contrasena, telefono, fecha_nac) VALUES
('11.111.111-1', 'Test User', 'test@example.com', 'password123', '+56911111111', '1990-01-01'),
('22.222.222-2', 'Admin User', 'admin@example.com', 'admin123', '+56922222222', '1985-06-15' );

INSERT INTO documento (usuario_id, tipo, nombre_archivo, fecha_firmado, direccion_archivo) VALUES
(1, 'PDF', 'documento_prueba.pdf', CURRENT_TIMESTAMP, '/docs/documento_prueba.pdf');

-- Servicios de ECERT cargados de forma inicial
INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(1, 'Firma Electrónica Simple', 'Simple', 'Certificado Digital. Permite realizar Facturación en el servicio de impuestos internos. Centralización Automática del certificado en el sistema de facturación SII. Compra en menos de 5 minutos. Renovación Express. Firma documentos tributarios electrónicos como facturas y notas de crédito. Lleva 1 año gratis en tu certificado digital. 3×2 años.', 15390, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(1, 'Certificado Digital'),
(1, 'Permite realizar Facturación en el servicio de impuestos internos'),
(1, 'Centralización Automática del certificado en el sistema de facturación SII'),
(1, 'Compra en menos de 5 minutos. Renovación Express'),
(1, 'Firma documentos tributarios electrónicos como facturas y notas de crédito'),
(1, 'Incluye 1 año gratis en tu certificado digital (3×2 años)');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(2, 'Firma Electrónica Avanzada - Online', 'Avanzada', 'Permite firmar documentos ilimitados desde cualquier lugar sin dispositivo e-token. Compra 100% online con ClaveÚnica y Cédula Vigente. Con Adquisición Instantánea e implementación fácil. Valida para todo tipo de documentos legales y comerciales: contratos, actas, recetas médicas, documentos crediticios y más. La Firma Electrónica Online no permite crear "Tu Empresa en un Día".', 21990, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(2, 'Firmar documentos ilimitados desde cualquier lugar'),
(2, 'Compra 100% online con ClaveÚnica y Cédula Vigente'),
(2, 'Adquisición Instantánea e implementación fácil'),
(2, 'Válida para contratos, actas, recetas médicas, documentos crediticios y más');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(3, 'Firma Electrónica Avanzada - Un solo uso', 'Avanzada', 'Con la validación de tu ClaveÚnica, adquiere tu Firma Electrónica para un único uso. Firma documentos privados con Total Validez Legal, pero sin necesidad de un dispositivo e-token. Esta firma no permite crear "Tu Empresa en un Día". Firma de Contratos laborales, acuerdos comerciales, compraventa de propiedades y otros documentos legales. Garantiza validez legal, autenticación, integridad y no repudio.', 3445, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(3, 'Adquisición con validación ClaveÚnica'),
(3, 'Firma para un solo uso con validez legal'),
(3, 'No requiere dispositivo e-token');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(4, 'Firma Electrónica Avanzada - e-token', 'Avanzada', 'Firma Portable que queda almacenada en un dispositivo e-token. La Firma Electrónica e-token permite firmar documentos legales con valor probatorio. Agiliza la Contratación de Servicios y Firmas de Documentos. Optimiza procesos empresariales con plena validez legal. Requiere Enrolamiento presencial en sucursales o remoto. Si ya tiene E-token según normativa vigente modelos Safenet 5110 o 5110+, no requiere comprar otro.', 21990, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(4, 'Firma portable almacenada en e-token'),
(4, 'Validez probatoria para documentos legales'),
(4, 'Requiere enrolamiento presencial o remoto'),
(4, 'Compatibilidad con modelos Safenet 5110/5110+');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(5, 'Firma Electrónica Avanzada - Notario', 'Avanzada', 'Firma Electrónica para Notarios, Archiveros, y Conservadores. Es necesario presentar el Certificado de la Corte de Apelaciones. Firma portable, queda almacenada en dispositivo e-token. Documentos Avalados por la Ley con los más altos estándares de seguridad y confidencialidad de la información.', 42990, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(5, 'Dirigido a Notarios, Archiveros y Conservadores'),
(5, 'Requiere Certificado de la Corte de Apelaciones'),
(5, 'Almacenada en dispositivo e-token'),
(5, 'Alta seguridad y confidencialidad');

INSERT INTO servicio (id, nombre, tipo, descripcion, precio, fecha_creacion) VALUES
(6, 'Firma Electrónica Online - Empresa en un Día', 'Online', 'Permite a personas naturales realizar el proceso de "Tu Empresa en un Día". Compra 100% online con ClaveÚnica y Cédula de Identidad Vigente. Es el primer paso para Formalizar tu Empresa. Te permite firmar en Empresa en un Día. Solución Rápida y Eficiente para iniciar tu propio negocio. Una vez constituida tu empresa el SII te asignará un RUT.', 798, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre);

INSERT INTO servicio_detalles (servicio_id, detalle) VALUES
(6, 'Permite realizar "Tu Empresa en un Día"'),
(6, 'Compra 100% online con ClaveÚnica y Cédula Vigente'),
(6, 'Primer paso para formalizar tu empresa'),
(6, 'Solución rápida y eficiente para iniciar negocio');
