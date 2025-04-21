@echo off
echo Test verileri gonderiliyor...

echo COO1 kurye icin lokasyon 1 gonderiliyor...

curl -X POST http://localhost:8080/courier/locations -H "Content-Type: application/json" -d "{\"courierId\":\"C001\",\"latitude\":40.9924,\"longitude\":29.1245,\"timestamp\":\"2025-04-21T10:35:00\"}"

echo COO1 kurye icin lokasyon 2 gonderiliyor...

curl -X POST http://localhost:8080/courier/locations -H "Content-Type: application/json" -d "{\"courierId\":\"C001\",\"latitude\":40.9930,\"longitude\":29.1250,\"timestamp\":\"2025-04-21T10:37:00\"}"

::echo COO1 kurye icin lokasyon 3 gonderiliyor...

::curl -X POST http://localhost:8080/courier/locations -H "Content-Type: application/json" -d "{\"courierId\":\"C001\",\"latitude\":41.9930,\"longitude\":29.1250,\"timestamp\":\"2025-04-21T10:37:00\"}"

echo.
echo COO1 courier icin toplam mesafe cekiliyor...
curl -X GET http://localhost:8080/courier/C001/distance

echo.
echo COO2 courier icin toplam mesafe cekiliyor...
curl -X GET http://localhost:8080/courier/C002/distance

pause