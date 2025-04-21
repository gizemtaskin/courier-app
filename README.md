# 📦 Geo Tracker Application

Bu proje, Java ve Spring Boot kullanılarak geliştirilmiş bir RESTful web uygulamasıdır. Kuryelerin anlık konum bilgilerini alır, bu veriler üzerinden Migros mağazalarına 100 metre yaklaşımları loglar ve toplam seyahat mesafelerini hesaplar.

---

## 🚀 Özellikler

- 📍 Kuryeden konum verisi alma ve saklama
- 🏪 Mağaza yakınlığı (100m) algılama ve loglama
- ⏱ Aynı mağazaya 1 dakikadan kısa sürede tekrar girişleri yok sayma
- 📊 Kurye bazlı toplam seyahat mesafesi hesaplama
- 🧱 H2 veritabanı ile geçici veri saklama
- 🛠 Strategy & Observer Design Pattern kullanımı

---

## ⚙️ Gereksinimler

- Java 17+
- Maven 3.6+
- (Opsiyonel) curl yüklü olması — otomatik test için

---

## 🛠 Uygulamanın Çalıştırılması

### 1. Script ile hızlı başlatma

run.bat
test.bat

### 2. Maven ile manuel çalıştırma

```bash
mvn clean install
mvn spring-boot:run
