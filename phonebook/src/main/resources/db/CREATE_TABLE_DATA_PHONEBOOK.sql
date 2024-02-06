CREATE TABLE data_phonebook(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL,
    boolean active_flag
);

CREATE SEQUENCE data_phonebook_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE date_phone_id_seq OWNED BY data_phonebook.id;

ALTER TABLE ONLY data_phonebook ALTER COLUMN id SET DEFAULT nextval('data_phonebook_id_seq'::regclass);

ALTER TABLE ONLY data_phonebook
    ADD CONSTRAINT data_phonebook_pkey PRIMARY KEY (id);
