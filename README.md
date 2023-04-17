# WaterSupplyMgmt
## Setup
### Xampp
> 1. Start Apache and MySQL
> 
> 2. Navigate to Explorer file -> htdocs
>
> 3. Create a folder named "login"
> 
> 4. Copy paste the 4 php files into the folder: conn, login, register, and validate
>
> refer: https://youtu.be/GKyEJmCoK5s

### Localhost
> 1. In Google Chrome, navigate to http://localhost/phpmyadmin
>
> 2. Select Databases -> Create database (Database name = **water_supply_mgmt_user**)
>
> 3. Create new table (Table name = **users**, Column = **4**) 
>
> 4. Table Structure: id INT PRIMARY KEY, name VARCHAR(200), email VARCHAR(200), password VARCHAR(200)
>
> Note: **This is just a prior creation, might change anytime based on your team decisions.**

### Android Studio
> 1. Pull code from GitHub (Git -> Pull...)
>
> 2. Create Device Manager (Under Virtual, select Create Device)
>
> 3. Select Hardware (Under Phone Category, select any phone up to your preference)
>
> 4. Select System Image (Choose **Tiramisu**)
