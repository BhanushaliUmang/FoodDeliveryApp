# Food Delivery Platform API

* This is the documentation for the Food Delivery Platform API, which allows users to order food from restaurants. The API provides endpoints for normal users to place orders, view their order history, and authenticate themselves. It also allows administrators to manage food items, perform CRUD operations on them, and view order details.

## Table of Contents
* Authentication
* 1. Create endpoints for SingUp and SignIn

* Admin Endpoints
1. Add Food Item
2. Update Food Item
3. Delete Food Item
4. Get Order Details

## Authentication
* To access the API, normal users must be authenticated. This can be done by including a valid access token in the request headers. The access token can be obtained by logging in or registering as a user. Admin users have additional privileges and can perform CRUD operations on food items.

## Controller
* There are four Controller.
1. AdminController
2. FoodController
3. OrderController
4. UserController

## model
* There are five models.
1. Admin
2. FoodItem
3. User
4. Order
5. AuthenticationToken

## Service
* There are five service.
1. AdminService
2. FoodItemService
3. UserService
4. OrderService
5. TokenService

## Repository
* There are five repositories.
1. AdminRepository
2. FoodRepository
3. UserRepository
4. OrderRepository
5. TokenRepository
