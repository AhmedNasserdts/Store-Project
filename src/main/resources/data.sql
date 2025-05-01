-- Insert sample products with auto-generated IDs and current timestamp
INSERT INTO product (name, description, brand, category, price, stock_Quantity, available, date) VALUES
('iPhone 13', 'Latest Apple smartphone with A15 Bionic chip', 'Apple', 'Smartphones', 799.99, 50, true, CURRENT_TIMESTAMP),
('Galaxy S22', 'Samsung flagship with Dynamic AMOLED display', 'Samsung', 'Smartphones', 749.99, 35, true, CURRENT_TIMESTAMP),
('AirPods Pro', 'Active noise cancelling wireless earbuds', 'Apple', 'Audio', 249.99, 100, true, CURRENT_TIMESTAMP),
('PlayStation 5', 'Next-gen gaming console with ultra-high speed SSD', 'Sony', 'Gaming', 499.99, 10, true, CURRENT_TIMESTAMP),
('MacBook Pro 14"', 'Professional laptop with M1 Pro chip', 'Apple', 'Laptops', 1999.99, 25, true, CURRENT_TIMESTAMP),
('Echo Dot 4th Gen', 'Smart speaker with Alexa', 'Amazon', 'Smart Home', 49.99, 200, true, CURRENT_TIMESTAMP),
('Kindle Paperwhite', 'Waterproof e-reader with 6.8" display', 'Amazon', 'E-Readers', 139.99, 75, true, CURRENT_TIMESTAMP),
('Bose QuietComfort 45', 'Premium noise-cancelling headphones', 'Bose', 'Audio', 329.99, 40, true, CURRENT_TIMESTAMP),
('Dell XPS 15', '15.6" laptop with InfinityEdge display', 'Dell', 'Laptops', 1499.99, 30, true, CURRENT_TIMESTAMP),
('Nintendo Switch OLED', 'Handheld gaming console with 7" OLED screen', 'Nintendo', 'Gaming', 349.99, 15, true, CURRENT_TIMESTAMP);