CREATE TABLE users
(
    id        BIGSERIAL PRIMARY KEY,
    avatar    VARCHAR(256) NOT NULL,
    full_name VARCHAR(256) NOT NULL,
    email     VARCHAR(256) NOT NULL UNIQUE ,
    online    BOOLEAN
);


INSERT INTO users(avatar, full_name, email, online)
VALUES ('/image/avatar1', 'Zhasulan', 'zhasulan@gmail.com', true),
       ('/image/avatar2', 'Aslan', 'aslan@gmail.com', false);