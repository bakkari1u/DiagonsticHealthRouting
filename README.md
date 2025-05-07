# 🏥 Diagnostic health routing API 

## 📌 Description

Cette api permet à partir d’un index de santé de déterminer l’unité médicale dans laquelle le patient doit être orienté.


---

## 🚀 Cloner et démarrer le projet

### 🔧 Prérequis

- Java 17
- Maven

### ▶️ Lancer l'application

```
git clone https://github.com/bakkari1u/DiagonsticHealthRouting.git
cd DiagonsticHealthRouting
mvn clean install
mvn spring-boot:run
```

### 🧪 Lancer les tests (unitaires et d'intégrations)

```
mvn test
```

### 📖 Documentation Swagger / OpenAPI

```
Une fois l'application démarrée, accédez à :

👉 http://localhost:8080/swagger-ui.html
```

### 🔍 Utilisation de l’API

```
🧠 Endpoint principal : 

👉 GET /api/health-routing/{index}

✅ Exemples des requetes et réponses attendues : 

| Requête                  | Réponse attendue           |
| ------------------------ | -------------------------- |
| `/api/health-routing/33` | Cardiologie                |
| `/api/health-routing/55` | Traumatologie              |
| `/api/health-routing/15` | Cardiologie, Traumatologie |
| `/api/health-routing/7`  | Aucune pathologie détectée |


```

