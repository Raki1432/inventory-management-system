# 🧾 Inventory Management System

A **Spring Boot + MongoDB** based REST API for managing products and their stock levels efficiently.  
This project supports full **CRUD operations**, dynamic stock management, and low-stock monitoring.

---

## 🚀 Features

- ➕ Add new products with name, description, quantity, and stock threshold  
- 🔍 Retrieve all products or a specific product by ID  
- ✏️ Update existing product details  
- ❌ Delete products  
- 📈 Increase or 📉 decrease product stock dynamically  
- ⚠️ Fetch all **low-stock products** automatically  
- 💾 Persistent data storage using **MongoDB**

---

## 🧰 Tech Stack

| Layer | Technology |
|--------|-------------|
| **Backend Framework** | Spring Boot 3 |
| **Database** | MongoDB |
| **Build Tool** | Maven |
| **Language** | Java 17 |
| **API Testing** | Postman |
| **Version Control** | Git & GitHub |

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Raki1432/inventory-management-system.git
cd inventory-management-system

---

2️⃣ Open the Project

Open the project in IntelliJ IDEA or VS Code (with Java extensions).

Wait for Maven to download all dependencies automatically.
---
3️⃣ Start MongoDB

Ensure MongoDB is running locally before launching the app.
```bash
mongosh
---


Verify the available databases:
```bash
show dbs
---

⚙️ Configuration

In your application.properties, add the following:
```bash
spring.application.name=inventory-management
spring.data.mongodb.uri=mongodb://localhost:27017/inventorydb
---

▶️ Running the Application

Start the application using one of the following methods:

mvn spring-boot:run


or directly from your IDE by running the InventoryManagementApplication class.

Once started, visit:
📍 http://localhost:8080

📡 API Endpoints
Method	Endpoint	Description
POST	/api/products	Add a new product
GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
PUT	/api/products/{id}	Update a product
DELETE	/api/products/{id}	Delete a product
POST	/api/products/{id}/increase?amount=10	Increase stock
POST	/api/products/{id}/decrease?amount=5	Decrease stock
GET	/api/products/low-stock	Fetch low-stock products
📘 Example Request (JSON)

POST → /api/products

{
  "name": "Wireless Mouse",
  "description": "Logitech M170",
  "stockQuantity": 25,
  "lowStockThreshold": 10
}

🧩 Verify Data in MongoDB

After inserting data through Postman, check MongoDB:

use inventorydb
show collections
db.products.find().pretty()





