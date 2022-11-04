-- Categories
INSERT INTO category (qualification, description, url_image) VALUES ('Esportivos', 'Foco no desempenho dinâmico para o condutor, além de uma velocidade acima da média de outros veículos e com muita liberdade para dirigir', 'https://s2.glbimg.com/k48rKSt1_iM35y4_UUWk8tp3AAA=/1200x/smart/filters:cover():strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2018/B/5/PTZY4TStiTFosuj11llg/mercedes-amg-gt-4-02ca02280c1f083b.jpg');
INSERT INTO category (qualification, description, url_image) VALUES ('Elétricos', 'Carros elétricos não são movidos a base de combustão, e são exelentes para quem se preocupa meio-ambiente.', 'https://andreveiculos.com.br/blog/wp-content/uploads/2020/02/porsche-taycan.jpg');
INSERT INTO category (qualification, description, url_image) VALUES ('Luxo', 'O termo luxo é usado para categorizar veículos que estão equipados com melhores capacidades de desempenho, interiores luxuosos e todos os últimos recursos de segurança e tecnologia', 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2018-rolls-royce-phantom-1536152159.png');
INSERT INTO category (qualification, description, url_image) VALUES ('SUV', 'A sigla SUV significa Sport Utility Vehicle -- ou seja, veículo utilitário esportivo. As SUVs costumam ter porte avantajado, além de interior espaçoso e possibilidade de trafegar dentro e fora da cidade.', 'https://i0.wp.com/replicario.com.br/wp-content/uploads/2020/10/cadillac_2021_escalade_0397.jpg?fit=1200%2C628&ssl=1');

-- Cities
INSERT INTO city (name, country) VALUES ('Sorocaba', 'Brasil')
INSERT INTO city (name, country) VALUES ('Campinas', 'Brasil')
INSERT INTO city (name, country) VALUES ('São Paulo', 'Brasil')
INSERT INTO city (name, country) VALUES ('Recife', 'Brasil')

-- Products
INSERT INTO product (name, description, id_category, id_city) VALUES ('Rolls Royce Phantom', 'O Phantom é o sedan de grande porte da marca Rolls-Royce. O modelo é equipado com motor V12...', 3, 1)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Range Rover Evoque', 'Range Rover Evoque é um esportivo compacto da marca Land Rover. Seu design e potência são os...', 1, 1)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Porsche 911 Carreira','A silhueta do 911 Carrera é inconfundível, tem o DNA da marca Porsche desde 1963 tanto no design...', 1, 2)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Jeep Compass','Jeep Compass é um grande colecionador de prêmios, eleito “Melhor Compra do Ano” na categoria SUV Premium...', 4, 4)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Peugeot 208 e-GT','Experimente um novo nível de mobilidade com o Peugeot 208-e, número #1 na categoria de compactos elétricos', 2, 2)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Mercedes-Benz C300','Design único, tecnologia, conforto e potência definem a essência do Mercedes-Benz C300', 3, 3)
INSERT INTO product (name, description, id_category, id_city) VALUES ('BMW M2 Competition','Fabricado em Leipzig, na Alemanha, o BMW M2 é importado ao Brasil em versão única Competition...', 1, 3)
INSERT INTO product (name, description, id_category, id_city) VALUES ('Audi Q3 E-tron','Um SUV para toda a família, o Audi Q3 possui uma presença imponente, com bastante espaço interno...', 4, 4)

-- Features
INSERT INTO feature (name, icon) VALUES ('Ar-condicionado', 'https://cdn-icons-png.flaticon.com/512/5557/5557951.png')
INSERT INTO feature (name, icon) VALUES ('Blindagem', 'https://cdn-icons-png.flaticon.com/512/8796/8796826.png')
INSERT INTO feature (name, icon) VALUES ('4 portas', 'https://cdn-icons-png.flaticon.com/512/8664/8664896.png')
INSERT INTO feature (name, icon) VALUES ('Direção hidraulica', 'https://cdn-icons-png.flaticon.com/512/1723/1723597.png')
INSERT INTO feature (name, icon) VALUES ('Air bag', 'https://cdn-icons-png.flaticon.com/512/1793/1793065.png')
INSERT INTO feature (name, icon) VALUES ('ABS', 'https://cdn-icons-png.flaticon.com/512/638/638416.png')
INSERT INTO feature (name, icon) VALUES ('Mala Grande', 'https://cdn-icons-png.flaticon.com/512/7112/7112353.png')
INSERT INTO feature (name, icon) VALUES ('Vidro Eletrico', 'https://cdn-icons-png.flaticon.com/512/2061/2061890.png')
INSERT INTO feature (name, icon) VALUES ('Trava Elétrica', 'https://cdn-icons-png.flaticon.com/512/7142/7142859.png')
INSERT INTO feature (name, icon) VALUES ('Câmbio Automático', 'https://cdn-icons-png.flaticon.com/512/4805/4805737.png')

