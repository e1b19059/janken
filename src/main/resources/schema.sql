CREATE TABLE users (
    id IDENTITY,
    name CHAR NOT NULL
);
CREATE TABLE matches (
    id IDENTITY NOT NULL PRIMARY KEY,
    user1 INT NOT NULL,
    user2 INT NOT NULL,
    user1Hand CHAR NOT NULL,
    user2Hand CHAR NOT NULL
);
