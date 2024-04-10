-- Drops the FWRP database if it exists
DROP DATABASE IF EXISTS FoodWasteReduction;

-- Creates the FWRP database
CREATE DATABASE FoodWasteReduction;

-- Selects the FWRP database for use
USE FoodWasteReduction;

-- Creates a Users table
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    UserType ENUM('retailer', 'consumer', 'charity') NOT NULL
);

-- Creates a FoodItems table
CREATE TABLE FoodItems (
    FoodItemID INT AUTO_INCREMENT PRIMARY KEY,
    RetailerID INT,
    Name VARCHAR(255) NOT NULL,
    Quantity INT NOT NULL,
    ExpirationDate DATE NOT NULL,
    Status ENUM('available', 'reserved', 'donated') NOT NULL DEFAULT 'available',
    FOREIGN KEY (RetailerID) REFERENCES Users(UserID) ON DELETE CASCADE
);

-- Creates a SurplusFoodItems table
CREATE TABLE SurplusFoodItems (
    SurplusItemID INT AUTO_INCREMENT PRIMARY KEY,
    FoodItemID INT,
    ListingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    SalePrice DECIMAL(10,2),
    IsDonation BOOLEAN NOT NULL,
    FOREIGN KEY (FoodItemID) REFERENCES FoodItems(FoodItemID) ON DELETE CASCADE
);

-- Creates a Transactions table
CREATE TABLE Transactions (
    TransactionID INT AUTO_INCREMENT PRIMARY KEY,
    SurplusItemID INT,
    UserID INT,
    TransactionDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    QuantityClaimed INT NOT NULL,
    FOREIGN KEY (SurplusItemID) REFERENCES SurplusFoodItems(SurplusItemID) ON DELETE CASCADE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

-- Creates a Subscriptions table
CREATE TABLE Subscriptions (
    SubscriptionID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    Location VARCHAR(255),
    Preferences TEXT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE
);

-- Creates an Alerts table
CREATE TABLE Alerts (
    AlertID INT AUTO_INCREMENT PRIMARY KEY,
    SubscriptionID INT,
    SurplusItemID INT,
    AlertDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Status ENUM('sent', 'pending') NOT NULL DEFAULT 'pending',
    FOREIGN KEY (SubscriptionID) REFERENCES Subscriptions(SubscriptionID) ON DELETE CASCADE,
    FOREIGN KEY (SurplusItemID) REFERENCES SurplusFoodItems(SurplusItemID) ON DELETE CASCADE
);