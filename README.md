<h1>Dvostrane SSL/TLS autentikacija između REST servisa uporabom digitalnih certifikata</h1>
<h4>Fakultet Organizacije i informatike, Varaždin</h4>
<p>Ovaj projekt rađen je za potrebe praktičnog dijela istoimenog seminarskog rada na kolegiju Sigurnost informacijskih sustava</p>
<p><b>Autor projekta:</b><br/>
Mario Špicar<br/>
Datum 08.07.2019.<br/>
<hr>
<p>Projekt sadržava dva identična programska projekta izrađena pomoću SpringBoot okvira.</p>
-demoservice1 (REST Servis sa certifikatom SAN = demoservice1, localhost)<br/>
-demoservice2 (REST Servis sa certifikatom SAN = demoservice2, localhost)<br/><br/>
<p>Nakon build-a servisi se mogu pokrenuti pomoću naredbe:<br/><br/> 
java -jar demoservice-0.0.1-S1.jar<br/>
java -jar demoservice-0.0.1-S2.jar<br/></p>
<p>Za iniciranje komunikacije korišten je klijent za slanje REST poruka "Postman"<br/>
Poruka je sljedećeg formata:
</p>
<pre>{
    "messageID": 0,
    "messageDescription": "Hello!"
}</pre><br/>
<p>Slanjem poruke na servis 1 poruka se usmjerava na servis 2,<br/>
servis 2 je ispisuje se na ekran i vraća rezultat natrag servisu 1 koji je vraća klijentu!<br/><br/>
Postavke vezane uz certifikate i konfiguracija poveznica nalaze se u application.properties datoteci!</p>