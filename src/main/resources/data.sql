INSERT INTO category  (id, image_url, name) values (1, '/zupy.jpeg', 'Zupy');
INSERT INTO category  (id, image_url, name) values (2, '/przystawki.jpeg', 'Przystawki');
INSERT INTO recipe (id, name, image_url, description, category_id) values (1, 'Zupa pomidorowa', '/pomidorowa.jpg', 'Przepis na zupę pomidorową jak u mamy', 1);
INSERT INTO recipe (id, name, image_url, description, category_id) values (2, 'Rosół', '/rosol.jpg', 'Przepis na domowy rosół', 1);
INSERT INTO recipe (id, name, image_url, description, category_id) values (3, 'Roladki z tortilli', '/roladki.jpg','Roladki z tortilli z pastą jajeczną i awokado', 2);
INSERT INTO recipe (id, name, image_url, description, category_id) values (4, 'Koreczki', '/koreczki.jpg','Koreczki z chorizo, fetą i oliwkami', 2);