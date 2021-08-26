CREATE TABLE accounts
(
    id           BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(31),
    balance      BIGINT,
    credit_card  VARCHAR(255),
    account_number BIGINT NOT NULL UNIQUE
);

CREATE TABLE clients
(
    id               BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    email            VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255),
    address          VARCHAR(255),
    phone            BIGINT,
    birth_date       datetime,
    has_credit_level BIT(1) DEFAULT 0
);

CREATE TABLE clients_accounts
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    fk_accounts_id BIGINT,
    fk_clients_id  BIGINT
);



ALTER TABLE clients_accounts
    ADD FOREIGN KEY (fk_accounts_id) references accounts (id),
    ADD FOREIGN KEY (fk_clients_id) references clients (id);












