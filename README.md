# ExamVTMC
Knygų rezervavimo aplikacija

Aplikacija veikia su MySQL duombaze.
Norint paleisti aplikaciją reikės paleisti XAMPP servisus.
Pasileidus duombazei ir backendui, reikės įkelti roles į duombazės lentelę 'roles' su SQL komanda:

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

Įvykdžius šiuos žingsnius galima paleisti frontend su npm start

Jeigu viskas veiks teisingai, atsiras prisijungimo langas, apačioje galima pasirinkti registruotis ir susikurti naują vartotoją.
Vartotojo numatytoji rolė yra paprastas vartotojas(ROLE_USER), tad jei norima išbandyti administratoriaus funkcijas, reikės įvykdyti komandą MySQL duombazėje:

INSERT INTO user_roles VALUES((id), 2(roles id))

(id) reikės pakeisti į vartotojo id, kuris buvo sugeneruotas automatiškai.
