
set -e

# Build and Package the project
mvn clean install -DskipTests

# Removing the un-synchronized containers
docker compose down -v

# Pulling and start all the containers needed:
docker compose up --build