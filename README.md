# PokedexManager-Backend

Il backend del progetto **PokedexManager** fornisce un'API per gestire, esplorare e organizzare i Pokémon. È costruito con **Javalin** e utilizza **MySQL** per la persistenza dei dati.

## **Caratteristiche Principali**
- Autenticazione e gestione utenti con **JWT**.
- Endpoint per gestire collezioni personali di Pokémon e liste dei desideri.
- API per esplorare dettagli e statistiche sui Pokémon.
- Gestione completa delle evoluzioni Pokémon.

## **Tecnologie Utilizzate**
- **Javalin**: Framework web leggero per Java.
- **MySQL**: Database relazionale per la persistenza dei dati.
- **JWT**: Autenticazione sicura tramite token.
- **Maven**: Strumento per la gestione delle dipendenze e la build del progetto.

## **Requisiti di Sistema**
- **Java Development Kit (JDK)**: Versione 11 o superiore.
- **Apache Maven**: Versione 3.6.0 o superiore.
- **MySQL Server**: Porta predefinita 3306.

## **Setup del Progetto**

### **1. Clona il Repository**
```bash
git clone https://github.com/Michelia5/PokedexManager-Backend.git
cd PokedexManager-Backend
```
### 2. Configura il Database
- **Crea un database MySQL denominato pokedex_v2.
- **Importa il dump del database:
```bash
mysql -u tuo_utente -p pokedex_v2 < "DB Dump/pokedex_v2.sql"
```
### 3. Configura il File application.properties
- **Modifica il file src/main/resources/application.properties con le credenziali corrette:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/pokedex_v2
spring.datasource.username=tuo_username
spring.datasource.password=tuo_password
```

## **Avvio del Progetto**

### **1. Compilazione ed Esecuzione**
Utilizza Maven per compilare ed eseguire l'applicazione:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass=com.infobasic.App
```
### 2. Accesso al Backend
L'applicazione sarà accessibile all'URL predefinito:
```bash
http://localhost:7000
```

## **Endpoint Principali**

### **Utenti**
- **POST /register**: Registra un nuovo utente.
- **POST /login**: Autentica un utente e restituisce un token JWT.

### **Pokémon**
- **GET /pokemon**: Restituisce la lista dei Pokémon.
- **GET /pokemon/{id}**: Restituisce i dettagli di un Pokémon specifico.

### **Collezioni**
- **GET /collections**: Restituisce i Pokémon della collezione personale.
- **POST /collections**: Aggiunge un Pokémon alla collezione personale.
- **DELETE /collections**: Rimuove un Pokémon dalla collezione.
- **PUT /collections**: Aggiorna lo stato di un Pokémon nella collezione.

## **Struttura del Progetto**
- **controller/**: Contiene i controller per gestire le richieste HTTP.
- **dao/**: Strato di accesso ai dati con implementazioni specifiche per MySQL.
- **model/**: Modelli di dati (es. Pokémon, Utenti, Collezioni).
- **service/**: Logica di business.
- **util/**: Utilità come la gestione dei token JWT.

## **DDL/DML e Dump del Database**
Gli script di creazione delle tabelle (DDL) e i dati iniziali sono forniti in:
```bash
/Database/ 
├── pokedex_v2.sql 
├── collections.csv 
├── pokemon_data.csv 
└── users.csv
```

## **Note**
- Un profilo utente di default è già presente per il login:
  - **Username**: Michele
  - **Password**: password123
- È comunque possibile registrare nuovi utenti tramite l'endpoint **POST /register**.
- La porta predefinita per il backend è **7000**. Assicurati che non ci siano conflitti con altre applicazioni.
- La connessione al database utilizza la porta **3306**, configurabile nel file `application.properties`.

### **Problemi Comuni**
- **Errore 500**: Assicurati che il database sia attivo e che le credenziali siano corrette.
- **Errore 401**: Verifica il token JWT o l'autenticazione dell'utente.

## **Contatti**
Per domande o supporto, puoi contattare il manutentore del progetto:

**Michele**  
Email: michele.caniglia5@gmail.com
