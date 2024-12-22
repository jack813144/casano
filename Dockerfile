FROM gradle:7.6.0-jdk17 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Khai báo ARG và giá trị mặc định
ARG PORT=8080
ARG SONAR_LOGIN_KEY=SONAR_LOGIN_KEY

# Gán giá trị ARG vào ENV
ENV PORT=$PORT
ENV SONAR_LOGIN_KEY=$SONAR_LOGIN_KEY

# Sao chép các tệp vào container
COPY . .

# Chạy lệnh để xây dựng ứng dụng
RUN gradle build -x test --no-daemon

RUN sonar-scanner \
  -Dsonar.projectKey=Casano-BE-key \
  -Dsonar.sources=src \
  -Dsonar.java.binaries=build/classes \
  -Dsonar.host.url=https://sonar.leduys.online/ \
  -Dsonar.login=$SONAR_LOGIN_KEY

# Giai đoạn chạy ứng dụng
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Sao chép tệp JAR từ giai đoạn xây dựng
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE $PORT

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