-- Images
--PS.: O Link da imagem do Rolls Royce está quebrado, trocar por outro!!!
INSERT INTO image (title, url_image) VALUES ('Rolls Royce Phantom', 'https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi3O0cadRmXuJtPJ-xrq9kGHcTNaVXreJl60YOd2VTaC0w2o4X8mLJZtA0WEHV9IYv0DwExWlS-KfuJhDbO1QHfGhdCE4W-9VJQLk8B0DHCXF7SJEf8r31sZyR1NKi4KDr2lDEhTBjv-Ej4a11UU_5di5dinYeFzr50jbdIe7v8SrmhTHvgF8u1CwW6eA/s2560/rolls-royce_phantom_1.png.jpg')
INSERT INTO image (title, url_image) VALUES ('Range Rover Evoque', 'https://s2.glbimg.com/5Bs7t4bUJudtPuPuHJ6zBueWs5g=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/r/k/muxO0lTfG83jjoysP1Kw/2019-08-22-range-rover-evoque-1.jpg')
INSERT INTO image (title, url_image) VALUES ('Porsche 911 Carreira', 'https://s2.glbimg.com/sJ4jOH48z4g-vYd9rpW_gcQIgc0=/0x0:1914x1261/924x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/D/s/8D8AVITVibR7BiPOiXeQ/new-carrera.jpg')
INSERT INTO image (title, url_image) VALUES ('Jeep Compass', 'https://s2.glbimg.com/NSpNy1wqX4odlioK28hLDuCRoFw=/1200x/smart/filters:cover():strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2021/F/Q/N7RznyQUyTVxwtqLxQCw/jeep-compass-2022-dianteira-movimento.jpeg')
INSERT INTO image (title, url_image) VALUES ('Peugeot 208 e-GT', 'https://quatrorodas.abril.com.br/wp-content/uploads/2020/09/Peugeot-208-Griffe-2021-2.jpg?quality=70&strip=info')
INSERT INTO image (title, url_image) VALUES ('Mercedes-Benz C300', 'https://quatrorodas.abril.com.br/wp-content/uploads/2022/03/DSCF2608-e1646351549605.jpg?quality=70&strip=info')
INSERT INTO image (title, url_image) VALUES ('BMW M2 Competition', 'https://quatrorodas.abril.com.br/wp-content/uploads/2020/11/2020-bmw-m2-cs-limited-edition-13.jpg?quality=70&strip=info&w=1024&resize=1200,800')
INSERT INTO image (title, url_image) VALUES ('Audi Q3 E-tron', 'https://www.autoo.com.br/fotos/2021/12/1280_960/Audi4_14122021_70084_1280_960.jpg')

-- Relacionamento entre as tabelas Category e Product
--INSERT INTO category_product (id_category, id_product) VALUES (1,2);
--INSERT INTO category_product (id_category, id_product) VALUES (1,3);
--INSERT INTO category_product (id_category, id_product) VALUES (1,7);
--INSERT INTO category_product (id_category, id_product) VALUES (2,5);
--INSERT INTO category_product (id_category, id_product) VALUES (3,1);
--INSERT INTO category_product (id_category, id_product) VALUES (3,6);
--INSERT INTO category_product (id_category, id_product) VALUES (4,4);
--INSERT INTO category_product (id_category, id_product) VALUES (4,8);

-- Relacionamento entre as tabelas City e Product
--INSERT INTO city_product (id_city, id_product) VALUES (1,1);
--INSERT INTO city_product (id_city, id_product) VALUES (1,2);
--INSERT INTO city_product (id_city, id_product) VALUES (2,3);
--INSERT INTO city_product (id_city, id_product) VALUES (2,5);
--INSERT INTO city_product (id_city, id_product) VALUES (3,6);
--INSERT INTO city_product (id_city, id_product) VALUES (3,7);
--INSERT INTO city_product (id_city, id_product) VALUES (4,4);
--INSERT INTO city_product (id_city, id_product) VALUES (4,8);

-- Relacionamento entre as tabelas Product e Feature
INSERT INTO product_feature (id_product, id_feature) VALUES (1,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,2);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,9);
INSERT INTO product_feature (id_product, id_feature) VALUES (1,10);

INSERT INTO product_feature (id_product, id_feature) VALUES (2,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,9);
INSERT INTO product_feature (id_product, id_feature) VALUES (2,10);

INSERT INTO product_feature (id_product, id_feature) VALUES (3,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (3,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (3,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (3,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (3,9);

INSERT INTO product_feature (id_product, id_feature) VALUES (4,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (4,9);

INSERT INTO product_feature (id_product, id_feature) VALUES (5,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (5,9);

INSERT INTO product_feature (id_product, id_feature) VALUES (6,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,2);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,9);
INSERT INTO product_feature (id_product, id_feature) VALUES (6,10);

INSERT INTO product_feature (id_product, id_feature) VALUES (7,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (7,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (7,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (7,9);

INSERT INTO product_feature (id_product, id_feature) VALUES (8,1);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,3);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,4);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,5);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,6);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,7);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,8);
INSERT INTO product_feature (id_product, id_feature) VALUES (8,9);

-- User
--INSERT INTO usuario (name, lastname, login, password) VALUES ('aila','torres','aila@gmail.com', '312456789');
--INSERT INTO AppUser (name, username, email, password, appUserRoles ) VALUES ('aila','torres','aila@gmail.com', '312456789', 'ROLE_USER');

--  private String name;
--    private String username;
--    private String email;
--    private String password;
--    @Enumerated(EnumType.STRING)
--    private AppUserRoles appUserRoles;