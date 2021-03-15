insert into LM_GENRE (ID, GENRE_DESCRIPTION) values(1, 'Action and Adventure');
insert into LM_GENRE (ID, GENRE_DESCRIPTION) values(2, 'Classics');
insert into LM_GENRE (ID, GENRE_DESCRIPTION) values(3, 'Comic Book or Graphic Novel');

insert into LM_AUTHOR (ID, BIRTH_DATE, EMAIL, FULL_NAME, ORIGIN_CITY) values(1, '01-04-1564', 'shakespeare@gmail.com', 'William Shakespeare', 'Reino Unido');
insert into LM_AUTHOR (ID, BIRTH_DATE, EMAIL, FULL_NAME, ORIGIN_CITY) values(2, '07-01-1812', 'dickens@gmail.com', 'Charles Dickens', 'Reino Unido');
insert into LM_AUTHOR (ID, BIRTH_DATE, EMAIL, FULL_NAME, ORIGIN_CITY) values(3, '06-03-1927', 'marquez@gmail.com', 'Gabriel García Márquez', 'Ciudad de México');

insert into LM_EDITORIAL (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE) values(1, 'Salitre', 'alfaomega@gmail.com', 1000, 'Alfaomega Colombiana', '3507200000');
insert into LM_EDITORIAL (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE) values(2, 'Soacha', 'angosta@gmail.com', 2000, 'Angosta Editores', '3507200000');
insert into LM_EDITORIAL (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE) values(3, 'Suba', 'babel@gmail.com', 3000, 'Babel Libros', '3507200000');

insert into LM_BOOK (ID, PAGES_NUMBER, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID, GENRE_ID) values(1, 823, 'Moby-Dick', 1851, 1, 1, 2);