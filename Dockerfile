# Стадия сборки
FROM eclipse-temurin:24-jdk as builder

WORKDIR /app

# Копируем только нужные файлы для кэширования зависимостей
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Загружаем зависимости (кэшируем слой)
RUN ./mvnw dependency:go-offline

# Копируем весь исходный код
COPY src ./src

# Собираем jar
RUN ./mvnw clean package -DskipTests

# Финальный образ
FROM eclipse-temurin:24-jdk

WORKDIR /app

# Копируем собранный jar из стадии сборки
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "app.jar"]
