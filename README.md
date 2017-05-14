# Progetto ASW

## Partecipanti:
- Bernardo Marino (474949)
- Damiano Massarelli (473486)
- Simone Ceccarelli (475146)

# Dominio Applicativo
### Il servizio S fornisce tre operazioni
- `s/<band>` restituisce il genere della band e il loro album più famoso.
- `s/<band>/<album>` restituisce il genere della band e l'anno di pubblicazione dell'album.
- `s/<band>/<album>/<canzone>` restituisce il genere della band, l'anno di pubblicazione dell'album e il numero della traccia nell'album.

### Per accedere ai servizi:
`http://localhost:8080/s/`...

Oppure all'indirizzo `http://localhost:8080` sono presenti esempi già compilati.

### Build con gradle
Nella cartella è presente il file `build.sh` da eseguire per effettuare il build.

### Esecuzione
Il file `run.sh` permette di eseguire tutti i servizi con un unico comando (e nello stesso terminale).
Per eseguire i servizi in modo indipendente sono presenti i relativi script (`run_s.sh`, `run_s1.sh`, ecc...).

### Terminare l'esecuzione
Se si usa `run.sh`, l'esecuzione di tutti i processi può essere fermata tramite `kill.sh`.
