# OffsideAI

OffsideAI is an intelligent football assistant built with **Spring Boot 3**, **Docker**, and modern backend practices.  
It focuses on delivering structured football data, predictions, and insights — designed to scale with microservices and cloud-native architecture in mind.

---

## Features (Planned & Ongoing)
- Match data management (teams, players, stats, season summaries)
- Prediction engine powered by AI (Gemini integration planned)
- REST APIs for consuming football insights
- Containerized setup with Docker + Docker Compose
- Clean architecture with modular services

---

## Tech Stack
- Backend: Java 21, Spring Boot 3
- Database: PostgreSQL (with JSONB for flexible data)
- Caching: Redis (planned)
- Containerization: Docker, Docker Compose
- AI: Google Gemini (planned)

---

## Project Structure
offsideAI/
┣ src/
┣ docker-compose.yml
┣ Dockerfile
┗ README.md


---

## Setup & Run
1. Clone the repository:
```bash
   git clone https://github.com/abhijeet4725/offsideAI.git
   cd offsideAI
```

2. Build and Run the Project:
The project comes with an execute.sh script that wraps the build (mvn clean install) and container startup (docker compose up).
   
Make it executable and run:
```
chmod +x execute.sh
./execute.sh
```

### Contributing
Contributions are welcome. Fork this repository, create a feature branch, and submit a pull request.

