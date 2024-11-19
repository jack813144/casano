FROM gradle:7.6.0-jdk17 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Sao chép các tệp vào container
COPY . .

# Chạy lệnh để xây dựng ứng dụng
RUN gradle build -x test --no-daemon


# Giai đoạn chạy ứng dụng
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Sao chép tệp JAR từ giai đoạn xây dựng
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
