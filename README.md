# Progetto ASW

## Partecipanti:
- Bernardo Marino ()
- Damiano Massarelli (473486)
- Simone Ceccarelli ()

# Dominio Applicativo
### Il servizio S fornisce tre operazioni
- `s/<band>` restituisce il genere della band e il loro album più famoso.
- `s/<band>/<album>` restituisce il genere della band e l'anno di pubblicazione dell'album.
- `s/<band>/<album>/<canzone>` restituisce il genere della band, l'anno di pubblicazione dell'album e il numero della traccia nell'album.

### Per accedere ai servizi:
`http://localhost:8080/s/`...

### Build con gradle
Nella cartella è presente il file `build.sh` da eseguire per effettuare il build.

### Esecuzione
Eseguire il file `run.sh` presente nella cartella.
