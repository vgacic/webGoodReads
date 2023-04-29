INSERT INTO KORISNIK(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga) VALUES(1, '1995-1-1', 'Marko', 'mmarkovic','marko123','marko@gmail.com','radnik','Markovic','slika.jpg','citalac');
INSERT INTO KORISNIK(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga) VALUES(2, '1996-2-2', 'Sara', 'ssaric','sara123','sara@uns.ac.rs','nastavnik','Saric','slika123.jpg','autor');
INSERT INTO KORISNIK(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga) VALUES(3, '1997-3-3', 'Mirko', 'mmirko','mirko123','mirko@gmail.com','zaposleni','Mikic','slika122.jpg','administrator');
INSERT INTO KORISNIK(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga) VALUES(4, '1998-4-4', 'Lana', 'llana','lana123','lana@uns.ac.rs','student','Peric','slika111.jpg','autor');


INSERT INTO AUTOR(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga, aktivan) VALUES(1,'1996-2-2','Sara', 'ssaric','sara123','sara@uns.ac.rs','nastavnik','Saric','slika123.jpg','autor',true);
INSERT INTO AUTOR(id, datum_Rodjenja, ime, korisnicko_Ime, lozinka, email, opis, prezime, profilna_Slika, uloga, aktivan) VALUES(2,'1998-4-4','Lana', 'llana','lana123','lana@uns.ac.rs','student','Peric','slika111.jpg','autor', false);


INSERT INTO ZANR(id, naziv) VALUES(1, 'Novela');
INSERT INTO ZANR(id, naziv) VALUES(2, 'Roman');
INSERT INTO ZANR(id, naziv) VALUES(3, 'Strucna knjiga');

INSERT INTO POLICA(id ,naziv ,primarna) VALUES(1, 'polica 1',true);
INSERT INTO POLICA(id ,naziv ,primarna) VALUES(2, 'polica 2',false);

INSERT INTO STAVKA_POLICE(id, polica_id) VALUES(1,1);
INSERT INTO STAVKA_POLICE(id, polica_id) VALUES(2,1);
INSERT INTO STAVKA_POLICE(id, polica_id) VALUES(3,2);

INSERT INTO KNJIGA(id, ISBN, broj_Strana, datum_Objavljivanja, naslov, naslovna_Fotografija, ocena, opis, zanr, autor_id, stavka_police_id) VALUES(1,'978-3-16-148410-0', 1000,'2020-2-2','Ana Karenjina','',10,'Zanimljivo', 1, 1, 1);
INSERT INTO KNJIGA(id, ISBN, broj_Strana, datum_Objavljivanja, naslov, naslovna_Fotografija, ocena, opis, zanr, autor_id, stavka_police_id) VALUES(2,'978-3-16-148410-1',200,'2019-3-3','Bela griva','', 6, 'Onako',2, 2, 2);
INSERT INTO KNJIGA(id, ISBN, broj_Strana, datum_Objavljivanja, naslov, naslovna_Fotografija, ocena, opis, zanr, autor_id, stavka_police_id) VALUES(3,'978-3-16-148410-2',300,'2017-4-4', 'Bele klizaljke','', 9,'Odlicna knjiga',2, 2, 3);
INSERT INTO KNJIGA(id, ISBN, broj_Strana, datum_Objavljivanja, naslov, naslovna_Fotografija, ocena, opis, zanr, autor_id, stavka_police_id) VALUES(4,'978-3-16-148410-3',400,'2020-5-5','Osnove finansijskog inzenjeringa 1','',8,'Super',3,1,3);


INSERT INTO RECENZIJA(id,datum_Recenzije, ocena, tekst, korisnik_id, stavka_police_id) VALUES(1,'2023-1-1',10,'Odlicna knjiga',1,1);
INSERT INTO RECENZIJA(id,datum_Recenzije, ocena, tekst, korisnik_id, stavka_police_id) VALUES(2,'2023-2-2',9,'Dobra knjiga',1,2);
INSERT INTO RECENZIJA(id,datum_Recenzije, ocena, tekst, korisnik_id, stavka_police_id) VALUES(3,'2023-3-3',8,'Solidno',1,3);
INSERT INTO RECENZIJA(id,datum_Recenzije, ocena, tekst, korisnik_id, stavka_police_id) VALUES(4,'2023-4-4',7,'Moze bolje',1,2);
INSERT INTO RECENZIJA(id,datum_Recenzije, ocena, tekst, korisnik_id, stavka_police_id) VALUES(5,'2023-5-5',6,'Ne dopada mi se',1,1);


INSERT INTO ZAHTEV_ZA_AKTIVACIJU_NALOGA_AUTORA(id, datum, email, poruka, stanje, telefon) VALUES(1,'2015-1-1','sara@uns.ac.rs','Zahtev prihvacen.','ODOBREN','0615566381');
INSERT INTO ZAHTEV_ZA_AKTIVACIJU_NALOGA_AUTORA(id, datum, email, poruka, stanje, telefon) VALUES(2,'2015-2-2','lana@uns.ac.rs','Zahtev prihvacen','ODOBREN','0645566372');