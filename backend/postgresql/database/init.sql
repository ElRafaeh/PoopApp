CREATE TABLE usuario (
  id SERIAL PRIMARY KEY, 
  email TEXT NOT NULL UNIQUE,
  nickname TEXT NOT NULL UNIQUE,
  name TEXT NOT NULL, 
  surname TEXT NOT NULL, 
  last_name TEXT, 
  password VARCHAR(255) NOT NULL
);

CREATE TABLE poop (
  id SERIAL PRIMARY KEY,
  usuario_id INT,
  scale_type INT NOT NULL,
  satisfaction INT NOT NULL,
  description TEXT,
  image BYTEA,
  date DATE NOT NULL,
  latitude FLOAT,
  longitude FLOAT, 
  CONSTRAINT fk_usuario_poop FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);