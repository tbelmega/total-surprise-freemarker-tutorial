CREATE TABLE customer(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NOT NULL,
    birthyear BIGINT NOT NULL
);

INSERT INTO customer VALUES(1, 'Chuck', 'Norris', 1963);
INSERT INTO customer VALUES(2, 'Donald', 'Duck', 2007);
INSERT INTO customer VALUES(3, 'Rincewind', 'der Zauberer', 1886);